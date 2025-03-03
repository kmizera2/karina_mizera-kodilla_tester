package com.kodilla.inheritance;

public class Application {
    public static void main(String[] args) {

        Car car = new Car(4,8);
        car.turnOnLights();
        car.openDoors();

        Convertible convertible=new Convertible(4, 5);
        convertible.turnOnLights();
        convertible.openDoors();
        System.out.println(convertible.getSeats());
        convertible.displayNumberOfSeats();
    }
}
