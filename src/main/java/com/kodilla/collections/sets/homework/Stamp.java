package com.kodilla.collections.sets.homework;

import java.util.Objects;

public class Stamp {

    private String stampName;
    private double stampHight;
    private double stampWidth;
    private boolean isStamped;

    public Stamp(String stampName, double stampHight, double stampWidth, boolean isStamped) {
        this.stampName = stampName;
        this.stampHight = stampHight;
        this.stampWidth = stampWidth;
        this.isStamped = isStamped;
    }

    public String getStampName() {
        return stampName;
    }

    public double getStampHight() {
        return stampHight;
    }

    public double getStampWidth() {
        return stampWidth;
    }

    public boolean isStamped() {
        return isStamped;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stamp stamp = (Stamp) o;
        return Double.compare(stampHight, stamp.stampHight) == 0 && Double.compare(stampWidth, stamp.stampWidth) == 0 && isStamped == stamp.isStamped && Objects.equals(stampName, stamp.stampName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stampName, stampHight, stampWidth, isStamped);
    }

    @Override
    public String toString() {
        return "Stamp{" +
                "stampName='" + stampName + '\'' +
                ", stampHight=" + stampHight +
                ", stampWidth=" + stampWidth +
                ", isStamped=" + isStamped +
                '}';
    }
}
