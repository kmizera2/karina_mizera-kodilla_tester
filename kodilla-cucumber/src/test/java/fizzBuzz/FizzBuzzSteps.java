package fizzBuzz;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static fizzBuzzGenerator.FizzBuzzDivision.checkIfFizzBuzz;

public class FizzBuzzSteps {

    private String result;
    private Integer input;

    @Given("a number {int}")
    public void a_number(Integer number) {
        this.input = number;
    }

    @When("I ask for the FizzBuzz result")
    public void i_ask_for_the_result() {
        this.result = checkIfFizzBuzz(this.input);
    }

    @Then("the result should be {string}")
    public void the_result_should_be(String expected) {
        assertEquals(expected, this.result);
    }
}
