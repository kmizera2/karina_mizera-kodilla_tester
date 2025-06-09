package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultCheckerTest {

    @Test
    void shouldReturnTrueForEqualInts() {
        assertTrue(ResultChecker.assertEquals(5, 5));
    }

    @Test
    void shouldReturnFalseForDifferentInts() {
        assertFalse(ResultChecker.assertEquals(5, 10));
    }

    @Test
    void shouldReturnTrueForEqualDoubles() {
        assertTrue(ResultChecker.assertEquals2(3.14, 3.14));
    }

    @Test
    void shouldReturnFalseForDifferentDoubles() {
        assertFalse(ResultChecker.assertEquals2(3.14, 2.71));
    }

    @Test
    void shouldReturnFalseForEqualDoublesWithSmallDifference() {
        // UWAGA: Metoda porównuje "==", więc różnice precyzji mogą powodować false
        assertFalse(ResultChecker.assertEquals2(1.0000001, 1.0000002));
    }
}