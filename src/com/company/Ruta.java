package com.company;

public enum Ruta {
    BSASCORDOBA("Buenos Aires","Cordoba",695),
    BSASSANTIAGO("Buenos Aires","Santiago",1400),
    BSASMONTEVIDEO("Buenos Aires","Montevideo",950),
    CORDOBAMONTEVIDEO("Cordoba","Montevideo",1190),
    CORDOBASANTIAGO("Cordoba","Santiago", 1050),
    MONTEVIDEOSANTIAO("Montevideo","Santiago",2100);

    private String origen;
    private String destino;
    private double distancia;

    Ruta(String origen, String destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }
    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }
}
