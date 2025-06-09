package com.kodilla.collections.interfaces.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OpelTest {

    @Test
    void shouldReturnInitialSpeed() {
        Opel opel = new Opel(30);
        assertEquals(30, opel.getSpeed());
    }

    @Test
    void shouldIncreaseSpeedBy7() {
        Opel opel = new Opel(10);
        opel.increaseSpeed();
        assertEquals(17, opel.getSpeed());
    }

    @Test
    void shouldDecreaseSpeedBy22WhenSpeedAbove22() {
        Opel opel = new Opel(50);
        opel.decreaseSpeed();
        assertEquals(28, opel.getSpeed());
    }

    @Test
    void shouldSetSpeedToZeroWhenSpeedIs22OrLess() {
        Opel opel = new Opel(22);
        opel.decreaseSpeed();
        assertEquals(0, opel.getSpeed());

        Opel opel2 = new Opel(10);
        opel2.decreaseSpeed();
        assertEquals(0, opel2.getSpeed());
    }
}