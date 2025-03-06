package com.kodilla.collections.adv.maps.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class School {

    private List<Integer> schools = new ArrayList<>();
    private String schoolName;

    public School(List<Integer> schools, String schoolName) {
        this.schools = schools;
        this.schoolName = schoolName;
    }

    public int getNumberOfStudents() {
        int sum = 0;
        for (int school : schools)
            sum += school;
        return sum;
    }

    @Override
    public String toString() {
        return "School{" +
                "schools=" + schools +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }

    public String getSchoolName() {
        return schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(schools, school.schools) && Objects.equals(schoolName, school.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schools, schoolName);
    }
}
