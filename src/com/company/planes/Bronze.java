package com.company.planes;

import java.io.Serializable;

public class Bronze extends Plane implements Serializable {

    public Bronze(String model, double fuel, double pricePerKm, int passengers, double speed, String propulsion) {
        super(model, fuel, pricePerKm, passengers, speed, propulsion);
    }

    @Override
    public double getRate() {
        return 3000;
    }
}
