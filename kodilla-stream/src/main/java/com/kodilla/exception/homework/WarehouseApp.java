package com.kodilla.exception.homework;

import static com.kodilla.exception.homework.Warehouse.*;

public class WarehouseApp {
    public static void main(String[] args) {

        addOrder(new Order("1/kotlet/14"));
        addOrder(new Order("1/kurczak/1"));
        addOrder(new Order("1/kotlet/15"));
        addOrder(new Order("21/kalfior/10"));

        try {
            System.out.println("Zamówienie: " + getOrder("1/kotlet/15").getNumber().toString() + " istnieje");
        } catch (OrderDoesntExistException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        try {
            System.out.println("Zamówienie: " + getOrder("1/kotlet/10").getNumber().toString() + " istnieje");
        } catch (OrderDoesntExistException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

}
