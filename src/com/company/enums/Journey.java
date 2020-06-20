package com.company.enums;

import javax.print.attribute.standard.JobOriginatingUserName;
import java.util.ArrayList;

public enum Journey {
    BSAS_CDB("Buenos Aires","Cordoba",695),
    BSAS_STG("Buenos Aires","Santiago",1400),
    BSAS_MTV("Buenos Aires","Montevideo",950),
    CDB_MTV("Cordoba","Montevideo",1190),
    CDB_STG("Cordoba","Santiago", 1050),
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

   /* public static Journey compare(String origin, String destination) { //va o no va?
        if(origin.equals("BSAS")){
            if(destination.equals("CDB")){
                return Journey.BSAS_CDB;
            }
            else if(destination.equals("STG")){
                return Journey.BSAS_STG;
            }
            else
                return Journey.BSAS_MTV;
        }
        else if(origin.equals("CDB")){
            if(destination.equals("MTV")){
                return Journey.CDB_MTV;
            }
            else if(destination.equals("STG")){
                return Journey.CDB_STG;
            }
        }
        else
            return Journey.MTV_STG;
        return null;
    }*/


}
