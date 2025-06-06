package com.kodilla.jacoco;

public class Year {
    private final int value;

    public Year(int value) {
        this.value = value;
    }


    public boolean isLeap() {
        return (value % 4 == 0) && ((value % 100 != 0) || (value % 400 == 0));
    }

}