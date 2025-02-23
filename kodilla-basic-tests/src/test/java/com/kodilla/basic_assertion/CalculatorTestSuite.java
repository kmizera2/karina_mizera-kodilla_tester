package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.sum(a, b);
        assertEquals(13, sumResult);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.subtract(a, b);
        assertEquals(-3, sumResult);
    }

    @Test
    public void testSquareDoubleForZero() {
        Calculator calculator = new Calculator();
        double a=0;
        double c=0.001;
        double squareDoubleResult = calculator.squareDouble(a);
        assertEquals(0, squareDoubleResult, c);
    }

    @Test
    public void testSquareDoubleForPositiveNumber() {
        Calculator calculator = new Calculator();
        double a=4;
        double c=0.001;
        double squareDoubleResult = calculator.squareDouble(a);
        assertEquals(16, squareDoubleResult, c);
    }

    @Test
    public void testSquareDoubleForNegativeNumber() {
        Calculator calculator = new Calculator();
        double a=-3;
        double c=0.001;
        double squareDoubleResult = calculator.squareDouble(a);
        assertEquals(9, squareDoubleResult, c);
    }
}
