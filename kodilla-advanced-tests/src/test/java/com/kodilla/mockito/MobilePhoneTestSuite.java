package com.kodilla.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


public class MobilePhoneTestSuite {


    MobilePhone myPhone = Mockito.mock(MobilePhone.class);

    @Test
    public void testDefaultBehaviourOfTestDouble() {
        Assertions.assertFalse(myPhone.needsCharging());
        Assertions.assertEquals(0.0, myPhone.getFreeStorage());
    }

    @Test
    public void testExpectation() {
        Assertions.assertFalse(myPhone.needsCharging());
        Mockito.when(myPhone.needsCharging()).thenReturn(true);
        Assertions.assertTrue(myPhone.needsCharging());
    }

    @Test
    public void testExpectation2() {
        Assertions.assertFalse(myPhone.needsCharging());
        Mockito.when(myPhone.getFreeStorage()).thenReturn(5.0);
        Assertions.assertEquals(5.0, myPhone.getFreeStorage());
    }

    @Test
    public void shouldCallLaunchApplication() {
        myPhone.launchApplication("Tetris4D");
        Mockito.verify(myPhone).launchApplication("Tetris4D");
    }

    @Test
    public void testVerificationFailure() {
        myPhone.needsCharging();
        myPhone.getFreeStorage(); //jak tą linię dodam test przejdzie, sopecjalnie bylo wczesniej zle
       Mockito.verify(myPhone).getFreeStorage();
    }
}