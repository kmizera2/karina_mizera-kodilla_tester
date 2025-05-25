package wallet.cash_withdrawal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import wallet.Cashier;
import wallet.Wallet;
import wallet.CashSlot;


public class WalletSteps {
    private Wallet wallet = new Wallet();
    private CashSlot cashSlot = new CashSlot();
    private Cashier cashier = new Cashier(cashSlot);
    private String message;

    @Given("I have deposited ${int} in my wallet")
    public void i_have_deposited_amount_in_my_wallet(int amount) {
        wallet.deposit(amount);
        assertEquals(amount, wallet.getBalance());
    }

    @When("I request ${int}")
    public void i_request_amount(int amount) {
        message = cashier.withdraw(wallet, amount);
    }

    @Then("the balance of my wallet should be ${int}")
    public void the_balance_of_my_wallet_should_be(int expectedBalance) {
        assertEquals(expectedBalance, wallet.getBalance());
    }

    @Then("${int} should be dispensed")
    public void should_be_dispensed(int expectedAmount) {
        assertEquals(expectedAmount, cashSlot.getContents());
    }

    @Then("I should be told that I have insufficient funds")
    public void i_should_be_told_that_i_have_insufficient_funds() {
        assertEquals("Insufficient funds", message);
    }

    @Then("I should be told that withdrawal amount must be greater than zero")
    public void i_should_be_told_that_amount_must_be_positive() {
        assertEquals("Withdrawal amount must be greater than zero", message);
    }
}