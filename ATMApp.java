package atmAdvance1;
import java.math.BigDecimal;
import java.util.List;


public class ATMApp {
	public static void main(String[] args) {
        ATMService atm = new ATMService();

        Account acc1 = new Account("12345", "John Doe", BigDecimal.valueOf(1000));
        atm.addAccount(acc1);

        atm.processTransaction("12345", new Deposit(BigDecimal.valueOf(500)));
        atm.processTransaction("12345", new Withdraw(BigDecimal.valueOf(200)));
        atm.processTransaction("12345", new BalanceCheck());

        List<Transaction> transactions = List.of(
            new Deposit(BigDecimal.valueOf(1000)),
            new Withdraw(BigDecimal.valueOf(3000)),
            new Deposit(BigDecimal.valueOf(5000)),
            new Withdraw(BigDecimal.valueOf(100))
        );

        TransactionAnalytics.analyzeTransactions(transactions);
    }
}


