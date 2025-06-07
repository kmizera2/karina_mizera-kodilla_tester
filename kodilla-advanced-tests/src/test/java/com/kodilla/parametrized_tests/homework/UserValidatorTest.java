package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private final UserValidator validator = new UserValidator();

    @ParameterizedTest
    @CsvSource({
            "john123, true",
            "gęś, false",
            "a_, false",
            "Anna-Kowalska, true",
            "Anna.Kowalska, true",
            "a, false",
            "Abc, true",
            "a b c, false",
            "user@name, false",
            "___, true",
            "ab, false",
            "1234, true"
    })
    void testValidateUsername(String username, boolean expected) {
        assertEquals(expected, validator.validateUsername(username));
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    public void shouldReturnFalseIfStringIsEmpty(String username) {
        assertFalse(validator.validateUsername(username));
    }

    @ParameterizedTest
    @CsvSource({
            "john.doe@example.com, true",
            "user@domain.co.uk, true",
            "us_er@domain.co.uk, true",
            "user123@domain, false",
            "user 123@domain.bp, false",
            "99123@domain.pl, true",
            "plainaddress, false",
            "plainaddress@, false",
            "@missingusername.com, false",
            "user.name@sub.domain.com, true",
            "user-name@domain.io, true",
            "user@domain.c, true",
            "user@487.c, true",
            "user@domain.22, false",
            "user@do-main.pl, true",
            "user@do-main.pe-el, false",
            "user@do-main.pe.el.el.elt, true", //ciekawe, wczesniej bylo false
            "user@domain.companyname, false",
            "Żółw@qw.pl, false",
            "asdw@żw.pl, false",
            "null, false"
    })
    void testValidateEmail(String email, boolean expected) {
        boolean result = validator.validateEmail("null".equals(email) ? null : email);
        assertEquals(expected, result);
    }
}