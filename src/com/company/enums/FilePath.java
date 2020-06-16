package com.company.enums;

public enum FilePath {
    PLANES("files\\planes.json"),
    USERS("files\\users.json"),
    FLIGHTS("files\\flights.json");

    private String pathname;

    FilePath(String pathname) {
        this.pathname = pathname;
    }
    public String getPathname() {
        return pathname;
    }


}
