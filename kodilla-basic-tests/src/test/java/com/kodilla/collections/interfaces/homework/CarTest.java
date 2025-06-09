package com.kodilla.collections.interfaces.homework;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void shouldReturnCorrectNumberOfWheels() {
        Car car = new Car(4, 5);
        assertEquals(4, car.getWheels());
    }

    @Test
    void shouldReturnCorrectNumberOfSeats() {
        Car car = new Car(4, 5);
        assertEquals(5, car.getSeats());
    }

    @Test
    void shouldTurnOnLights() {
        Car car = new Car(4, 5);
        car.turnOnLights();
        assertEquals("Lights were turned on" + System.lineSeparator(), output.toString());
    }

    @Test
    void shouldOpenDoors() {
        Car car = new Car(4, 5);
        car.openDoors();
        assertEquals("Opening 4 doors" + System.lineSeparator(), output.toString());
    }

    @Test
    void shouldDisplayNumberOfSeats() {
        Car car = new Car(4, 5);
        car.displayNumberOfSeats();
        assertEquals("Number of seats: 5" + System.lineSeparator(), output.toString());
    }
}