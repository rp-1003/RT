package account;

import java.util.List;

public class AccountService {
    public Statement produceStatement(Account account) {
        List<Transaction> transactions = account.getTransactions();
        double balance = transactions.stream().mapToDouble(Transaction::getAmount).sum();
        return new Statement(account, transactions, balance);
    }
}
