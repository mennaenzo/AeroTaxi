package com.company.enterprise;

import com.company.enums.City;
import com.company.enums.Journey;
import com.company.planes.Plane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SystemAero {
    private final HashMap<Date, ArrayList<Plane>> available;
    private int maxPassengers;

    public SystemAero() {
        available = new HashMap<>();

    }

    public void setUp(){
        // cargar aviones, maxpass, hashmap, etc
    }

    public void checkIn(User user){
        System.out.print("Select Date(DD/MM/YY HH:MM): ");
        Scanner scanner = new Scanner(System.in);
        String scannerDate = scanner.nextLine();

        Date date = checkDate(scannerDate);
        String origin = menuOrigin(scanner);
        if(origin == null) {
            System.out.println("Please select a number between 1 and 4. Last chance!");
            origin = menuOrigin(scanner);
            if(origin != null) {
                String destination = menuDestination(scanner, origin);
                if(destination == null) {
                    System.out.println("Please select a number between 1 and 3. Last chance!");
                    destination = menuDestination(scanner, origin);
                }
                else{
                    //Journey journey = Journey.compare(origin,destination); // OPTIMIZE
                }
            }
        }
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
                origin = City.BSAS.toString();
                break;
            case 2:
                origin = City.STG.toString();
                break;
            case 3:
                origin = City.CDB.toString();
                break;
            case 4:
                origin = City.MTV.toString();
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

        switch (numberChose) {
            case 1:
                if (option == 1) {
                    destination = City.STG.toString();
                }
                else if (option == 2) {
                    destination = City.CDB.toString();
                }
                else if (option == 3) {
                    destination = City.MTV.toString();
                }
                break;
            case 2:
                if (option == 1) {
                    destination = City.BSAS.toString();
                }
                else if (option == 2) {
                    destination = City.CDB.toString();
                }
                else if (option == 3) {
                    destination = City.MTV.toString();
                }
                break;
            case 3:
                if (option == 1) {
                    destination = City.BSAS.toString();
                }
                else if (option == 2) {
                    destination = City.STG.toString();
                }
                else if (option == 3) {
                    destination = City.MTV.toString();
                }
                break;
            case 4:
                if (option == 1) {
                    destination = City.BSAS.toString();
                }
                else if (option == 2) {
                    destination = City.STG.toString();
                }
                else if (option == 3) {
                    destination = City.CDB.toString();
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
        if (origin.equals("BSAS")) {
            System.out.println("Select Destination (1-3):");
            System.out.println("    1 - SANTIAGO");
            System.out.println("    2 - CORDOBA");
            System.out.println("    3 - MONTEVIDEO");
            System.out.print("Option: ");
            return 1;
        } else if (origin.equals("STG")) {
            System.out.println("Select Destination (1-3):");
            System.out.println("    1 - BUENOS AIRES");
            System.out.println("    2 - CORDOBA");
            System.out.println("    3 - MONTEVIDEO");
            System.out.print("Option: ");
            return 2;
        } else if (origin.equals("CDB")) {
            System.out.println("Select Destination (1-3):");
            System.out.println("    1 - BUENOS AIRES");
            System.out.println("    2 - SANTIAGO");
            System.out.println("    3 - MONTEVIDEO");
            System.out.print("Option: ");
            return 3;
        } else if (origin.equals("MTV")) {
            System.out.println("Select Destination (1-3):");
            System.out.println("    1 - BUENOS AIRES");
            System.out.println("    2 - SANTIAGO");
            System.out.println("    3 - CORDOBA");
            System.out.print("Option: ");
            return 4;
        }
        return 0;
    }

}
