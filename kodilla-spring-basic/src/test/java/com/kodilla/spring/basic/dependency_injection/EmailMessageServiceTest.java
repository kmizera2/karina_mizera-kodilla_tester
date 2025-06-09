package com.kodilla.spring.basic.dependency_injection;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class EmailMessageServiceTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream out;

    private EmailMessageService service;

    @BeforeEach
    void setUp() {
        service = new EmailMessageService();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void shouldPrintEmailMessageCorrectly() {
        // when
        service.send("Hello", "alice@example.com");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending [Hello] to: alice@example.com via Email", printed);
    }

    @Test
    void shouldHandleEmptyMessage() {
        // when
        service.send("", "bob@example.com");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending [] to: bob@example.com via Email", printed);
    }

    @Test
    void shouldHandleEmptyReceiver() {
        // when
        service.send("Update", "");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending [Update] to:  via Email", printed);
    }
}