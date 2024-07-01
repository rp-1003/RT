// Account.java
package account;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private Map<String, Double> transactions;

    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0;
        this.transactions = new HashMap<>();
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void deposit(String transactionId, double amount) {
        transactions.put(transactionId, amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void withdraw(String transactionId, double amount) {
        transactions.put(transactionId, -amount);
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("Name: ").append(accountHolder).append("\n");
        statement.append("Account: ").append(accountNumber).append("\n");
        statement.append("Balance: ").append(balance).append("\n");
        for (String transactionId : transactions.keySet()) {
            statement.append(transactionId).append(": ").append(transactions.get(transactionId)).append("\n");
        }
        return statement.toString();
    }
}
