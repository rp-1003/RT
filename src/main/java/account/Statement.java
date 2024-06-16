package account;

import java.util.List;

public class Statement {
    private Account account;
    private List<Transaction> transactions;
    private double balance;

    public Statement(Account account, List<Transaction> transactions, double balance) {
        this.account = account;
        this.transactions = transactions;
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(account.getName()).append("\n");
        sb.append("Account: ").append(account.getAccountNumber()).append("\n");
        sb.append("Transactions:\n");
        for (Transaction t : transactions) {
            sb.append(t.getDescription()).append(": ").append(t.getAmount()).append("\n");
        }
        sb.append("Balance: ").append(balance).append("\n");
        return sb.toString();
    }
}
