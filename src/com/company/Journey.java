package com.company;

public enum Journey {
    BSAS_CDB("Buenos Aires","Cordoba",695),
    BSAS_STG("Buenos Aires","Santiago",1400),
    BSAS_MTV("Buenos Aires","Montevideo",950),
    CDB_MTV("Cordoba","Montevideo",1190),
    CBD_STG("Cordoba","Santiago", 1050),
    MTV_STG("Montevideo","Santiago",2100);

    private String origin;
    private String destination;
    private double distance;

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
}
