package com.kodilla.collections.interfaces.homework;

public class Toyota implements Car {
    private int speed;

    public Toyota (int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void increaseSpeed() {
        speed += 10;
    }

    public void decreaseSpeed() {
        if (speed > 20)
            speed -= 20;
        else
            speed = 0;
    }
}
