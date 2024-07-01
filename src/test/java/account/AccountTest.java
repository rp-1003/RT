// AccountTest.java
package account;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AccountTest {
    @Test
    void testDeposit() {
        Account account = new Account("12345678", "Test User");
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdraw() {
        Account account = new Account("12345678", "Test User");
        account.deposit(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testStatement() {
        Account account = new Account("12345678", "Test User");
        account.deposit("INIT", 200);
        account.deposit("DEP1", 100);
        account.deposit("DEP2", 450);
        account.deposit("DEP3", 50);
        account.withdraw("CHQ001", 675.55);
        String statement = account.getStatement();
        assertTrue(statement.contains("Name: Test User"));
        assertTrue(statement.contains("Account: 12345678"));
        assertTrue(statement.contains("Balance: 124.45"));
        assertTrue(statement.contains("INIT"));
        assertTrue(statement.contains("DEP1"));
        assertTrue(statement.contains("DEP2"));
        assertTrue(statement.contains("DEP3"));
        assertTrue(statement.contains("CHQ001"));
    }
}
