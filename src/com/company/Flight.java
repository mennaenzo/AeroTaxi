package com.company;

import java.util.Date;

public class Flight {
    private Date date;
    private String from;
    private String to;
    private int passengers;

    public Flight(Date date, String from, String to, int passengers) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.passengers = passengers;
    }
}
