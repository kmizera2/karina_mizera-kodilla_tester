package com.kodilla.collections.adv.maps.homework;

import java.util.ArrayList;
import java.util.List;

public class School {

    private List<Integer> schools = new ArrayList<>();

    public School(List<Integer> schools) {
        this.schools = schools;
    }

    public int getNumberOfStudents(){
        int sum = 0;
        for (int school : schools)
            sum += school;
        return sum;
    }

    @Override
    public String toString() {
        return "School{" +
                "schools=" + schools +
                '}';
    }

    public List<Integer> getSchools() {
        return schools;
    }

    public void setSchools(List<Integer> schools) {
        this.schools = schools;
    }


}
