package com.company.enterprise;
import com.company.enums.Journey;

import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private int dni;
    private int age;

    public User(String name, String surname, int dni, int age) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.age = age;
    }

    public User(String name, String surname, int dni, int age, String bestCategory, ArrayList<Journey> trips) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.age = age;
        this.bestCategory = bestCategory;
        this.trips = trips;

    }

    private String bestCategory;
    private ArrayList<Journey> trips;
}
