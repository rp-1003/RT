package account;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String name;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public void deposit(String description, double amount) {
        transactions.add(new Transaction(description, amount));
    }

    public void withdraw(String description, double amount) {
        transactions.add(new Transaction(description, -amount));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }
}
