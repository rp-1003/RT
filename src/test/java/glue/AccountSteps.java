// glue/AccountSteps.java
package glue;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.SoftAssertions;

import account.Account;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps {
    private Account account;
    private SoftAssertions softly = new SoftAssertions();
    private String statement;

    @Given("Account exists for Acc No. {string} with Name {string}")
    public void accountExists(String accNo, String name) {
        account = new Account(accNo, name);
    }

    @Given("deposits are made")
    public void depositsAreMade(List<Map<String, String>> deposits) {
        for (Map<String, String> deposit : deposits) {
            String transactionId = deposit.get("transactionId");
            double amount = Double.parseDouble(deposit.get("amount"));
            account.deposit(transactionId, amount);
        }
    }

    @Given("withdrawals are made")
    public void withdrawalsAreMade(List<Map<String, String>> withdrawals) {
        for (Map<String, String> withdrawal : withdrawals) {
            String transactionId = withdrawal.get("transactionId");
            double amount = Double.parseDouble(withdrawal.get("amount"));
            account.withdraw(transactionId, amount);
        }
    }

    @When("statement is produced")
    public void statementIsProduced() {
        statement = account.getStatement();
    }

    @Then("statement includes {string}")
    public void statementIncludes(String expectedContent) {
        softly.assertThat(statement).contains(expectedContent);
    }
    
    @Then("soft assertions are finished")
    public void assertAll() {
        softly.assertAll();
    }
}
