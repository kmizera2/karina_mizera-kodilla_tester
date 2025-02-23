package com.kodilla.basic_assertion;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int square(int a) {
        return a * a;
    }

    public double sumDouble(double a, double b) {
        return a + b;
    }

    public double subtractDouble(double a, double b) {
        return a - b;
    }

    public double squareDouble(double a) {
        return Math.pow( a, 2.0);
    }
}
