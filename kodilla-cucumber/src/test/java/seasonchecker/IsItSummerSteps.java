package seasonchecker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seasonchecker.SeasonChecker.checkIfSummer;

public class IsItSummerSteps {
    private MonthDay today;
    private String answer;
   // private SeasonChecker SasonChecker;



    @Given("today is last day of December")
    public void today_is_last_day_of_december() {
        this.today = MonthDay.of(12, 31);
    }

    @Given("today is second day of January")
    public void today_is_second_day_of_january() {
        this.today = MonthDay.of(1, 2);
    }

    @Given("today is 10th day of February")
    public void today_is_10th_day_of_february() {
        this.today = MonthDay.of(2, 10);
    }

    @Given("today is first day of August")
    public void today_is_first_day_of_august() {
        this.today = MonthDay.of(8, 1);
    }


    @Given("today is 23th day of August")
    public void today_is_23th_day_of_august() {
        this.today = MonthDay.of(8, 23);
    }

   /* @Given("today is last day of December")
    public void today_is_last_day_of_december2() {
        // Write code here that turns the phrase above into concrete actions
        this.today = MonthDay.of(12, 31);
       // throw new io.cucumber.java.PendingException();
    }*/
    @When("I ask whether it's Summer")
    public void i_ask_whether_it_s_summer() {
        // Write code here that turns the phrase above into concrete actions
       
        this.answer = checkIfSummer(this.today);
        //throw new io.cucumber.java.PendingException();
    }
    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        assertEquals(string, this.answer);
    }
}
