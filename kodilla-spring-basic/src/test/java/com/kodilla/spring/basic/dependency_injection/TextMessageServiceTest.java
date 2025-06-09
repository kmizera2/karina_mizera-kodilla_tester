package com.kodilla.spring.basic.dependency_injection;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TextMessageServiceTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream out;
    private TextMessageService service;

    @BeforeEach
    void setUp() {
        service = new TextMessageService();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void shouldPrintTextMessageCorrectly() {
        // when
        service.send("Hello", "recipient");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending text [Hello] to: recipient", printed);
    }

    @Test
    void shouldHandleEmptyMessage() {
        // when
        service.send("", "recipient");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending text [] to: recipient", printed);
    }

    @Test
    void shouldHandleEmptyReceiver() {
        // when
        service.send("Hello", "");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending text [Hello] to:", printed);
    }
}







