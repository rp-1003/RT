java
Copy code
package steps;

import account.Account;
import account.AccountService;
import account.Statement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountSteps {

    private Account account;
    private Statement statement;
    private AccountService accountService = new AccountService();

    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void accountExistsForAccNoWithName(String accountNumber, String name) {
        account = new Account(accountNumber, name);
    }

    @And("deposits are made")
    public void depositsAreMade(DataTable dataTable) {
        List<Map<String, String>> deposits = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> deposit : deposits) {
            String description = deposit.get("description");
            double amount = Double.parseDouble(deposit.get("amount"));
            account.deposit(description, amount);
        }
    }

    @And("withdrawals are made")
    public void withdrawalsAreMade(DataTable dataTable) {
        List<Map<String, String>> withdrawals = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> withdrawal : withdrawals) {
            String description = withdrawal.get("description");
            double amount = Double.parseDouble(withdrawal.get("amount"));
            account.withdraw(description, amount);
        }
    }

    @When("statement is produced")
    public void statementIsProduced() {
        statement = accountService.produceStatement(account);
    }

    @Then("statement includes {string}")
    public void statementIncludes(String content) {
        Assert.assertTrue(statement.toString().contains(content));
    }

    @Then("statement includes {string} and {string}")
    public void statementIncludes(String content1, String content2) {
        Assert.assertTrue(statement.toString().contains(content1));
        Assert.assertTrue(statement.toString().contains(content2));
    }

    @After
    public void tearDown() {
        account = null;
        statement = null;
    }
}

