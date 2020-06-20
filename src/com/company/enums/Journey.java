package com.company.enums;

import javax.print.attribute.standard.JobOriginatingUserName;
import java.util.ArrayList;

public enum Journey {
    BSAS_CDB("Buenos Aires","Cordoba",695),
    CDB_BSAS("Cordoba","Buenos Aires",695),
    BSAS_STG("Buenos Aires","Santiago",1400),
    STG_BSAS("Santiago","Buenos Aires",1400),
    BSAS_MTV("Buenos Aires","Montevideo",950),
    MTV_BSAS("Montevideo","Buenos Aires",950),
    CDB_MTV("Cordoba","Montevideo",1190),
    MTV_CDB("Montevideo","Cordoba",1190),
    CDB_STG("Cordoba","Santiago", 1050),
    STG_CDB("Santiago","Cordoba", 1050),
    STG_MTV("Santiago","Montevideo",2100),
    MTV_STG("Montevideo","Santiago",2100);


    private final String origin;
    private final String destination;
    private final double distance;

    Journey(String origin, String destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public static Journey compare(String origin, String destination) {
        for (Journey journey: Journey.values()) {
            if (journey.getOrigin().equals(origin) && journey.getDestination().equals(destination)) {
                return journey;
            }
        }
        return null;
    }
}
