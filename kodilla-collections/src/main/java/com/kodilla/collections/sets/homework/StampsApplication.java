package com.kodilla.collections.sets.homework;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();
        stamps.add(new Stamp("Kraków", 3,2.1, true));
        stamps.add(new Stamp("Wrocław", 2.8,1.8, true));
        stamps.add(new Stamp("Zielona Góra", 3.1,2.1, true));
        stamps.add(new Stamp("Kraków", 3,2.1, true));
        stamps.add(new Stamp("Zakopane", 2.7,2, false));


        System.out.println(stamps.size());
        for (Stamp stamp : stamps)
            System.out.println(stamp);
    }
}
