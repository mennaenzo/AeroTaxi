package com.company.planes;
import java.io.Serializable;
import java.lang.String;

public class Plane implements Serializable {
    private String model;
    private double fuel;
    private double pricePerKm;
    private int passengers;

    public Plane() {

    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", fuel=" + fuel +
                ", pricePerKm=" + pricePerKm +
                ", passengers=" + passengers +
                ", speed=" + speed +
                ", propulsion='" + propulsion + '\'' +
                '}';
    }

    private double speed;
    private String propulsion;

    public Plane(String model, double fuel, double pricePerKm, int passengers, double speed, String propulsion) {
        this.model = model;
        this.fuel = fuel;
        this.pricePerKm = pricePerKm;
        this.passengers = passengers;
        this.speed = speed;
        this.propulsion = propulsion;
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



