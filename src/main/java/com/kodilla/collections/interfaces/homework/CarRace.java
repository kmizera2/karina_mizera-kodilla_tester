package com.kodilla.collections.interfaces.homework;

public class CarRace {
    public static void main(String[] args) {
        Ford ford = new Ford(100);
        doRace(ford);
        Opel opel = new Opel(40);
        doRace(opel);
        Toyota toyota = new Toyota(10);
        doRace(toyota);

    }
    private static void doRace(Car car){
        car.increaseSpeed();
        car.increaseSpeed();
        car.increaseSpeed();
        car.decreaseSpeed();
        car.decreaseSpeed();
        System.out.println(car.getSpeed());
    }
}
