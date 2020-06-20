package com.company.enterprise;

import com.company.enums.Journey;
import com.company.planes.Plane;
import java.util.Date;

public class UserMenu {

    public UserMenu() {
    }
/*
    public Flight confirmFligth(Date date, Journey journey, Plane plane, User user, int passengers){
        Flight flight = new Flight(date, journey, plane, user, passengers, getCost(journey, plane, passengers));
        user.addTrips(flight);
        String categoryPlane = plane.getClass().getSimpleName();
        String bestCategory = user.getBestCategory();

        if(bestCategory.isBlank()) {
            user.setBestCategory(categoryPlane);
        }
        else if(checkCategory(user, categoryPlane)){
            user.setBestCategory(categoryPlane);
        }

        return flight;
    }
*/
    public double getCost(Journey journey, Plane plane, int passengers){
        return ((journey.getDistance() * plane.getPricePerKm()) + (passengers * 3500) + plane.getRate());
    }

    private boolean checkCategory(User user, String category){
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
