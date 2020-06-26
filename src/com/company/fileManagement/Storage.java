package com.company.fileManagement;

import com.company.enterprise.Flight;
import com.company.enterprise.User;
import com.company.enums.FilePath;
import com.company.planes.Plane;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public abstract class Storage {
    private static ArrayList<Plane> planes = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static HashMap<Date, ArrayList<Flight>> flights = new HashMap<>();

    public static void listFlights(ArrayList<Flight> listFlightByDate) {
        for (Flight flight : listFlightByDate) {
            System.out.println(flight.toString());
        }
    }

    public static void addFlight(Flight flight) {
        ArrayList<Flight> flightsHash = new ArrayList<>();
        flightsHash.add(flight);
        flights.put(formatDate(flight.getDate()), flightsHash);
    }

    public static void addFlight(Flight flight, ArrayList<Flight> flightsHash) {
        flightsHash.add(flight);
        flights.put(formatDate(flight.getDate()), flightsHash);
    }

    public static Date formatDate(Date date){
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        return date;
    }

    public Storage() {
    }

    public static ArrayList<Plane> getPlanes() {
        return planes;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static HashMap<Date, ArrayList<Flight>> getFlights() {
        return flights;
    }

    public static User selectUser() {
        if (!users.isEmpty()) {
            int i = 0;
            for (User user : users) {
                System.out.println("\t" + i + " - " + user.getName() + " " + user.getSurname());
                i++;
            }
            System.out.println("\t" + i + " - Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select number user: ");
            int option = scanner.nextInt();
            if ((option >= 0) && (option <= (users.size())-1)) {
                return users.get(option);
            }
        } else
            System.out.println("No users!");
        return null;
    }

    public boolean createFile(String pathname) {
        File files = new File(pathname);
        try {
            return files.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Vacia toda la informacion que hay en el archivo

    public void emptyFile(String pathname) {
        File file = new File(pathname);
        if (file.exists()) {
            try {
                BufferedWriter bWriter = new BufferedWriter(new FileWriter(pathname));
                bWriter.write("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean firstData() {
        File filePlane = new File(FilePath.PLANES.getPathname());
        if (filePlane.exists()) {
            if (checkPlanes(FilePlane.readFilePlane(FilePath.PLANES.getPathname()), FilePlane.createDataPlane())) {
                planes = FilePlane.createDataPlane();
            } else {
                System.out.println("ERROR: The file is corrupt");
                return false;
            }
        } else {
            FilePlane filePlane1 = new FilePlane();
            filePlane1.createFile(FilePath.PLANES.getPathname());
            planes = FilePlane.createDataPlane();
        }

        File fileUser = new File(FilePath.USERS.getPathname());
        if (fileUser.exists()){
            /*if(checkUser(FileUser.readFileUser(FilePath.USERS.getPathname()), FileUser.createDataUser())){
                users = FileUser.readFileUser(FilePath.USERS.getPathname());
            }
            else{
                System.out.println("The file is corrupt");

             */
            users = FileUser.readFileUser(FilePath.USERS.getPathname());
        }
        else {
            FileUser fileUser1 = new FileUser();
            fileUser1.createFile(FilePath.USERS.getPathname());
            users = FileUser.createDataUser();
        }

        File fileFlights = new File(FilePath.FLIGHTS.getPathname());
        if (fileFlights.exists()) {
            /*if((checkFlight(FileFlight.readFileFlight(FilePath.FLIGHTS.getPathname())))){
                if (FileFlight.readFileFlight(FilePath.FLIGHTS.getPathname()).size() > 0) {
                    for (Flight flight : FileFlight.readFileFlight(FilePath.FLIGHTS.getPathname())) {
                        if (flights.containsKey(flight.getDate())) {
                            addFlight(flight, flights.get(flight.getDate()));
                        } else {
                            addFlight(flight);
                        }
                    }
                }
            }
            else{
                System.out.println("The file is corrupt");
            }
             */
            for (Flight flight : FileFlight.readFileFlight(FilePath.FLIGHTS.getPathname())) {
                if (flights.containsKey(flight.getDate())) {
                    addFlight(flight, flights.get(flight.getDate()));
                } else {
                    addFlight(flight);
                }
            }
        }
        else {
            FileFlight fileFlight1 = new FileFlight();
            fileFlight1.createFile(FilePath.FLIGHTS.getPathname());
        }

        return true;
    }


    public static void printUsers(){
        System.out.println("- Clients -");
        for (User user: users) {
            System.out.println("\tUser: " + user.toString());
        }
        System.out.println("Total Customers: " + getUsers().size());
    }

    public static ArrayList<Flight> getFlightsFromHashMap(){
        ArrayList<Flight> arrayFlights = new ArrayList<>();
        int i = 0;

        for (ArrayList<Flight> flight : flights.values()) {
            for(i = 0; i < flight.size(); i++)
                arrayFlights.add(flight.get(i));
        }
        return arrayFlights;
    }

    public static ArrayList<Plane> getPlanesByDate(Date date){
        ArrayList<Plane> planes = new ArrayList<>();
        for (Flight flight : flights.get(date)){
            planes.add(flight.getPlane());
        }
        return planes;
    }

    public static int getMaxPassengers(){
        int max = 0;
        for (Plane plane: planes) {
            if(max < plane.getPassengers()){
                max = plane.getPassengers();
            }
        }
        return max;
    }

    public static ArrayList<Plane> getMaxPlanes(int maxPassengers){
    ArrayList<Plane> planeListAvailable = new ArrayList<>();
        for (Plane plane: planes) {
            if(plane.getPassengers() >= maxPassengers){
                planeListAvailable.add(plane);
            }
        }
    return planeListAvailable;
    }

    public static ArrayList<Plane> planesAvailable(ArrayList<Plane> occupied){
        ArrayList<Plane> planesAvailable = planes;
        for (Plane plane : occupied) {
            if(planes.contains(plane)){
                planesAvailable.remove(plane);
            }
        }
        return planesAvailable;
    }

    public static boolean checkPlanes(ArrayList<Plane> planesFromFile, ArrayList<Plane> planesOriginal) {
        for (Plane plane : planesFromFile) {
            if (!planesOriginal.contains(plane)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkFlight(ArrayList<Flight> flightFromFile) {
        if (flightFromFile.size() > 0) {
            for (Flight flight : flightFromFile) {
                return false;
            }
        }
        return true;
    }

   /* public static boolean checkUser(ArrayList<User> usersFromFile, ArrayList<User> usersOriginal) {
        if (usersFromFile.size() > 0) {
            for (User user : usersFromFile) {
                for (User userOriginal : usersFromFile) {
                    if (user.getDni() == userOriginal.getDni()) {
                        if (user.getSurname().equals(userOriginal.getSurname())) {
                            if (user.getName().equals(userOriginal.getName())) {
                                if (user.getAge() == userOriginal.getAge()) {
                                    if (user.getCheckIn().equals(userOriginal.getCheckIn())) {
                                        if (user.getBestCategory().equals(userOriginal.getBestCategory())) {
                                            if (user.getTrips().equals(userOriginal.getTrips())) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    */
}
