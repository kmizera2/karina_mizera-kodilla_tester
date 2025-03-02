package com.kodilla.bank.homework;

import com.kodilla.bank.homework.Bank;
import com.kodilla.bank.homework.CashMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTestSuite {

    private Bank bank;
    private CashMachine cashMachine1;
    private CashMachine cashMachine2;

    @BeforeEach
    void setUp() {
        bank = new Bank(2);
        cashMachine1 = new CashMachine();
        cashMachine2 = new CashMachine();

        cashMachine1.addTransaction(200);
        cashMachine1.addTransaction(-100);
        cashMachine1.addTransaction(50);

        cashMachine2.addTransaction(300);
        cashMachine2.addTransaction(-200);
        cashMachine2.addTransaction(100);

        bank.cashMachines[0] = cashMachine1;
        bank.cashMachines[1] = cashMachine2;
    }

    @Test
    void testGetTotalBalance() {
        assertEquals(350, bank.getTotalBalance(), 0.01);
    }

    @Test
    void testGetDepositsCount() {
        assertEquals(4, bank.getDepositsCount());
    }

    @Test
    void testGetWithdrawalCount() {
        assertEquals(2, bank.getWithdrawalCount());
    }

    @Test
    void testGetDepositsAverage() {
        assertEquals(162.5, bank.getDepositsAverage(), 0.01);
    }

    @Test
    void testGetWithdrawalAverage() {
        assertEquals(-150, bank.getWithdrawalAverage(), 0.01);
    }
}
