package com.company.enterprise;

import com.company.enums.City;
import com.company.enums.FilePath;
import com.company.enums.Journey;
import com.company.fileManagement.FileFlight;
import com.company.fileManagement.Storage;
import com.company.planes.Plane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SystemAero {

    public SystemAero() {
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean userOption = false;
        int option;
        setUp();
        while(!exit) {
            System.out.println("- Users -");
            User user = Storage.selectUser();
            if (user != null){
                userOption = false;
                while(!userOption) {
                    if (!user.getName().equals("Admin")) {
                        System.out.println("- AeroTaxi Menu -" + " (User: " + user.getName() + ")");
                        System.out.println("\t1 - Reserve Flight");
                        System.out.println("\t2 - Cancel Flight");
                        System.out.println("\t3 - Change User");
                        System.out.println("\t4 - Exit");
                        option = scanner.nextInt();
                        switch (option) {
                            case 1:
                                reserve(user);
                                break;
                            case 2:
                                UserMenu.cancelFlight(user);
                            case 3:
                                userOption = true;
                                break;
                            case 4:
                                userOption = true;
                                exit = true;
                                break;
                            default:
                                System.out.println("Please select a number between 1 and 5.");
                        }
                    } else {
                        admin(user);
                        userOption = true;
                    }
                }
            }
            else
                exit = true;
        }
    }

    private void admin(User user){
        System.out.println("Password: ");
        Scanner scanner1 = new Scanner(System.in);
        String password = scanner1.nextLine();
        if(password.equals("1234")) {
            int option;
            boolean exit = false;
            while (!exit) {
                System.out.println("- AeroTaxi Menu -" + " (User: " + user.getName() + ")");
                System.out.println("\t1 - Client list ");
                System.out.println("\t2 - View Flights on a date ");
                System.out.println("\t3 - Change User");
                Scanner scanner = new Scanner(System.in);
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("-----------------------------------");
                        Storage.printUsers();
                        System.out.println("-----------------------------------");
                        break;
                    case 2:
                        System.out.println("Please enter the date to see the flights (DD/MM/YY):");
                        Scanner scannerDate = new Scanner(System.in);
                        Date date = checkDate(scannerDate.nextLine());
                        if (Storage.getFlights().get(date) != null) {
                            Storage.listFlights(Storage.getFlights().get(date));
                        } else
                            System.out.println("There are no flights on that date.");
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Please select a number between 1 and 3.");
                        break;
                }
            }
        }
        else
            System.out.println("Wrong password.");
    }

    private void reserve(User user){
        Flight newFlight = checkIn(user);
        if(newFlight != null) {
            if(Storage.getFlights().containsKey(Storage.formatDate(newFlight.getDate())))
                Storage.addFlight(newFlight, Storage.getFlights().get(newFlight.getDate()));
            else {
                Storage.addFlight(newFlight);
            }
            FileFlight.writeFileFlight(Storage.getFlightsFromHashMap(), FilePath.FLIGHTS.getPathname());
        }
        else
            System.out.println("The flight was canceled.");
    }

    public void setUp() {
        Storage.firstData();
    }

    private Flight checkIn(User user){
        System.out.println("- CheckIn - Welcome " + user.getName());
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
                int maxPassenger = getMax(date);
                if(companions+1 <= maxPassenger){
                    Plane plane = planeAvailable(date, companions+1);
                    if(plane != null) {
                        System.out.println("Cost $" + UserMenu.getCost(journey, plane, companions + 1) + " - Plane " + plane.getModel() + ": ");
                        System.out.println("1 - Accept");
                        System.out.println("2 - Cancel");
                        return validateDecision(scanner, journey, plane, companions, date, user);
                    }
                    else
                        System.out.println("All planes are occupied on that date.");
                }
                else
                    System.out.println("We don't have planes available for that passenger capacity.");
            }
        }
        return null;
    }

    public Flight validateDecision(Scanner scanner, Journey journey, Plane plane, int companions, Date date, User user) {
        int decision = scanner.nextInt();
        while (decision < 1 || decision > 2){
            System.out.println("Please select 1 or 2. Choose again!");
            decision = scanner.nextInt();
        }
        switch (decision) {
            case 1:
                return UserMenu.confirmFlight(date, journey, plane, user, companions + 1);
            case 2:
                return null;
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

    public Plane planeAvailable(Date date, int companions){
        ArrayList<Plane> listPlaneAvailable;
        if(!Storage.getFlights().isEmpty()) {
            if (Storage.getFlights().containsKey(Storage.formatDate(date))) {
                listPlaneAvailable = deleteRepeated(Storage.getPlanesByDate(Storage.formatDate(date)));
                return choosePlanesAvailable(listPlaneAvailable);
            }
        }
        listPlaneAvailable = Storage.getMaxPlane(companions);
        return choosePlanesAvailable(listPlaneAvailable);
    }

    private ArrayList<Plane> deleteRepeated(ArrayList<Plane> planes){
        ArrayList<Plane> noRepeated = new ArrayList<>();
        for (Plane plane: Storage.getPlanes()) {
            if(!planes.contains(plane)){
                noRepeated.add(plane);
            }
        }
        return noRepeated;
    }

    public Plane choosePlanesAvailable(ArrayList<Plane> listPlane){
        int i = 1;
        for (Plane plane : listPlane) {
            System.out.println("Opcion: " + i);
            i++;
            System.out.println(plane.toString());
            System.out.println("\n");
        }

        System.out.println("Please choose the plane where you want to travel:");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option <= listPlane.size() + 1) {
            return listPlane.get(option-1);
        }
        else{
            System.out.println("Please choose the plane where you want to travel:");
            option = scanner.nextInt();
            if (option <= listPlane.size() + 1) {
                return listPlane.get(option-1);
            }
            else{
                System.out.println("ERROR");
                return null;
            }
        }
    }

    public int getMax(Date date) {
        int max = 0;
        if(!Storage.getFlights().isEmpty()) {
            if (Storage.getFlights().containsKey(Storage.formatDate(date))) {
                ArrayList<Plane> planesHash = new ArrayList<>();
                for (Flight flight : Storage.getFlights().get(Storage.formatDate(date))) {
                    planesHash.add(flight.getPlane());
                }
                for (Plane planeAvailable : Storage.planesAvailable(planesHash)) {
                    if (planeAvailable.getPassengers() > max)
                        max = planeAvailable.getPassengers();
                }
                return max;
            }
        }
        return Storage.getMaxPassengers();
    }
}