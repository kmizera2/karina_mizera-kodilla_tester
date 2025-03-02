package com.kodilla.homework;

import com.kodilla.bank.homework.CashMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CashMashineTestSuite {
    private CashMachine cashMachine;

    @BeforeEach
    void setUp() {
        cashMachine = new CashMachine();
    }

    @Test
    void testInitialBalanceShouldBeZero() {
        assertEquals(0, cashMachine.checkBalance(), "Initial balance should be 0");
    }

    @Test
    void testInitialTransactionCountShouldBeZero() {
        assertEquals(0, cashMachine.countTransactions(), "Initial transaction count should be 0");
    }

    @Test
    void testAddingTransactionIncreasesCount() {
        cashMachine.addTransaction(100);
        assertEquals(1, cashMachine.countTransactions(), "Transaction count should be 1 after adding a transaction");
    }

    @Test
    void testAddingTransactionUpdatesBalance() {
        cashMachine.addTransaction(100);
        cashMachine.addTransaction(-50);
        assertEquals(50, cashMachine.checkBalance(), "Balance should be 50 after adding transactions");
    }

    @Test
    void testAddingZeroTransactionDoesNotChangeCount() {
        cashMachine.addTransaction(0);
        assertEquals(0, cashMachine.countTransactions(), "Transaction count should not change when adding zero");
    }
}
