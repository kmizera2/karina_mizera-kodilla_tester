package com.kodilla.abstracts.homework;

public class Square extends Shape{

    double side;

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return side * 4;
    }
}
