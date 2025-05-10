package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Month;
import java.time.LocalDate;

@Configuration
public class CarConfiguration {

    @Bean
    public Car car() {
        Month month = LocalDate.now().getMonth();

        switch (month) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                return new SUV();
            case JUNE:
            case JULY:
            case AUGUST:
                return new Cabrio();
            default:
                return new Sedan();
        }
    }
}
