package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.engine.support.hierarchical.SingleTestExecutor;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @ParameterizedTest
    @MethodSource("com.kodilla.parametrized_tests.homework.BMIDataProvider#bmiData")
    void shouldReturnCorrectBmiCategory(double height, double weight, String expectedCategory) {
        Person person = new Person(height, weight);
        assertEquals(expectedCategory, person.getBMI(),
                () -> String.format("Expected BMI category '%s' for height=%.2f, weight=%.2f but was '%s'",
                        expectedCategory, height, weight, person.getBMI()));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 50.0, Invalid data",
            "-1.70, 65.0, Invalid data",
            "1.70, -65.0, Invalid data"
    })
    void shouldReturnInvalidDataForWrongInput(double height, double weight, String expected) {
        Person person = new Person(height, weight);
        assertEquals(expected, person.getBMI());
    }

}