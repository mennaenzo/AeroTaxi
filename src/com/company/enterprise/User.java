package com.company.enterprise;

import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private int dni;
    private int age;
    private String bestCategory;
    private ArrayList<Flight> trips;

    public User(String name, String surname, int dni, int age) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.age = age;
        this.bestCategory = null;
        this.trips = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBestCategory() {
        return bestCategory;
    }

    public void setBestCategory(String bestCategory) {
        this.bestCategory = bestCategory;
    }

    public ArrayList<Flight> getTrips() {
        return trips;
    }

    public void addTrips(Flight flight) {
        trips.add(flight);
    }

    public float spentFlights(){
        if(!trips.isEmpty()){
            float spent = 0;
            for (Flight flight : trips) {
                spent += flight.getCost();
            }
            return spent;
        }else
            return 0;
    }


}
