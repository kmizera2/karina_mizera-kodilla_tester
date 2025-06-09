package com.kodilla.spring.basic.spring_dependency_injection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacebookMessageServiceTest {

    @Test
    void shouldSendFacebookMessageCorrectly() {
        // given
        MessageService service = new FacebookMessageService();

        // when
        String result = service.send("Hello", "Alice");

        // then
        assertEquals("Sending [Hello] to: Alice using Facebook", result);
    }

    @Test
    void shouldHandleEmptyMessageOrReceiver() {
        // given
        MessageService service = new FacebookMessageService();

        // when
        String result1 = service.send("", "Alice");
        String result2 = service.send("Hello", "");

        // then
        assertEquals("Sending [] to: Alice using Facebook", result1);
        assertEquals("Sending [Hello] to:  using Facebook", result2);
    }
}