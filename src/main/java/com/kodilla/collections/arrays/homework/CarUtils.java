package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Toyota;
import com.kodilla.collections.interfaces.homework.Opel;
import com.kodilla.collections.interfaces.homework.Car;

public class CarUtils {

    public static void describeCar(Car car) {
        System.out.println("-----------------------------");
        System.out.println("Car make: " + getCarName(car));
        System.out.println("Car speed: " + car.getSpeed());
    }

    private static String getCarName(Car car) {
        if (car instanceof Toyota)
            return "Toyota";
        else if (car instanceof Opel)
            return "Opel";
        else if (car instanceof Ford)
            return "Ford";
        else
            return "Unknown car name";
    }
}
