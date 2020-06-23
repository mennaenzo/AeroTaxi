package com.company.planes;
import java.io.Serializable;
import java.lang.String;

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
}



