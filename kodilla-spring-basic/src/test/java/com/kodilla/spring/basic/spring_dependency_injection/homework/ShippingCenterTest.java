package com.kodilla.spring.basic.spring_dependency_injection.homework;
import com.kodilla.spring.basic.spring_dependency_injection.SkypeMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class ShippingCenterTest {

    @Autowired
    private ShippingCenter shippingCenter;

    @Test
    public void shouldDeliverPackageIsEqualTo30() {
        String message = shippingCenter.sendPackage("Testowy adres 1", 30);
        Assertions.assertEquals("Package delivered to: Testowy adres 1", message);
    }

    @Test
    public void shouldDeliverPackageIsLessThan30() {
        String message = shippingCenter.sendPackage("Testowy adres 2", 29);
        Assertions.assertEquals("Package delivered to: Testowy adres 2", message);
    }

    @Test
    public void shouldNotDeliverPackageIsHeavierThan30() {
        String message = shippingCenter.sendPackage("Testowy adres 3", 31);
        Assertions.assertEquals("Package not delivered to: Testowy adres 3", message);
    }


    }