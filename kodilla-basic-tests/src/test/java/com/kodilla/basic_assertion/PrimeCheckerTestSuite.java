
package com.kodilla.basic_assertion;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PrimeCheckerTestSuite {

    PrimeChecker checker = new PrimeChecker();
    private static int count;

    @Test
    public void shouldReturnFalseWhenPassingNotPrimeNumber() {
        boolean result = checker.isPrime(14);
        count++;
        System.out.println("Test number " + count);
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenPassingPrimeNumber() {
        boolean result = checker.isPrime(13);
        count++;
        System.out.println("Test number " + count);
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenPassingTwo() {
        boolean result = checker.isPrime(2);
        count++;
        System.out.println("Test number " + count);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenPassingOne() {
        boolean result = checker.isPrime(1);
        count++;
        System.out.println("Test number " + count);
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenPassingZero() {
        boolean result = checker.isPrime(0);
        count++;
        System.out.println("Test number " + count);
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenPassingNegativeNumber() {
        boolean result = checker.isPrime(-6);
        count++;
        System.out.println("Test number " + count);
        assertFalse(result);
    }
}
