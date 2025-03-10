package com.kodilla.collections.adv.exercises.homework;

import java.util.Objects;

public class Flight {
    public String departure;
    public String arrival;

    public Flight(String departure, String arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }


}
