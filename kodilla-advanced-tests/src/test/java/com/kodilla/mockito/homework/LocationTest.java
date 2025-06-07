package com.kodilla.mockito.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testGetName() {
        // Given
        Location location = new Location("Warsaw");

        // When
        String name = location.getName();

        // Then
        assertEquals("Warsaw", name);
    }

    @Test
    void testEqualsSameValues() {
        // Given
        Location location1 = new Location("Krakow");
        Location location2 = new Location("Krakow");

        // Then
        assertEquals(location1, location2);
        assertEquals(location1.hashCode(), location2.hashCode());
    }

    @Test
    void testEqualsDifferentValues() {
        // Given
        Location location1 = new Location("Gdansk");
        Location location2 = new Location("Wroclaw");

        // Then
        assertNotEquals(location1, location2);
    }

    @Test
    void testEqualsWithNull() {
        // Given
        Location location = new Location("Lodz");

        // Then
        assertNotEquals(location, null);
    }

    @Test
    void testEqualsWithDifferentClass() {
        // Given
        Location location = new Location("Poznan");

        // Then
        assertNotEquals(location, "Poznan");
    }

    @Test
    void testEqualsWithSameReference() {
        // Given
        Location location = new Location("Katowice");

        // Then
        assertEquals(location, location);
    }

    @Test
    void testHashCodeConsistency() {
        // Given
        Location location = new Location("Rzeszow");

        // Then
        int initialHashCode = location.hashCode();
        assertEquals(initialHashCode, location.hashCode());
        assertEquals(initialHashCode, location.hashCode());
    }
}