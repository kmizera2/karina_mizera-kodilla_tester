package com.kodilla.spring.basic.spring_dependency_injection;


import com.kodilla.spring.basic.spring_dependency_injection.homework.ShippingCenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SimpleApplicationTest {



    @Test
    public void shouldReturnCorrectMessage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        SkypeMessageService bean = context.getBean(SkypeMessageService.class);
        String message = bean.send("Test", "Any receiver");
        Assertions.assertNotNull(message);
    }

    @Test
    public void shouldProcessMessage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        SimpleApplication bean = context.getBean(SimpleApplication.class);
        String message = bean.processMessage("Test", "Any receiver");
        Assertions.assertEquals("Sending [Test] to: Any receiver using Skype", message);
        //Assertions.assertNotNull(message); //też by moglo byc
    }

}