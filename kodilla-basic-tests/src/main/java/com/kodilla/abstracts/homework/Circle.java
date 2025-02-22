package com.kodilla.abstracts.homework;

public class Circle extends Shape {

    public double r;
    static final double PI = 3.1415927;

   // public Circle circle = new Circle ();


    @Override
    public double area() {
        return PI * r * r;
    }

    @Override
    public double perimeter() {
        return 2 * PI *r;
    }
}
