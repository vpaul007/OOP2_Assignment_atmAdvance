package atmAdvance1;


	import java.math.BigDecimal;
	import java.util.*;
	import java.util.function.*;

	public class ATMService {
	    private final Map<String, Account> accounts = new HashMap<>();

	    // Consumer to display account details
	    private final Consumer<Account> displayAccount = account -> 
	        System.out.println("Hello :" + account.holderName() +  "\nAccount: " + account.accountNumber() + ",\nBalance: " + account.balance());

	    // Predicate to check sufficient balance
	    private final BiPredicate<Account, BigDecimal> hasSufficientBalance = 
	        (account, amount) -> account.balance().compareTo(amount) >= 0;

	    // Supplier to create a default account
	    private final Supplier<Account> defaultAccountSupplier = () -> 
	        new Account(UUID.randomUUID().toString(), "Default User", BigDecimal.ZERO);

	    // Function to withdraw money
	    private final BiFunction<Account, BigDecimal, Account> withdrawFunction = (account, amount) -> {
	        if (hasSufficientBalance.test(account, amount)) {
	            return new Account(account.accountNumber(), account.holderName(), account.balance().subtract(amount));
	        }
	        System.out.println("Insufficient Balance!");
	        return account;
	    };

	    public void addAccount(Account account) {
	        accounts.put(account.accountNumber(), account);
	    }

	   //Create Default Account
	   public Account createDefaultAccount() {

	         return defaultAccountSupplier.get();

		}

	    public void processTransaction(String accNumber, Transaction transaction) {
	        Account account = accounts.getOrDefault(accNumber, defaultAccountSupplier.get());

	        account = switch (transaction) {
	            case Deposit d -> new Account(account.accountNumber(), account.holderName(), account.balance().add(d.amount()));
	            case Withdraw w -> withdrawFunction.apply(account, w.amount());
	            case BalanceCheck()  -> {
	                displayAccount.accept(account);
	                yield account;
	            }
			default -> throw new IllegalArgumentException("Unexpected value: " + transaction);
	        };

	        accounts.put(accNumber, account);
	    }
	


}
