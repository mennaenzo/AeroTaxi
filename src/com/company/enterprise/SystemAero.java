package com.company.enterprise;

import com.company.enums.City;
import com.company.enums.Journey;
import com.company.fileManagement.Storage;
import com.company.planes.Plane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SystemAero {
    private HashMap<Date, ArrayList<Plane>> available;

    public HashMap<Date, ArrayList<Plane>> getAvailable() {
        return available;
    }

    public void setAvailable(HashMap<Date, ArrayList<Plane>> available) {
        this.available = available;
    }

    public int getMaxPassengers(Date date) {
        int max = 0;

        if(!available.containsKey(date)){
            ArrayList<Plane> planes = Storage.getPlanes();
            for (Plane plane: planes) {
                if(plane.getPassengers() > max)
                    max = plane.getPassengers();
            }
        }
        else{
            ArrayList<Plane> planes1 = available.get(date);
            for (Plane plane: planes1) {
                if(plane.getPassengers() > max)
                    max = plane.getPassengers();
            }
        }
        return max;
    }

    public SystemAero() {

    }

    public void setUp(){
        Storage.firstData();


    }

    private Flight checkIn(User user){
        System.out.print("Select Date(DD/MM/YY HH:MM): ");
        Scanner scanner = new Scanner(System.in);
        String scannerDate = scanner.nextLine();

        Date date = checkDate(scannerDate);
        String origin = menuOrigin(scanner);
        if(origin == null) {
            System.out.println("Please select a number between 1 and 4. Last chance!");
            origin = menuOrigin(scanner);
        }
        if(origin != null) {
            String destination = menuDestination(scanner, origin);
            if(destination == null) {
                System.out.println("Please select a number between 1 and 3. Last chance!");
                destination = menuDestination(scanner, origin);
            }
            if(destination != null){
                Journey journey = Journey.compare(origin,destination);
                System.out.println("Please enter the number of your companions");
                int companions = scanner.nextInt();
                int maxPassenger = getMaxPassengers(date);

                if(companions+1 <= maxPassenger){
                    Plane plane = planeAvailable(date, maxPassenger);
                    System.out.println("Cost " + plane.getModel() + " : ");
                    System.out.println("1 - Accept");
                    System.out.println("2 - Cancel");
                    int accept = scanner.nextInt();

                    //ciclarlo y modularizar
                    switch (accept){
                        case 1:
                            UserMenu.getCost(journey, plane, companions+1);
                            return UserMenu.confirmFligth(date, journey, plane, user, companions+1);
                            break;
                        case 2:
                            return null;
                            break;
                        default:
                            System.out.println("Please select 1 or 2. Choose again!");
                            break;
                    }
                }
            }
        }
        return null;
    }

    private Date checkDate(String scannerDate){
        SimpleDateFormat simpleDate = new SimpleDateFormat();
        Date date = new Date();

        try {
            date = simpleDate.parse(scannerDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    private String menuOrigin(Scanner scanner){
        printOrigin();
        int numberChose = scanner.nextInt();
        String origin;

        switch (numberChose) {
            case 1:
                origin = City.BSAS.getName();
                break;
            case 2:
                origin = City.STG.getName();
                break;
            case 3:
                origin = City.CDB.getName();
                break;
            case 4:
                origin = City.MTV.getName();
                break;
            default:
                origin = null;
                break;
        }

        return origin;
    }

    private String menuDestination(Scanner scanner, String origin){
        int numberChose;
        int option = printDestination(origin);

        numberChose = scanner.nextInt();
        String destination = null;
        System.out.println(numberChose);

        switch (option) {
            case 1:
                if (numberChose == 1) {
                    destination = City.STG.getName();
                }
                else if (numberChose == 2) {
                    destination = City.CDB.getName();
                }
                else if (numberChose == 3) {
                    destination = City.MTV.getName();
                }
                break;
            case 2:
                if (numberChose == 1) {
                    destination = City.BSAS.getName();
                }
                else if (numberChose == 2) {
                    destination = City.CDB.getName();
                }
                else if (numberChose == 3) {
                    destination = City.MTV.getName();
                }
                break;
            case 3:
                if (numberChose == 1) {
                    destination = City.BSAS.getName();
                }
                else if (numberChose == 2) {
                    destination = City.STG.getName();
                }
                else if (numberChose== 3) {
                    destination = City.MTV.getName();
                }
                break;
            case 4:
                if (numberChose == 1) {
                    destination = City.BSAS.getName();
                }
                else if (numberChose == 2) {
                    destination = City.STG.getName();
                }
                else if (numberChose == 3) {
                    destination = City.CDB.getName();
                }
                break;
            default:
                destination = null;
                break;
        }

        return destination;
    }

    private void printOrigin(){
        System.out.println("Select Origin (1-4):");
        System.out.println("    1 - BUENOS AIRES");
        System.out.println("    2 - SANTIAGO");
        System.out.println("    3 - CORDOBA");
        System.out.println("    4 - MONTEVIDEO");
        System.out.print("Option: ");
    }

    private int printDestination(String origin){
        if (origin.equals(City.BSAS.getName())) {
            System.out.println("Select Destination (1-3):");
            System.out.println("    1 - SANTIAGO");
            System.out.println("    2 - CORDOBA");
            System.out.println("    3 - MONTEVIDEO");
            System.out.print("Option: ");
            return 1;
        } else if (origin.equals(City.STG.getName())) {
            System.out.println("Select Destination (1-3):");
            System.out.println("    1 - BUENOS AIRES");
            System.out.println("    2 - CORDOBA");
            System.out.println("    3 - MONTEVIDEO");
            System.out.print("Option: ");
            return 2;
        } else if (origin.equals(City.CDB.getName())) {
            System.out.println("Select Destination (1-3):");
            System.out.println("    1 - BUENOS AIRES");
            System.out.println("    2 - SANTIAGO");
            System.out.println("    3 - MONTEVIDEO");
            System.out.print("Option: ");
            return 3;
        } else if (origin.equals(City.MTV.getName())) {
            System.out.println("Select Destination (1-3):");
            System.out.println("    1 - BUENOS AIRES");
            System.out.println("    2 - SANTIAGO");
            System.out.println("    3 - CORDOBA");
            System.out.print("Option: ");
            return 4;
        }
        return 0;
    }

    public Plane planeAvailable(Date date, int maxPassengers){
        int i = 1;
        if(available.containsKey(date)) {
            ArrayList<Plane> listPlaneAvailable = available.get(date);
            for (Plane plane: listPlaneAvailable){
                System.out.println("Opcion: " + i);
                i++;
                System.out.println(plane.toString());
                System.out.println("\n");
            }
            System.out.println("Plase choose the plane where you want to travel");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            if(opcion <= listPlaneAvailable.size()+1){
                return listPlaneAvailable.get(opcion),
            }
            else
                return null;
        }
    }


}
