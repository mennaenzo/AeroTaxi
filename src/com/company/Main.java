package com.company;

public class Main {

    public static void main(String[] args) {
         boolean res;
        Plane vuelo = new Plane(null, "BSAS", "CORDOBA", 2);
        res=vuelo.validarCiudad("BSS","BSS");
        System.out.println(res);
        for (Ciudad c:Ciudad.values()) {
        System.out.println(c.toString());
        }

    }
    }