package com.company.enums;

public enum City {
    BSAS("Buenos Aires"),
    STG("Santiago"),
    CDB("Cordoba"),
    MTV("Montevideo");

    private String name;

    City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}