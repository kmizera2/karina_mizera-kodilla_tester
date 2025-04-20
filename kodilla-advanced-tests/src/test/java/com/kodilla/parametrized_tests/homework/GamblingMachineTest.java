package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GamblingMachineTest {

    private final GamblingMachine machine = new GamblingMachine();

    @ParameterizedTest
    @MethodSource("linesProvider")
    void testHowManyWinsPerLine(String line) {
        String data = line.split("#")[0].trim();
        if (data.isEmpty()) {
            return;
        }
        String[] tokens = data.split(",");
        Set<Integer> userNumbers = new HashSet<>();
        boolean parseError = false;
        for (String token : tokens) {
            String t = token.trim();
            try {
                userNumbers.add(Integer.parseInt(t));
            } catch (NumberFormatException e) {
                parseError = true;
                break;
            }
        }

        boolean valid = !parseError
                && userNumbers.size() == 6
                && userNumbers.stream().allMatch(n -> n >= 1 && n <= 49);

        if (!valid) {
            assertThrows(InvalidNumbersException.class,
                    () -> machine.howManyWins(userNumbers),
                    "Linia: \"" + line + "\" powinna rzucić InvalidNumbersException");
        } else {
            try {
                int wins = machine.howManyWins(userNumbers);
                assertTrue(wins >= 0 && wins <= 6,
                        "Linia: \"" + line + "\" wygrań powinno być między 0 a 6, a było: " + wins);
            } catch (InvalidNumbersException e) {
                fail("Linia: \"" + line + "\" to poprawny zestaw -> nie powinien rzucać wyjątku");
            }
        }
    }

    static Stream<String> linesProvider() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(
                        GamblingMachineTest.class.getResourceAsStream("/numbers.csv")
                )
        ));
        return reader.lines();
    }
}