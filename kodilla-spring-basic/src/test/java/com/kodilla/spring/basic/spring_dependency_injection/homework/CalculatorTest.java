package com.kodilla.spring.basic.spring_dependency_injection.homework;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    void shouldAddNumbers() {
        double result = calculator.add(2, 3);
        assertEquals(5, result, 0.01);
    }

    @Test
    void shouldSubtractNumbers() {
        double result = calculator.subtract(10, 7);
        assertEquals(3, result, 0.01);
    }

    @Test
    void shouldMultiplyNumbers() {
        double result = calculator.multiply(4, 5);
        assertEquals(20, result, 0.01);
    }

    @Test
    void shouldDivideNumbers() {
        double result = calculator.divide(12, 3);
        assertEquals(4, result, 0.01);
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
        assertEquals("Nie można dzielić przez zero.", exception.getMessage());
    }
}