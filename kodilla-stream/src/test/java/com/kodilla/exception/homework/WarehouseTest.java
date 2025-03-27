package com.kodilla.exception.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
    @Test
    void testAddAndRetrieveOrder() throws OrderDoesntExistException {
        Warehouse warehouse = new Warehouse();
        Order order = new Order("12/po/18");
        warehouse.addOrder(order);
        Order retrievedOrder = warehouse.getOrder("12/po/18");

        assertEquals(order.getNumber(), retrievedOrder.getNumber());
    }

    @Test
    void testGetOrder_NotFound() {
        Warehouse warehouse = new Warehouse();

        Exception exception = assertThrows(OrderDoesntExistException.class, () -> {
            warehouse.getOrder("9999abc");
        });

        assertEquals("Zamówienie o numerze 9999abc nie istnieje", exception.getMessage());
    }

}