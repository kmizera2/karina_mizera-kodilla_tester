package wallet;

public class Wallet {

    private int balance = 0;

    public Wallet () {

    }

    public void deposit (int money) {
        this.balance += money;
    }

    public void debit(int amount) {
        balance -= amount;
    }
    public int getBalance () {
        return balance;
    }
}
