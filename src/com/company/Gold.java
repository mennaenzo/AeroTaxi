package com.company;

import java.io.Serializable;

public class Gold extends Plane implements WifiConnection, CateringService, Serializable {
    public Gold(String model, double fuel, double pricePerKm, int passengers, double speed, String propulsion) {
        super(model, fuel, pricePerKm, passengers, speed, propulsion);
    }

    @Override
    public boolean connectionWifi() {
        return true;
    }

    @Override
    public boolean service() {
        return false;
    }
}
