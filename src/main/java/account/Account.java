package account;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String name;
    private List<Transaction> transactions;

    public Account(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public void deposit(String description, double amount) {
        transactions.add(new Transaction(description, amount));
    }

    public void withdraw(String description, double amount) {
        transactions.add(new Transaction(description, -amount));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

   	
	public List<Transaction> getTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName1() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
