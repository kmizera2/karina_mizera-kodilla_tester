package com.kodilla.inheritance.homework;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Subsystem2Test {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUpStreams() {
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldPrintTurnOnMessage() {
        Subsystem2 subsystem = new Subsystem2(2023);
        subsystem.turnOn();
        assertEquals("Subystem2 was turn on" + System.lineSeparator(), output.toString());
    }

    @Test
    void shouldPrintTurnOffMessage() {
        Subsystem2 subsystem = new Subsystem2(2023);
        subsystem.turnOff();
        assertEquals("Subystem2 was turn off" + System.lineSeparator(), output.toString());
    }
}