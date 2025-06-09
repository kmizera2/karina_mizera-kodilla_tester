package com.kodilla.collections.lists.homework;


import com.kodilla.collections.interfaces.homework.Ford;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.collections.arrays.homework.CarUtils.describeCar;

public class CarsListApplication {
    public static void main(String[] args) {
        List<Ford> fords = new ArrayList<>();
        fords.add(new Ford(10));
        fords.add(new Ford(50));
        fords.add(new Ford(32));
        fords.add(new Ford(39));

        for (Ford ford : fords) {
            describeCar(ford);
        }

        fords.remove(1);

        Ford fordPatternToRemove = new Ford(39);
        fords.remove(fordPatternToRemove);

        System.out.println(fords.size());

        for (Ford ford : fords) {
            describeCar(ford);
        }
    }
}
