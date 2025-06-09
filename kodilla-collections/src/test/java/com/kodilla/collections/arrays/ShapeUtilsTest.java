package com.kodilla.collections.arrays;

import com.kodilla.collections.interfaces.Circle;
import com.kodilla.collections.interfaces.Shape;
import com.kodilla.collections.interfaces.Square;
import com.kodilla.collections.interfaces.Triangle;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ShapeUtilsTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void shouldDisplayCircleInfo() {
        Shape circle = new Circle(5);
        ShapeUtils.displayShapeInfo(circle);

        String result = output.toString();
        assertTrue(result.contains("Shape kind: Circle"));
        assertTrue(result.contains("Shape area: " + circle.getArea()));
        assertTrue(result.contains("Shape perimeter: " + circle.getPerimeter()));
    }

    @Test
    void shouldDisplayTriangleInfo() {
        Shape triangle = new Triangle(3, 4, 5);
        output.reset();
        ShapeUtils.displayShapeInfo(triangle);

        String result = output.toString();
        assertTrue(result.contains("Shape kind: Triangle"));
        assertTrue(result.contains("Shape area: " + triangle.getArea()));
        assertTrue(result.contains("Shape perimeter: " + triangle.getPerimeter()));
    }

    @Test
    void shouldDisplaySquareInfo() {
        Shape square = new Square(4);
        output.reset();
        ShapeUtils.displayShapeInfo(square);

        String result = output.toString();
        assertTrue(result.contains("Shape kind: Square"));
        assertTrue(result.contains("Shape area: " + square.getArea()));
        assertTrue(result.contains("Shape perimeter: " + square.getPerimeter()));
    }

    @Test
    void shouldDisplayUnknownShapeInfo() {
        Shape unknown = new Shape() {
            @Override
            public double getArea() {
                return 1.23;
            }

            @Override
            public double getPerimeter() {
                return 4.56;
            }
        };
        output.reset();
        ShapeUtils.displayShapeInfo(unknown);

        String result = output.toString();
        assertTrue(result.contains("Shape kind: Unknown shape name"));
        assertTrue(result.contains("Shape area: 1.23"));
        assertTrue(result.contains("Shape perimeter: 4.56"));
    }
}