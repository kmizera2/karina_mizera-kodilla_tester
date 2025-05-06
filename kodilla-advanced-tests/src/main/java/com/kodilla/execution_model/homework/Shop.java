package com.kodilla.execution_model.homework;
import java.util.HashSet;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Shop {

    private Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersBetweenDates(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(order -> !order.getOrderDate().isBefore(from) && !order.getOrderDate().isAfter(to))
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersByValueRange(double minValue, double maxValue) {
        return orders.stream()
                .filter(order -> order.getOrderValue() >= minValue && order.getOrderValue() <= maxValue)
                .collect(Collectors.toList());
    }

    public int getNumberOfOrders() {
        return orders.size();
    }

    public double getTotalOrderValue() {
        return orders.stream()
                .mapToDouble(Order::getOrderValue)
                .sum();
    }
}
