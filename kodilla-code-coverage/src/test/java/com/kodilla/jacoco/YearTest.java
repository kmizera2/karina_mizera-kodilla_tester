package com.kodilla.jacoco;



import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;



class YearTest {

    @Test
    void shouldBeLeapYearIfDivisibleBy400() {

        //given
        Year year = new Year(1600);

        //when
        boolean isLeapYear = year.isLeap();

        //then
        assertTrue(isLeapYear);
    }



    @Test
    void shouldNotBeLeapYearIfNotDivisibleBy4() {
        Year year = new Year(2023);
        assertFalse(year.isLeap());
    }

    @Test
    void shouldBeLeapYearIfDivisibleBy4ButNotBy100() {
        Year year = new Year(2024);
        assertTrue(year.isLeap());
    }

    @Test
    void shouldNotBeLeapYearIfDivisibleBy100ButNotBy400() {
        Year year = new Year(1900);
        assertFalse(year.isLeap());
    }
}

