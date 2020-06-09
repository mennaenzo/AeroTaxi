package com.company;

public class Gold extends Plane implements WifiConnection{
    public Gold(double fuel, double pricePerKm, int passengers, double speed, String propulsion) {
        super(fuel, pricePerKm, passengers, speed, propulsion);
    }

    @Override
    public boolean connectionWifi() {
        return true;
    }
}
