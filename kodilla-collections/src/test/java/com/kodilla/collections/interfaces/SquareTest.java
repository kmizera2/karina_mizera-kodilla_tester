package com.kodilla.collections.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void shouldCalculateAreaCorrectly() {
        Square square = new Square(5);
        double expectedArea = 25; // 5 * 5
        assertEquals(expectedArea, square.getArea());
    }

    @Test
    void shouldCalculatePerimeterCorrectly() {
        Square square = new Square(5);
        double expectedPerimeter = 20; // 4 * 5
        assertEquals(expectedPerimeter, square.getPerimeter());
    }

    @Test
    void equalsShouldReturnTrueForSameWidth() {
        Square s1 = new Square(4);
        Square s2 = new Square(4);
        assertEquals(s1, s2);
        assertTrue(s1.equals(s2));
    }

    @Test
    void equalsShouldReturnFalseForDifferentWidth() {
        Square s1 = new Square(4);
        Square s2 = new Square(5);
        assertNotEquals(s1, s2);
    }

    @Test
    void equalsShouldReturnFalseWhenComparedToNull() {
        Square square = new Square(4);
        assertFalse(square.equals(null));
    }

    @Test
    void equalsShouldReturnFalseWhenComparedToDifferentClass() {
        Square square = new Square(4);
        String notSquare = "Not a square";
        assertFalse(square.equals(notSquare));
    }

    @Test
    void hashCodeShouldBeEqualForEqualObjects() {
        Square s1 = new Square(4);
        Square s2 = new Square(4);
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    void toStringShouldContainWidth() {
        Square square = new Square(7);
        String str = square.toString();
        assertTrue(str.contains("7.0"));
        assertTrue(str.contains("Square"));
    }
}