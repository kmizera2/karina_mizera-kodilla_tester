package com.kodilla.inheritance.homework;

public class Subsystem2 extends OperatingSystem{

    public Subsystem2(int releaseYear) {
        super(releaseYear);
    }

    @Override
    public void turnOn(){
        System.out.println("Subystem2 was turn on");
    }

    @Override
    public void turnOff(){
        System.out.println("Subystem2 was turn off");
    }
}
