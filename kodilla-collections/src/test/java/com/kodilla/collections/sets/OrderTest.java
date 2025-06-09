package com.kodilla.collections.sets;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void shouldCreateOrderCorrectly() {
        Order order = new Order("123", "ProductA", 10.5);

        assertEquals("123", order.getOrderNumber());
        assertEquals("ProductA", order.getProductName());
        assertEquals(10.5, order.getQuantity());
    }

    @Test
    void equalsShouldReturnTrueForSameData() {
        Order order1 = new Order("123", "ProductA", 10.5);
        Order order2 = new Order("123", "ProductA", 10.5);

        assertEquals(order1, order2);
        assertTrue(order1.equals(order2));
        assertTrue(order2.equals(order1));
    }

    @Test
    void equalsShouldReturnFalseForDifferentData() {
        Order order1 = new Order("123", "ProductA", 10.5);
        Order order2 = new Order("124", "ProductB", 5.0);

        assertNotEquals(order1, order2);
        assertFalse(order1.equals(order2));
        assertFalse(order2.equals(order1));
    }

    @Test
    void equalsShouldReturnFalseWhenComparedWithNull() {
        Order order = new Order("123", "ProductA", 10.5);
        assertFalse(order.equals(null));
    }

    @Test
    void equalsShouldReturnFalseWhenComparedWithDifferentClass() {
        Order order = new Order("123", "ProductA", 10.5);
        String notAnOrder = "some string";
        assertFalse(order.equals(notAnOrder));
    }

    @Test
    void hashCodeShouldBeEqualForEqualObjects() {
        Order order1 = new Order("123", "ProductA", 10.5);
        Order order2 = new Order("123", "ProductA", 10.5);

        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    void toStringShouldContainAllFields() {
        Order order = new Order("123", "ProductA", 10.5);
        String toString = order.toString();

        assertTrue(toString.contains("123"));
        assertTrue(toString.contains("ProductA"));
        assertTrue(toString.contains("10.5"));
    }
}