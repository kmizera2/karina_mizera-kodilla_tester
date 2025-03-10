package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightFinderTestSuite {


    @Test
    void testFindFlightsFrom() {
        FlightFinder finder = new FlightFinder();
        List<Flight> flightsFromWarsaw = finder.findFlightsFrom("Warsaw");
        assertEquals(2, flightsFromWarsaw.size());
    }

    @Test
    void testFindFlightsTo() {
        FlightFinder finder = new FlightFinder();
        List<Flight> flightsToWarsaw = finder.findFlightsTo("Warsaw");
        assertEquals(3, flightsToWarsaw.size());
    }

    @Test
    void testZeroFlightsTo() {
        FlightFinder finder = new FlightFinder();
        List<Flight> flightsToPeczniew = finder.findFlightsTo("Pęczniew");
        assertEquals(0, flightsToPeczniew.size());
    }

    @Test
    void testZeroFlightsFrom() {
        FlightFinder finder = new FlightFinder();
        List<Flight> flightsFromPeczniew = finder.findFlightsFrom("Pęczniew");
        assertEquals(0, flightsFromPeczniew.size());
    }


}