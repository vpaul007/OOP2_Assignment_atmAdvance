package atmAdvance1;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionAnalytics {
	 public static void analyzeTransactions(List<Transaction> transactions) {
	        // Count transactions
	        long count = transactions.stream().count();
	        System.out.println("\n -------ATM Transactions-------\nTotal Transactions in ATM: " + count);

	        // Find the max deposit
	        transactions.stream()
	            .filter(t -> t instanceof Deposit)
	            .map(t -> ((Deposit) t).amount())
	            .max(Comparator.naturalOrder())
	            .ifPresent(max -> System.out.println("Max Deposit in ATM: " + max));

	        // Find if any withdrawal exceeds 5000
	        boolean anyLargeWithdrawal = transactions.stream()
	            .anyMatch(t -> t instanceof Withdraw && ((Withdraw) t).amount().compareTo(BigDecimal.valueOf(5000)) > 0);
	        System.out.println("Any large withdrawal? " + anyLargeWithdrawal);

	        // Group transactions by type
	        Map<Class<? extends Transaction>, List<Transaction>> groupedTransactions = transactions.stream()
	            .collect(Collectors.groupingBy(Transaction::getClass));

	     System.out.println("\n--- Grouped Transactions --- ");
			groupedTransactions.forEach((type, txns) -> {
				System.out.println("\n" + type.getSimpleName() + "Transactions:");
				txns.forEach(System.out::println);
			});
	    }
	}


