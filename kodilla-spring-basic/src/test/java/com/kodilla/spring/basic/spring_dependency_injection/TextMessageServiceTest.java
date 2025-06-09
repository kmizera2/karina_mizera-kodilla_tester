package com.kodilla.spring.basic.spring_dependency_injection;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextMessageServiceTest {

    @Test
    void shouldSendTextMessageCorrectly() {
        // given
        MessageService service = new TextMessageService();

        // when
        String result = service.send("Hello", "John");

        // then
        assertEquals("Sending text [Hello] to: John", result);
    }

    @Test
    void shouldHandleEmptyMessageOrReceiver() {
        // given
        MessageService service = new TextMessageService();

        // when
        String result1 = service.send("", "John");
        String result2 = service.send("Hello", "");

        // then
        assertEquals("Sending text [] to: John", result1);
        assertEquals("Sending text [Hello] to: ", result2);
    }
}