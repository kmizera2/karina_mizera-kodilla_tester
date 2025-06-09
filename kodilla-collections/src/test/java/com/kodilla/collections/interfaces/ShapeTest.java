package com.kodilla.collections.interfaces;

import com.kodilla.collections.interfaces.Shape;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeInterfaceTest {

    @Test
    void shouldReturnCorrectAreaAndPerimeter() {
        Shape testShape = new Shape() {
            @Override
            public double getArea() {
                return 25.0;
            }

            @Override
            public double getPerimeter() {
                return 30.0;
            }
        };

        assertEquals(25.0, testShape.getArea());
        assertEquals(30.0, testShape.getPerimeter());
    }
}