package com.kodilla.inheritance.homework;

public class Subsystem1 extends OperatingSystem{

    public Subsystem1(int releaseYear) {
        super(releaseYear);
    }

    @Override
    public void turnOn(){
        System.out.println("Subystem1 was turn on");
    }

    @Override
    public void turnOff(){
        System.out.println("Subystem1 was turn off");
    }
}
