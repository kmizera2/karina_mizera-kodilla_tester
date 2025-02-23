package com.kodilla.basic_assertion;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        double c= 4;

        int sumResult = calculator.sum(a, b);
        boolean correct = ResultChecker.assertEquals(13, sumResult);
        if (correct) {
            System.out.println("Metoda sum działa poprawnie dla liczb " + a + " i " + b);
        } else {
            System.out.println("Metoda sum nie działa poprawnie dla liczb " + a + " i " + b);
        }

        int substractResult = calculator.subtract(a, b);
        boolean correct1 = ResultChecker.assertEquals(-3, substractResult);
        if (correct1) {
            System.out.println("Metoda substract działa poprawnie dla liczb " + a + " i " + b);
        } else {
            System.out.println("Metoda substract nie działa poprawnie dla liczb " + a + " i " + b);
        }

        int squareResult = calculator.square(a);
        boolean correct3 = ResultChecker.assertEquals(25, squareResult);
        if (correct3) {
            System.out.println("Metoda square działa poprawnie dla liczby " + a);
        } else {
            System.out.println("Metoda square nie działa poprawnie dla liczby " + a);
        }

        double squareDoubleResult = calculator.squareDouble(c);
        boolean correct4 = ResultChecker.assertEquals2(16.0, squareDoubleResult);
        if (correct4) {
            System.out.println("Metoda squareDouble działa poprawnie dla liczby " + c);
        } else {
            System.out.println("Metoda squareDouble nie działa poprawnie dla liczby ");
        }
    }
}
