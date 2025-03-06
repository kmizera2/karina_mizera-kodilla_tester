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

        School kopernik = new School(Arrays.asList(15, 24, 18, 31, 25, 15, 17, 19), "Liceum Ogólnokształcące Im. Kopernika");
        School technikumBudowlane = new School(Arrays.asList(25, 21, 26, 17, 25, 22, 18, 18, 28, 33), "Technikum Budowlane");
        School technikumSamochodowe = new School(Arrays.asList(21, 19, 24, 19, 20, 16, 21, 19, 26, 19, 24, 19), "Technikum Samochodowe");
        School liceumSzymborskiej = new School(Arrays.asList(28, 17, 28, 30, 25, 15, 17, 26), "Liceum Ogólnokształcące Im Szymborskiej");

        school.put(kowalski, kopernik);
        school.put(nowak, technikumBudowlane);
        school.put(mirska, technikumSamochodowe);
        school.put(cichy, liceumSzymborskiej);

        for (Map.Entry<Principal, School> principalEntry : school.entrySet()) {
            System.out.println("Dyrektor " + principalEntry.getKey().getFirstName() + " "
                    + principalEntry.getKey().getLastName() + ", szkoła: "
                    + principalEntry.getValue().getSchoolName()
                    + ", liczba uczniów: " + principalEntry.getValue().getNumberOfStudents());
        }
    }
}
