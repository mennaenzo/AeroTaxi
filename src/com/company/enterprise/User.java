package com.company.enterprise;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private int dni;
    private int age;
    private String bestCategory;
    private final ArrayList<Flight> checkIn;
    private final ArrayList<Flight> trips;

    public User(String name, String surname, int dni, int age) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.age = age;
        bestCategory = null;
        checkIn = new ArrayList<>();
        trips = new ArrayList<>();
    }

    public ArrayList<Flight> getCheckIn() {
        return checkIn;
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

    public void addCheckIn(Flight flight) {
        checkIn.add(flight);
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

    public void listFlights(){
        int i = 1;
        for (Flight flight : checkIn) {
            System.out.println(i + " - " + flight.toString());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni=" + dni +
                ", age=" + age +
                ", bestCategory='" + bestCategory + '\'' +
                ", checkIn=" + checkIn +
                ", trips=" + trips +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if(getBestCategory() == null) {
            return getDni() == user.getDni() &&
                    getAge() == user.getAge() &&
                    getName().equals(user.getName()) &&
                    getSurname().equals(user.getSurname()) &&
                    getCheckIn().equals(user.getCheckIn()) &&
                    getTrips().equals(user.getTrips());
        }
        else{
            return getDni() == user.getDni() &&
                    getAge() == user.getAge() &&
                    getName().equals(user.getName()) &&
                    getSurname().equals(user.getSurname()) &&
                    getCheckIn().equals(user.getCheckIn()) &&
                    getBestCategory().equals(user.getBestCategory()) &&
                    getTrips().equals(user.getTrips());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getDni(), getAge(), getBestCategory(), getCheckIn(), getTrips());
    }
}
