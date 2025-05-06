package com.kodilla.execution_model.homework;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {

    Shop shop = new Shop();
    Order order1 = new Order(140.50, LocalDate.of(2025,7,9), "Biedronka1");
    Order order2 = new Order(200.00, LocalDate.of(2025,8,8), "user2");
    Order order3 = new Order(99.99, LocalDate.of(2025,11,29), "user3");

    @BeforeEach
    void setUp() {

        shop.addOrder(order1);
        shop.addOrder(order2);
        shop.addOrder(order3);
    }

    @Test
    void shouldAddOrder() {
        assertEquals(3, shop.getNumberOfOrders());
    }

    @Test
    void shouldReturnOrdersBetweenDates() {
        List<Order> result = shop.getOrdersBetweenDates(
                LocalDate.of(2025, 7, 1),
                LocalDate.of(2025, 8, 28)
        );
        assertEquals(2, result.size());
    }

    @Test
    void shouldReturnOrdersBetweenValues() {
        List<Order> result = shop.getOrdersByValueRange(140.0, 350.0);
        assertEquals(2, result.size());
    }

    @Test
    void shouldReturnTotalNumberOfOrders() {
        assertEquals(3, shop.getNumberOfOrders());
    }

    @Test
    void shouldReturnTotalValueOfOrders() {
        double total = shop.getTotalOrderValue();
        assertEquals(440.49, total);
    }

    @Test
    void shouldReturnEmptyListIfNoOrdersInDateRange() {
        List<Order> result = shop.getOrdersBetweenDates(
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 2, 1)
        );
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyListIfNoOrdersInValueRange() {
        List<Order> result = shop.getOrdersByValueRange(500.0, 600.0);
        assertTrue(result.isEmpty());
    }

}