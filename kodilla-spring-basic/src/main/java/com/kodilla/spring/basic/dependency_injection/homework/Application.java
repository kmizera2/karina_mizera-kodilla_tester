package com.kodilla.spring.basic.dependency_injection.homework;

public class Application {
    public static void main(String[] args) {

        DeliveryService deliveryService = new DeliveryServiceImpl();
        NotificationService notificationService = new NotificationServiceImpl();
        ShippingCenter shippingCenter =
                new ShippingCenter(deliveryService, notificationService);

        shippingCenter.sendPackage("Hill Street 11, New York", 18.2);
    }
}
