package com.kodilla.exception.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Warehouse {
    public static List<Order> orders = new ArrayList<>();

    static void addOrder(Order order) {
        orders.add(order);
    }

    static Order getOrder(String number) throws OrderDoesntExistException {
        return (Order) orders.stream()
                .filter(order -> order.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new OrderDoesntExistException("Zamówienie o numerze " + number + " nie istnieje"));
    }

}
