package com.kodilla.bank.homework;

public class CashMachine {

    public double[] transactions;
    private int size;
    private double balance =0;

    public CashMachine() {
        this.size = 0;
        this.transactions = new double[0];
    }

    public void addTransaction(int value) {
        if (value !=0) {
            this.size++;
            double[] newTab = new double[this.size];
            System.arraycopy(transactions, 0, newTab, 0, transactions.length);
            newTab[this.size - 1] = value;
            this.transactions = newTab;
        }
        else System.out.println("Wykonanie operacji na wybraną kwotę jest niemożliwe");
    }


    public double checkBalance() {
        for (int i = 0; i < transactions.length; i++) {
            balance += transactions[i];
        }
        return balance;
    }

    public int countTransactions (){
        return transactions.length;
    }
}
