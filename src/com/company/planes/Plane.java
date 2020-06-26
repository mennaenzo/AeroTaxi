package com.company.planes;
import java.io.Serializable;
import java.lang.String;
import java.util.Objects;

public class Plane implements Serializable {
    private String model;
    private double fuel;
    private double pricePerKm;
    private double speed;
    private String propulsion;
    private int passengers;

    public Plane(String model, double fuel, double pricePerKm, int passengers, double speed, String propulsion) {
        this.model = model;
        this.fuel = fuel;
        this.pricePerKm = pricePerKm;
        this.passengers = passengers;
        this.speed = speed;
        this.propulsion = propulsion;
    }

    @Override
    public String toString() {
        return "Plane{" +
                ", model='" + model + '\'' +
                ", fuel=" + fuel +
                ", pricePerKm=" + pricePerKm +
                ", passengers=" + passengers +
                ", speed=" + speed +
                ", propulsion='" + propulsion + '\'' +
                '}';
    }

    public Plane() {
    }

    public String getModel() {
        return model;
    }

    public double getFuel() {
        return fuel;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    public int getPassengers() {
        return passengers;
    }

    public double getSpeed() {
        return speed;
    }

    public String getPropulsion() {
        return propulsion;
    }

    public double getRate(){
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Double.compare(plane.getFuel(), getFuel()) == 0 &&
                Double.compare(plane.getPricePerKm(), getPricePerKm()) == 0 &&
                Double.compare(plane.getSpeed(), getSpeed()) == 0 &&
                getPassengers() == plane.getPassengers() &&
                getModel().equals(plane.getModel()) &&
                getPropulsion().equals(plane.getPropulsion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getFuel(), getPricePerKm(), getSpeed(), getPropulsion(), getPassengers());
    }
}



