package com.company;
import java.util.Date;
import java.lang.String;

public class Plane {
    private Date fecha;
    private String origen;
    private String destino;
    private int cantAcompañantes;

    public Plane(Date fecha, String origen, String destino, int cantAcompañantes) {
        this.fecha = fecha;
        if(validarCiudad(origen,destino)){
            this.origen = origen;
            this.destino = destino;
        }
       else
        {
            this.origen == null;
            this.destino = null;

        this.cantAcompañantes = cantAcompañantes;
    }

    // Validacion de las ciudades que se elijen
    public boolean validarCiudad(String origen, String destino) {
        boolean validacion = false;
        if (!origen.equals(destino)) {   // Validad que no sea el orien iual que el destino
            for (Ciudad ciudadOrigen : Ciudad.values()) {
                if (ciudadOrigen.toString().equals(origen)) { //valida que el orien sea una ciudad disponible
                    for (Ciudad ciudadDestino : Ciudad.values()) {
                        if (ciudadDestino.toString().equals(destino)) { // Valida que el destino sea una ciudad disponible
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
    }
}



