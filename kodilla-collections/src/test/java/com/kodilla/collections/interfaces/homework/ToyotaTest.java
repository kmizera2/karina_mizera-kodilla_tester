package com.kodilla.collections.interfaces.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToyotaTest {

    @Test
    void shouldReturnInitialSpeed() {
        Toyota toyota = new Toyota(30);
        assertEquals(30, toyota.getSpeed());
    }

    @Test
    void shouldIncreaseSpeedBy10() {
        Toyota toyota = new Toyota(5);
        toyota.increaseSpeed();
        assertEquals(15, toyota.getSpeed());
    }

    @Test
    void shouldDecreaseSpeedBy20WhenSpeedAbove20() {
        Toyota toyota = new Toyota(50);
        toyota.decreaseSpeed();
        assertEquals(30, toyota.getSpeed());
    }

    @Test
    void shouldSetSpeedToZeroWhenSpeedIs20OrLess() {
        Toyota toyota = new Toyota(20);
        toyota.decreaseSpeed();
        assertEquals(0, toyota.getSpeed());

        Toyota toyota2 = new Toyota(10);
        toyota2.decreaseSpeed();
        assertEquals(0, toyota2.getSpeed());
    }
}