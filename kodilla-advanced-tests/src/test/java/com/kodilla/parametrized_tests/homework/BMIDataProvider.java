package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class BMIDataProvider {
    public static Stream<Arguments> bmiData() {
        return Stream.of(
                Arguments.of(1.80,  47.0, "Very severely underweight"),
                Arguments.of(1.60,  25.0, "Very severely underweight"),
                Arguments.of(1.70,  27.0, "Very severely underweight"),
                Arguments.of(1.65,  39.0, "Very severely underweight"),
                Arguments.of(1.65,  42.0, "Severely underweight"),
                Arguments.of(1.75,  55.0, "Underweight"),
                Arguments.of(1.80,  70.0, "Normal (healthy weight)"),
                Arguments.of(1.70,  75.0, "Overweight"),
                Arguments.of(1.65,  85.0, "Obese Class I (Moderately obese)"),
                Arguments.of(1.60, 100.0, "Obese Class II (Severely obese)"),
                Arguments.of(1.55, 100.0, "Obese Class III (Very severely obese)"),
                Arguments.of(1.50, 110.0, "Obese Class IV (Morbidly Obese)"),
                Arguments.of(1.50, 130.0, "Obese Class V (Super Obese)"),
                Arguments.of(1.40, 120.0, "Obese Class VI (Hyper Obese)")
        );
    }
}
