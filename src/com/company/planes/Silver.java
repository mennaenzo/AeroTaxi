package com.company.planes;

import com.company.interfaces.CateringService;

import java.io.Serializable;

public class Silver extends Plane implements CateringService, Serializable {
    public Silver(String model, double fuel, double pricePerKm, int passengers, double speed, String propulsion) {
        super(model, fuel, pricePerKm, passengers, speed, propulsion);
    }

    @Override
    public boolean service() {
        return true;
    }

    @Override
    public double getRate() {
        return 4000;
    }
}
