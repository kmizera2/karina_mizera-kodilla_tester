package com.kodilla.basic_assertion;

public class Calculator {

    public int sum(int a, int b) {
        return Math.addExact(a, b);
    }

    public int subtract(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public double squareDouble(double a) {
        return Math.pow( a, 2.0);
    }
}
