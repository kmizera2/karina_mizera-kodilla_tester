package com.kodilla.inheritance.homework;

import com.kodilla.inheritance.Car;
import com.kodilla.inheritance.Convertible;

public class SystemManaging {

    public static void main(String[] args) {

        OperatingSystem operatingSystem = new OperatingSystem(2023);
        operatingSystem.turnOn();
        operatingSystem.turnOff();

        Subsystem1 subsystem1 = new Subsystem1(2024);
        subsystem1.turnOn();
        subsystem1.turnOff();

        Subsystem2 subsystem2 = new Subsystem2(2024);
        subsystem2.turnOn();
        subsystem2.turnOff();


    }
}
