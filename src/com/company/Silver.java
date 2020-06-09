package com.company;

public class Silver extends Plane implements WifiConnection{
    public Silver(double fuel, double pricePerKm, int passengers, double speed, String propulsion) {
        super(fuel, pricePerKm, passengers, speed, propulsion);
    }

    @Override
    public boolean connectionWifi() {
        return true;
    }
}
