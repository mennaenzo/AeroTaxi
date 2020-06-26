package com.company.enterprise;

import com.company.enums.Journey;
import com.company.planes.Plane;

import java.util.Date;
import java.util.Objects;

public class Flight {
    private Date date;
    private Journey journey;
    private Plane plane;
    private String user;
    private int passengers;
    private double cost;

    public Flight(Date date, Journey journey, Plane plane, String user, int passengers, double cost) {
        this.date = date;
        this.journey = journey;
        this.plane = plane;
        this.user = user;
        this.passengers = passengers;
        this.cost = cost;
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

    public String getUser() {
        return user;
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

    @Override
    public String toString() {
        return "Flight{" +
                "date=" + date +
                ", journey=" + journey +
                ", plane=" + plane +
                ", user=" + user +
                ", passengers=" + passengers +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return getPassengers() == flight.getPassengers() &&
                Double.compare(flight.getCost(), getCost()) == 0 &&
                getDate().equals(flight.getDate()) &&
                getJourney() == flight.getJourney() &&
                getPlane().equals(flight.getPlane()) &&
                getUser().equals(flight.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getJourney(), getPlane(), getUser(), getPassengers(), getCost());
    }
}