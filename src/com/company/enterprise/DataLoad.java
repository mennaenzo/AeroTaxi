package com.company.enterprise;

import com.company.fileManagement.FileFlight;
import com.company.fileManagement.FilePlane;
import com.company.fileManagement.FileUser;
import com.company.planes.Bronze;
import com.company.planes.Gold;
import com.company.planes.Plane;
import com.company.planes.Silver;

import java.io.File;
import java.util.ArrayList;
import java.util.ArrayList;

public class DataLoad {
    private static ArrayList<Plane> planes;
    private static ArrayList<Flight> fligts;
    private static ArrayList<User> users;

    public static ArrayList<Plane> getPlanes() {
        return planes;
    }

    public static ArrayList<Flight> getFligts() {
        return fligts;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
