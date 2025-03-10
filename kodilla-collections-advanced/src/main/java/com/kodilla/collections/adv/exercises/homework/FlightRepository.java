package com.kodilla.collections.adv.exercises.homework;

import java.util.*;

public class FlightRepository {

    public static List<Flight> getFlightsTable() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Warsaw", "London"));
        flights.add(new Flight("Berlin", "Warsaw"));
        flights.add(new Flight("New York", "Warsaw"));
        flights.add(new Flight("Warsaw", "Berlin"));
        flights.add(new Flight("Paris", "Warsaw"));
        return flights;
    }
}
