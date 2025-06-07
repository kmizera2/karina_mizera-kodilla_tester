package com.kodilla.execution_model.homework;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testGetOrderValue() {
        // Given
        Order order = new Order(199.99, LocalDate.of(2024, 6, 1), "user123");

        // When
        double value = order.getOrderValue();

        // Then
        assertEquals(199.99, value);
    }

    @Test
    void testGetOrderDate() {
        // Given
        LocalDate date = LocalDate.of(2024, 6, 1);
        Order order = new Order(100.0, date, "user123");

        // When
        LocalDate result = order.getOrderDate();

        // Then
        assertEquals(date, result);
    }

    @Test
    void testGetUserLogin() {
        // Given
        Order order = new Order(100.0, LocalDate.of(2024, 6, 1), "login42");

        // When
        String login = order.getUserLogin();

        // Then
        assertEquals("login42", login);
    }

    @Test
    void testEqualsSameValues() {
        // Given
        Order order1 = new Order(150.0, LocalDate.of(2024, 5, 15), "user1");
        Order order2 = new Order(150.0, LocalDate.of(2024, 5, 15), "user1");

        // Then
        assertEquals(order1, order2);
        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    void testEqualsDifferentOrderValue() {
        Order order1 = new Order(150.0, LocalDate.of(2024, 5, 15), "user1");
        Order order2 = new Order(200.0, LocalDate.of(2024, 5, 15), "user1");

        assertNotEquals(order1, order2);
    }

    @Test
    void testEqualsDifferentOrderDate() {
        Order order1 = new Order(150.0, LocalDate.of(2024, 5, 15), "user1");
        Order order2 = new Order(150.0, LocalDate.of(2024, 6, 1), "user1");

        assertNotEquals(order1, order2);
    }

    @Test
    void testEqualsDifferentUserLogin() {
        Order order1 = new Order(150.0, LocalDate.of(2024, 5, 15), "user1");
        Order order2 = new Order(150.0, LocalDate.of(2024, 5, 15), "user2");

        assertNotEquals(order1, order2);
    }

    @Test
    void testEqualsWithNull() {
        Order order = new Order(100.0, LocalDate.now(), "user");

        assertNotEquals(order, null);
    }

    @Test
    void testEqualsWithDifferentClass() {
        Order order = new Order(100.0, LocalDate.now(), "user");

        assertNotEquals(order, "not an order");
    }

    @Test
    void testEqualsWithSameReference() {
        Order order = new Order(100.0, LocalDate.now(), "user");

        assertEquals(order, order);
    }
}