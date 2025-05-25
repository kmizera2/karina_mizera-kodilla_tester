package wallet;

public class Cashier {
    private final CashSlot cashSlot;
    private String message;

    public Cashier(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public String withdraw(Wallet wallet, int amount) {
        if (amount <= 0) {
            cashSlot.dispense(0);
            return "Withdrawal amount must be greater than zero";
        }
        if (wallet.getBalance() < amount) {
            cashSlot.dispense(0);
            return "Insufficient funds";
        }
        wallet.debit(amount);
        cashSlot.dispense(amount);
        return "Withdrawal successful";
    }
}

