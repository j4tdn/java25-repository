package view.stream.demo;

import static java.util.Comparator.comparing;
import static utils.NumberUtils.bd;
import static utils.PrintUtils.generate;

import java.time.temporal.ChronoField;
import java.util.List;
import java.util.function.Function;

import bean.Trader;
import bean.Transaction;
import model.DataModel;

public class Ex07TransactionDemo {
	
	public static void main(String[] args) {
		List<Transaction> transactions = DataModel.mockTransactionList();
		generate("0. Original Data", transactions);
		
		generate(
			"1. Find all transactions in the year 2026 and sort them by value (small to high).", 
			transactions.stream()
				.filter(t -> t.getDateCreated().get(ChronoField.YEAR) == 2026)
				.sorted(comparing(Transaction::getValue))
				.toList()
		);
		
		// >>Transaction t -> t.getTrader()<< ==> Transaction::getTrader
		// >>Transaction t -> t.getTrader().getCity()<< ==> Transaction::getTrader::getCity xxx
		
		generate(
			"2. Find all transactions have value greater than 3000 and sort them by trader’s city.", 
			transactions.stream()
				.filter(t -> t.getValue().compareTo(bd("3000")) > 0)
				.sorted(comparing(t -> t.getTrader().getCity()))
				.toList()
		);
		
		// 3. What are all the unique cities where the traders work ?
		
		// 4. Find all traders from Cambridge and sort them by name desc.
		
		// 5. Return a string of all traders’ names sorted alphabetically.
		
		// 6. Are any traders based in Milan ?
		
		// 7. Count the number of traders in Milan.
		
		// 8. Print all transactions’ values from the traders living in Cambridge.
		
		// 9. What’s the highest value of all the transactions ?
		
		// 10. Find the transaction with the smallest value.
	}
	
}