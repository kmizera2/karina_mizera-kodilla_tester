package com.kodilla.spring.basic.dependency_injection;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class SkypeMessageServiceTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream out;
    private SkypeMessageService service;

    @BeforeEach
    void setUp() {
        service = new SkypeMessageService();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void shouldPrintSkypeMessageCorrectly() {
        // when
        service.send("Hello", "charlie");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending [Hello] to: charlie using Skype", printed);
    }

    @Test
    void shouldHandleEmptyMessage() {
        // when
        service.send("", "dave");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending [] to: dave using Skype", printed);
    }

    @Test
    void shouldHandleEmptyReceiver() {
        // when
        service.send("Update", "");

        // then
        String printed = out.toString().trim();
        assertEquals("Sending [Update] to:  using Skype", printed);
    }
}