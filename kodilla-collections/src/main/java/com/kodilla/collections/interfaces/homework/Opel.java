package com.kodilla.collections.interfaces.homework;

public class Opel implements Car {

    private int speed;

    public Opel (int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void increaseSpeed() {
        speed += 7;
    }

    public void decreaseSpeed() {
        if (speed > 22)
            speed -= 22;
        else
            speed = 0;
    }
}
