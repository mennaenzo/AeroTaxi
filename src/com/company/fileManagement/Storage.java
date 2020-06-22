package com.company.fileManagement;

import com.company.enterprise.Flight;
import com.company.enterprise.User;
import com.company.enums.FilePath;
import com.company.planes.Plane;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Storage {
    private static ArrayList<Plane> planes = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static HashMap<Date, ArrayList<Flight>> flights = new HashMap<>();

    public static void setPlanes(ArrayList<Plane> planes) {
        Storage.planes = planes;
    }

    public static void setUsers(ArrayList<User> users) {
        Storage.users = users;
    }

    public static void addFlight(Flight flight){
        ArrayList<Flight> flightsHash = new ArrayList<>();
        flightsHash.add(flight);
        flights.put(flight.getDate(),flightsHash);
    }

    public static void addFlight(Flight flight, ArrayList<Flight> flightsHash){
        flightsHash.add(flight);
        flights.put(flight.getDate(),flightsHash);
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
        if(!users.isEmpty()){
            int i = 1;
            for (User user : users) {
                System.out.println("\t" + i + " - " + user.getName() + " " + user.getSurname());
                i++;
            }
            System.out.println("\t" + i + " - Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select number user: ");
            int option = scanner.nextInt();
            if(option <= users.size()){
                return users.get(option-1);
            }
        }
        else
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
        // Vacia el archivo que se manda por parametro, si es que existe el mismo
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

    public static void firstData(){
        File filePlane = new File(FilePath.PLANES.getPathname());
        if(filePlane.exists()) {
            planes = FilePlane.readFilePlane(FilePath.PLANES.getPathname());
        }
        else {
            FilePlane filePlane1 = new FilePlane();
            filePlane1.createFile(FilePath.PLANES.getPathname());
            setPlanes(FilePlane.createDataPlane(FilePath.PLANES.getPathname()));
        }

        File fileUser = new File(FilePath.USERS.getPathname());
        if(fileUser.exists())
            users = FileUser.readFileUser(FilePath.USERS.getPathname());
        else {
            FileUser fileUser1 = new FileUser();
            fileUser1.createFile(FilePath.USERS.getPathname());
            setUsers(FileUser.createDataUser(FilePath.USERS.getPathname()));
        }

        File fileFlights = new File(FilePath.FLIGHTS.getPathname());
        if(fileFlights.exists()) {
            for (Flight flight : FileFlight.readFileFlight(FilePath.FLIGHTS.getPathname())) {
                if(flights.containsKey(flight.getDate())){
                    addFlight(flight, flights.get(flight.getDate()));
                }
                else{
                    addFlight(flight);
                }
            }
        }
        else {
            FileFlight fileFlight1 = new FileFlight();
            fileFlight1.createFile(FilePath.FLIGHTS.getPathname());
        }
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

    public static ArrayList<Plane> getMaxPlane(int maxPassengers){
    ArrayList<Plane> planeListAvailable = new ArrayList<>();
        for (Plane plane: Storage.getPlanes()) {
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
}
