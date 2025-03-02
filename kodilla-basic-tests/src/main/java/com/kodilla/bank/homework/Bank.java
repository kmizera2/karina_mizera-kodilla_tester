package com.kodilla.bank.homework;

public class Bank {

    public CashMachine[] cashMachines;

    public Bank(int size) {
        this.cashMachines = new CashMachine[size];
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (int i = 0; i < cashMachines.length; i++) {
            totalBalance += cashMachines[i].checkBalance();
        }
        return totalBalance;
    }


    public int getDepositsCount() {
        int depositsCounter = 0;
        for (int i = 0; i < cashMachines.length; i++) {
            for (int j = 0; j < cashMachines[i].transactions.length; j++) {
                if (cashMachines[i].transactions[j] > 0)
                    depositsCounter++;
            }
        }
        return depositsCounter;
    }

    public int getWithdrawalCount() {
        int withdrawalCounter = 0;
        for (int i = 0; i < cashMachines.length; i++) {
            for (int j = 0; j < cashMachines[i].transactions.length; j++) {
                if (cashMachines[i].transactions[j] < 0)
                    withdrawalCounter++;
            }
        }
        return withdrawalCounter;
    }


    public double getDepositsAverage() {
        double totalDeposits = 0;
        for (int i = 0; i < cashMachines.length; i++) {
            for (int j = 0; j < cashMachines[i].transactions.length; j++) {
                if (cashMachines[i].transactions[j] > 0)
                    totalDeposits += cashMachines[i].transactions[j];
            }
        }
        return totalDeposits / getDepositsCount();
    }

    public double getWithdrawalAverage() {
        double totalWithdrawal = 0;
        for (int i = 0; i < cashMachines.length; i++) {
            for (int j = 0; j < cashMachines[i].transactions.length; j++) {
                if (cashMachines[i].transactions[j] < 0)
                    totalWithdrawal += cashMachines[i].transactions[j];
            }
        }
        return totalWithdrawal / getWithdrawalCount();
    }
}

