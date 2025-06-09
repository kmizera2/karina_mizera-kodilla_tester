package com.kodilla.abstracts;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DuckTest {

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
    void duckShouldHaveTwoLegs() {
        Duck duck = new Duck();
        assertEquals(2, duck.getNumberOfLegs(), "Duck should have 2 legs");
    }

    @Test
    void duckShouldGiveVoice() {
        Duck duck = new Duck();
        duck.giveVoice();
        assertEquals("Quack" + System.lineSeparator(), output.toString());
    }
}