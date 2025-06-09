package com.kodilla.collections.interfaces.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FordTest {

    @Test
    void shouldReturnInitialSpeed() {
        Ford ford = new Ford(50);
        assertEquals(50, ford.getSpeed());
    }

    @Test
    void shouldIncreaseSpeedBy20() {
        Ford ford = new Ford(30);
        ford.increaseSpeed();
        assertEquals(50, ford.getSpeed());
    }

    @Test
    void shouldDecreaseSpeedBy20WhenSpeedAbove20() {
        Ford ford = new Ford(50);
        ford.decreaseSpeed();
        assertEquals(30, ford.getSpeed());
    }

    @Test
    void shouldSetSpeedToZeroWhenSpeedIs20OrLess() {
        Ford ford = new Ford(20);
        ford.decreaseSpeed();
        assertEquals(0, ford.getSpeed());

        Ford ford2 = new Ford(10);
        ford2.decreaseSpeed();
        assertEquals(0, ford2.getSpeed());
    }

    @Test
    void equalsShouldReturnTrueForSameSpeed() {
        Ford ford1 = new Ford(40);
        Ford ford2 = new Ford(40);
        assertEquals(ford1, ford2);
    }

    @Test
    void equalsShouldReturnFalseForDifferentSpeed() {
        Ford ford1 = new Ford(40);
        Ford ford2 = new Ford(30);
        assertNotEquals(ford1, ford2);
    }

    @Test
    void equalsShouldReturnFalseForNull() {
        Ford ford = new Ford(40);
        assertFalse(ford.equals(null));
    }

    @Test
    void equalsShouldReturnFalseForDifferentClass() {
        Ford ford = new Ford(40);
        String notFord = "Not a Ford";
        assertFalse(ford.equals(notFord));
    }

    @Test
    void hashCodeShouldBeEqualForEqualObjects() {
        Ford ford1 = new Ford(40);
        Ford ford2 = new Ford(40);
        assertEquals(ford1.hashCode(), ford2.hashCode());
    }
}