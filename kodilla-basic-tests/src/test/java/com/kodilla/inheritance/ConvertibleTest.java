package com.kodilla.inheritance;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConvertibleTest {

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
    void shouldPrintConstructorMessage() {
        new Convertible(4, 2);
        assertTrue(output.toString().contains("Convertible constructor"));
    }

    @Test
    void shouldOpenRoof() {
        Convertible car = new Convertible(4, 2);
        output.reset();
        car.openRoof();
        assertEquals("Opening roof..." + System.lineSeparator(), output.toString());
    }

    @Test
    void shouldCloseRoof() {
        Convertible car = new Convertible(4, 2);
        output.reset();
        car.closeRoof();
        assertEquals("Closing roof..." + System.lineSeparator(), output.toString());
    }

    @Test
    void shouldOpenTwoDoors() {
        Convertible car = new Convertible(4, 2);
        output.reset();
        car.openDoors();
        assertEquals("Opening 2 doors" + System.lineSeparator(), output.toString());
    }

    @Test
    void shouldReturnCorrectWheelsAndSeats() {
        Convertible car = new Convertible(4, 2);
        assertEquals(4, car.getWheels());
        assertEquals(2, car.getSeats());
    }
}
