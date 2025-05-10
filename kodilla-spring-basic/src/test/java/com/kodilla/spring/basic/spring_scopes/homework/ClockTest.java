package com.kodilla.spring.basic.spring_scopes.homework;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ClockTest {

    @Test
    public void shouldCreateDifferentClocks() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");

        Clock clock1 = context.getBean(Clock.class);
        Thread.sleep(1000);
        Clock clock2 = context.getBean(Clock.class);

        assertNotEquals(clock1.getTime(), clock2.getTime());
        context.close();
    }
}