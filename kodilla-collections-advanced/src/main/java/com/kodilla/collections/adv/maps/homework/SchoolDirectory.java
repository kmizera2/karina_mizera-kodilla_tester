package com.kodilla.collections.adv.maps.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {
    public static void main(String[] args) {

        Map<Principal, School> school = new HashMap<>();

        Principal kowalski = new Principal("Jan", "Kowalski");
        Principal nowak = new Principal("Jan", "Nowak");
        Principal mirska = new Principal("Ewa", "Mirska");
        Principal cichy = new Principal("Marian", "Cichy");


        School liceumOgólnokształcąceImKopernika = new School(Arrays.asList(15, 24, 18, 31, 25,15,17,19));
        School technikumBudowlane = new School(Arrays.asList(25, 21, 26, 17, 25, 22, 18, 18, 28, 33));
        School technikumSamochodowe = new School(Arrays.asList(21, 19, 24, 19, 20, 16, 21, 19, 26, 19, 24, 19));
        School liceumOgólnokształcąceImSzymborskiej = new School(Arrays.asList(28, 17, 28, 30, 25, 15, 17, 26));

        school.put(kowalski, liceumOgólnokształcąceImKopernika);
        school.put(nowak, technikumBudowlane);
        school.put(mirska, technikumSamochodowe);
        school.put(cichy, liceumOgólnokształcąceImSzymborskiej);

        for (Map.Entry<Principal, School> principalEntry: school.entrySet()){
            System.out.println("Dyrektor " + principalEntry.getKey().getFirstName() + " "
                    + principalEntry.getKey().getLastName() + ", szkoła: "
                   //nazwa szkoły
                    // +school.get(school)
                   // + school.get(school).
                    +"liczba uczniów: "
                    + principalEntry.getValue().getNumberOfStudents());
        }

       // System.out.println("szkoła "+school.)

    }
}
