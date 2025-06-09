package com.kodilla.abstracts;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

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
    void dogShouldHaveFourLegs() {
        Dog dog = new Dog();
        assertEquals(4, dog.getNumberOfLegs(), "Dog should have 4 legs");
    }

    @Test
    void dogShouldGiveVoice() {
        Dog dog = new Dog();
        dog.giveVoice();
        assertEquals("Hau hau" + System.lineSeparator(), output.toString());
    }
}