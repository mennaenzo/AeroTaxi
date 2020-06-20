package com.company.enterprise;

import com.company.enums.Journey;
import com.company.planes.Plane;

import java.util.Date;

public class Flight {
    private Date date;
    private Journey journey;
    private Plane plane;
    private User user;
    private int passengers;
    private double cost;

    public Flight(Date date, Journey journey, Plane plane, User user, int passengers, double cost) {
        this.date = date;
        this.journey = journey;
        this.plane = plane;
        this.user = user;
        this.passengers = passengers;
        this.cost = cost;
    }

    public Flight(Date date, Journey journey, User user, int passengers) {
        this.date = date;
        this.journey = journey;
        this.user = user;
        this.passengers = passengers;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}