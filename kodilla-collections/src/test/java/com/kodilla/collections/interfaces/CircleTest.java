package com.kodilla.collections.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void shouldCalculateAreaCorrectly() {
        Circle circle = new Circle(3);
        double expectedArea = Math.PI * 3 * 3;
        assertEquals(expectedArea, circle.getArea(), 1e-9);
    }

    @Test
    void shouldCalculatePerimeterCorrectly() {
        Circle circle = new Circle(3);
        double expectedPerimeter = 2 * Math.PI * 3;
        assertEquals(expectedPerimeter, circle.getPerimeter(), 1e-9);
    }

    @Test
    void equalsShouldReturnTrueForSameRadius() {
        Circle c1 = new Circle(4);
        Circle c2 = new Circle(4);
        assertEquals(c1, c2);
        assertTrue(c1.equals(c2));
    }

    @Test
    void equalsShouldReturnFalseForDifferentRadius() {
        Circle c1 = new Circle(4);
        Circle c2 = new Circle(5);
        assertNotEquals(c1, c2);
    }

    @Test
    void equalsShouldReturnFalseWhenComparedToNull() {
        Circle circle = new Circle(4);
        assertFalse(circle.equals(null));
    }

    @Test
    void equalsShouldReturnFalseWhenComparedToDifferentClass() {
        Circle circle = new Circle(4);
        String notCircle = "Not a circle";
        assertFalse(circle.equals(notCircle));
    }

    @Test
    void hashCodeShouldBeEqualForEqualObjects() {
        Circle c1 = new Circle(4);
        Circle c2 = new Circle(4);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void toStringShouldContainRadius() {
        Circle circle = new Circle(7);
        String str = circle.toString();
        assertTrue(str.contains("7.0"));
        assertTrue(str.contains("Circle"));
    }
}