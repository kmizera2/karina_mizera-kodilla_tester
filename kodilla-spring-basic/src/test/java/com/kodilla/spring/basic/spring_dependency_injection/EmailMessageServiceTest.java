package com.kodilla.spring.basic.spring_dependency_injection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailMessageServiceTest {

    @Test
    void shouldSendEmailMessageCorrectly() {
        // given
        MessageService service = new EmailMessageService();

        // when
        String result = service.send("Greetings", "bob@example.com");

        // then
        assertEquals("Sending [Greetings] to: bob@example.com via Email", result);
    }

    @Test
    void shouldHandleEmptyMessageOrReceiver() {
        // given
        MessageService service = new EmailMessageService();

        // when
        String result1 = service.send("", "bob@example.com");
        String result2 = service.send("Greetings", "");

        // then
        assertEquals("Sending [] to: bob@example.com via Email", result1);
        assertEquals("Sending [Greetings] to:  via Email", result2);
    }
}