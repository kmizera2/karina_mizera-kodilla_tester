package com.kodilla.collections.sets.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StampTest {

    @Test
    void shouldCreateStampCorrectly() {
        Stamp stamp = new Stamp("Rare Stamp", 5.5, 3.2, true);

        assertEquals("Rare Stamp", stamp.getStampName());
        assertEquals(5.5, stamp.getStampHight());
        assertEquals(3.2, stamp.getStampWidth());
        assertTrue(stamp.isStamped());
    }

    @Test
    void equalsShouldReturnTrueForSameData() {
        Stamp stamp1 = new Stamp("Rare Stamp", 5.5, 3.2, true);
        Stamp stamp2 = new Stamp("Rare Stamp", 5.5, 3.2, true);

        assertEquals(stamp1, stamp2);
        assertTrue(stamp1.equals(stamp2));
        assertTrue(stamp2.equals(stamp1));
    }

    @Test
    void equalsShouldReturnFalseForDifferentData() {
        Stamp stamp1 = new Stamp("Rare Stamp", 5.5, 3.2, true);
        Stamp stamp2 = new Stamp("Common Stamp", 5.5, 3.2, true);

        assertNotEquals(stamp1, stamp2);
    }

    @Test
    void equalsShouldReturnFalseWhenComparedWithNull() {
        Stamp stamp = new Stamp("Rare Stamp", 5.5, 3.2, true);
        assertFalse(stamp.equals(null));
    }

    @Test
    void equalsShouldReturnFalseWhenComparedWithDifferentClass() {
        Stamp stamp = new Stamp("Rare Stamp", 5.5, 3.2, true);
        String notAStamp = "Not a stamp";
        assertFalse(stamp.equals(notAStamp));
    }

    @Test
    void hashCodeShouldBeEqualForEqualObjects() {
        Stamp stamp1 = new Stamp("Rare Stamp", 5.5, 3.2, true);
        Stamp stamp2 = new Stamp("Rare Stamp", 5.5, 3.2, true);

        assertEquals(stamp1.hashCode(), stamp2.hashCode());
    }

    @Test
    void toStringShouldContainAllFields() {
        Stamp stamp = new Stamp("Rare Stamp", 5.5, 3.2, true);
        String toString = stamp.toString();

        assertTrue(toString.contains("Rare Stamp"));
        assertTrue(toString.contains("5.5"));
        assertTrue(toString.contains("3.2"));
        assertTrue(toString.contains("true"));
    }
}