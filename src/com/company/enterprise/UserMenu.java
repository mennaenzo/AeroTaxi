package com.company.enterprise;

import com.company.enums.Journey;
import com.company.planes.Plane;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class UserMenu {

    public UserMenu() {
    }

    public static Flight confirmFlight(Date date, Journey journey, Plane plane, User user, int passengers){
        Flight flight = new Flight(date, journey, plane, user.getName(), passengers, getCost(journey, plane, passengers));
        user.addCheckIn(flight);
        String categoryPlane = plane.getClass().getSimpleName();
        String bestCategory = user.getBestCategory();

        if(bestCategory == null) {
            user.setBestCategory(categoryPlane);
        }
        else if(checkCategory(user, categoryPlane)){
            user.setBestCategory(categoryPlane);
        }
        return flight;
    }

    public static boolean cancelFlight(User user){
        if(!user.getCheckIn().isEmpty()){
            System.out.println("Choose the flight to cancel: ");
            user.listFlights();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if(option <= user.getCheckIn().size()){
                if(inTime(user.getCheckIn().get(option-1))) {
                    user.getCheckIn().remove(option - 1);
                    return true;
                }
                else
                    System.out.println("The flight cannot be canceled with less than 24 hours.");
            }
            else {
                System.out.println("NUMBER ERROR");
            }
        }
        else
            System.out.println("You don't have flights.");
        return false;
    }

    public static boolean inTime(Flight cancelFlight){
        Date today = new Date();
        Date flightTime = cancelFlight.getDate();
        return getDifferenceBetwenDates(today,flightTime);
    }

    private static boolean getDifferenceBetwenDates(Date hourToday, Date hourFlight) {
        long milliseconds = hourFlight.getTime() - hourToday.getTime();
        int day = (int) ((milliseconds / (1000 * 60 * 60 * 24)));
        return day > 0;
    }

    public static double getCost(Journey journey, Plane plane, int passengers){
        return ((journey.getDistance() * plane.getPricePerKm()) + (passengers * 3500) + plane.getRate());
    }

    private static boolean checkCategory(User user, String category){
        String bestCategory = user.getBestCategory();

        if (bestCategory.equals("Bronze")) {
            return !category.equals("Bronze");
        }
        else if (bestCategory.equals("Silver")) {
            return category.equals("Gold");
        }
        return false;
    }

}
