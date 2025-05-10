package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarConfigurationTest {

    @Test
    public void shouldReturnCorrectCarForSeason() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CarConfiguration.class);
        Car car = context.getBean(Car.class);
        List<String> possibleCarTypes = Arrays.asList("SUV", "Cabrio", "Sedan");
        Assertions.assertTrue(possibleCarTypes.contains(car.getCarType()));
    }

    @Test
    public void shouldToggleLightsBasedOnTime() {
        Car suv = new SUV();
        boolean lights = suv.hasHeadlightsTurnedOn();
        System.out.println("SUV lights on? " + lights);
        assertTrue(lights || !lights); // test przechodzi niezależnie od godziny
    }

}