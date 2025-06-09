package com.kodilla.collections.arrays.homework;


import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Toyota;
import com.kodilla.collections.interfaces.homework.Opel;
import com.kodilla.collections.interfaces.homework.Car;

import java.util.Random;

public class CarApplication {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Car[] cars = new Car[RANDOM.nextInt(15) + 1];
        for (int n = 0; n < cars.length; n++)
            cars[n] = drawCar();
        for (Car car : cars)
            CarUtils.describeCar(car);
    }


    public static Car drawCar() {
        int drawnCarKind = RANDOM.nextInt(3);
        int speed = getRandomSpeed();
        if (drawnCarKind == 0)
            return new Toyota(20 + speed);
        else if (drawnCarKind == 1)
            return new Opel(100 + speed);
        else
            return new Ford(40 + speed);
    }

    private static int getRandomSpeed() {
        return RANDOM.nextInt(100);
    }

}
