package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.kodilla.collections.adv.exercises.homework.FlightRepository.getFlightsTable;

public class FlightFinder {

    public List<Flight> findFlightsFrom(String departure) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : getFlightsTable()) {
            if (flight.departure.equals(departure))
                result.add(flight);
        }
        return result;
    }

    public List<Flight> findFlightsTo(String arrival) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : getFlightsTable()) {
            if (flight.arrival.equals(arrival))
                result.add(flight);
        }
        return result;
    }

}
