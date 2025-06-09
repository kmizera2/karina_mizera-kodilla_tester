package com.kodilla.spring.basic.dependency_injection;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FacebookMessageServiceTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream out;
    private FacebookMessageService service;

    @BeforeEach
    void setUp() {
        service = new FacebookMessageService();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void shouldPrintFacebookMessageCorrectly() {
        // when
        service.send("Hello", "alice");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending [Hello] to: alice using Facebook", printed);
    }

    @Test
    void shouldHandleEmptyMessage() {
        // when
        service.send("", "bob");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending [] to: bob using Facebook", printed);
    }

    @Test
    void shouldHandleEmptyReceiver() {
        // when
        service.send("Update", "");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending [Update] to:  using Facebook", printed);
    }
}