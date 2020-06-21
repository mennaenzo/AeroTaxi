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

public abstract class Storage {
    private static ArrayList<Plane> planes;
    private static ArrayList<User> users;
    private static ArrayList<Flight> fligts;

    public static void setPlanes(ArrayList<Plane> planes) {
        Storage.planes = planes;
    }

    public static void setUsers(ArrayList<User> users) {
        Storage.users = users;
    }

    public static void setFligts(ArrayList<Flight> fligts) {
        Storage.fligts = fligts;
    }

    public Storage() {
        planes = new ArrayList<>();
        users = new ArrayList<>();
        fligts = new ArrayList<>();
    }

    public static ArrayList<Plane> getPlanes() {
        return planes;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<Flight> getFligts() {
        return fligts;
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
        if(filePlane.exists())
            planes = FilePlane.readFilePlane(FilePath.PLANES.getPathname());
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
        if(fileFlights.exists())
            fligts = FileFlight.readFileFlight(FilePath.FLIGHTS.getPathname());
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
}
