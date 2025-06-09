package com.kodilla.collections.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void shouldCalculateAreaCorrectly() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expectedArea = 3 * 4 / 2.0;
        assertEquals(expectedArea, triangle.getArea());
    }

    @Test
    void shouldCalculatePerimeterCorrectly() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expectedPerimeter = 3 + 4 + 5;
        assertEquals(expectedPerimeter, triangle.getPerimeter());
    }

    @Test
    void equalsShouldReturnTrueForSameValues() {
        Triangle t1 = new Triangle(3, 4, 5);
        Triangle t2 = new Triangle(3, 4, 5);
        assertEquals(t1, t2);
        assertTrue(t1.equals(t2));
        assertTrue(t2.equals(t1));
    }

    @Test
    void equalsShouldReturnFalseForDifferentValues() {
        Triangle t1 = new Triangle(3, 4, 5);
        Triangle t2 = new Triangle(5, 12, 13);
        assertNotEquals(t1, t2);
    }

    @Test
    void equalsShouldReturnFalseWhenComparedToNull() {
        Triangle t = new Triangle(3, 4, 5);
        assertFalse(t.equals(null));
    }

    @Test
    void equalsShouldReturnFalseWhenComparedToDifferentClass() {
        Triangle t = new Triangle(3, 4, 5);
        String notTriangle = "Not a triangle";
        assertFalse(t.equals(notTriangle));
    }

    @Test
    void hashCodeShouldBeEqualForEqualObjects() {
        Triangle t1 = new Triangle(3, 4, 5);
        Triangle t2 = new Triangle(3, 4, 5);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void toStringShouldContainAllFields() {
        Triangle t = new Triangle(3, 4, 5);
        String toString = t.toString();
        assertTrue(toString.contains("3.0"));
        assertTrue(toString.contains("4.0"));
        assertTrue(toString.contains("5.0"));
    }
}