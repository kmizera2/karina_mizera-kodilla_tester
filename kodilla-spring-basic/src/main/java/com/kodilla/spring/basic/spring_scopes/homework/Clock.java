package com.kodilla.spring.basic.spring_scopes.homework;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope("prototype")
public class Clock {

    private final LocalTime time;

    public Clock() {
        this.time = LocalTime.now();
        System.out.println("Clock bean created at: " + time);
    }

    public LocalTime getTime() {
        return time;
    }
}

