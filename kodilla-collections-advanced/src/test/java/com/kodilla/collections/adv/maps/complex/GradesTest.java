package com.kodilla.collections.adv.maps.complex;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class GradesTest {

    @Test
    void shouldCalculateAverageCorrectly() {
        // given
        Grades grades = new Grades(Arrays.asList(4.0, 5.0, 3.0));

        // when
        double average = grades.getAverage();

        // then
        assertEquals(4.0, average, 0.001);
    }



    @Test
    void shouldReturnCorrectToString() {
        // given
        Grades grades = new Grades(Arrays.asList(5.0, 4.5));

        // when
        String result = grades.toString();

        // then
        assertEquals("Grades: [5.0, 4.5]", result);
    }
}