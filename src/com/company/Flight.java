package com.company;

public class Flight {
    private double capacidadCombustible;
    private double costoKm;
    private int cantPasajeros;
    private double velocidadMax;
    private String tipoPropulsion;

    public Flight(double capacidadCombustible, double costoKm, int cantPasajeros, double velocidadMax, String tipoPropulsion) {
        this.capacidadCombustible = capacidadCombustible;
        this.costoKm = costoKm;
        this.cantPasajeros = cantPasajeros;
        this.velocidadMax = velocidadMax;
        this.tipoPropulsion = tipoPropulsion;
    }
}
