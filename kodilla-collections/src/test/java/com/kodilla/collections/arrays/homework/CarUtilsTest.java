package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Opel;
import com.kodilla.collections.interfaces.homework.Toyota;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CarUtilsTest {

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
    void shouldDescribeToyota() {
        Car toyota = new Toyota(50);
        CarUtils.describeCar(toyota);
        String result = output.toString();
        assertTrue(result.contains("Car make: Toyota"));
        assertTrue(result.contains("Car speed: 50"));
    }

    @Test
    void shouldDescribeOpel() {
        Car opel = new Opel(30);
        CarUtils.describeCar(opel);
        String result = output.toString();
        assertTrue(result.contains("Car make: Opel"));
        assertTrue(result.contains("Car speed: 30"));
    }

    @Test
    void shouldDescribeFord() {
        Car ford = new Ford(40);
        CarUtils.describeCar(ford);
        String result = output.toString();
        assertTrue(result.contains("Car make: Ford"));
        assertTrue(result.contains("Car speed: 40"));
    }

}