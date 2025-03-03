package com.kodilla.collections.interfaces.homework;

public class Ford implements Car {

    private int speed;

    public Ford(int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void increaseSpeed() {
        speed += 20;
    }

    public void decreaseSpeed() {
        if (speed > 20)
            speed -= 20;
        else
            speed = 0;
    }
}
