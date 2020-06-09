package com.company;
import java.util.Date;
import java.lang.String;

public class Plane {
    private double fuel;
    private double pricePerKm;
    private int passengers;
    private double speed;
    private String propulsion;

    public Plane(double fuel, double pricePerKm, int passengers, double speed, String propulsion) {
        this.fuel = fuel;
        this.pricePerKm = pricePerKm;
        this.passengers = passengers;
        this.speed = speed;
        this.propulsion = propulsion;
    }

    // Validacion de las ciudades que se elijen
    /*public boolean validarCiudad(String origen, String destino) {
        boolean validacion = false;
        if (!origen.equals(destino)) {   // Validad que no sea el orien iual que el destino
            for (City cityOrigen : City.values()) {
                if (cityOrigen.toString().equals(origen)) { //valida que el orien sea una ciudad disponible
                    for (City cityDestino : City.values()) {
                        if (cityDestino.toString().equals(destino)) { // Valida que el destino sea una ciudad disponible
                            validacion = true;
                        }
                    }
                }
            }
            if(validacion == false){
                System.out.println("Por el momento no hay vuelos para dicha ciudad.");
            }
        }
            else {
            System.out.println("Error al ingresar los el origen/destino.");
        }
        return validacion;
    }*/
}



