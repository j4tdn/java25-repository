package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;

import static utils.PrintUtils.*;

public class Ex01TraderExecutingTransactions {

	public static void main(String[] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
			    new Transaction(raoul, 2012, 1000),
			    new Transaction(raoul, 2011, 400),
			    new Transaction(mario, 2012, 710),
			    new Transaction(mario, 2012, 700),
			    new Transaction(alan, 2012, 950)
		);
		
		// 1. Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> transactionsIn2011 = transactions.stream()
				.filter(t -> t.getYear() == 2011)
				.sorted((t1, t2) -> t1.getValue().compareTo(t2.getValue()))
				.toList();
		generate("1. All transaction in the year 2011", transactionsIn2011);
		
		// 2. Find all transactions have value greater than 300 and sort them by trader’s city
		List<Transaction> greaterThan300Transactions = transactions.stream()
				.filter(t -> t.getValue() > 300)
				.sorted((t1, t2) -> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
				.toList();
		generate("2. All transaction have value greater than 300", greaterThan300Transactions);
		
		// 3. What are all the unique cities where the traders work?
		List<String> uniqueCities = transactions.stream()
			.map(t -> t.getTrader().getCity())
			.distinct()
			.toList();
		generate("3. All unique cities", uniqueCities);
		
		// 4. Find all traders from Cambridge and sort them by name desc.
		List<Trader> cambridgeTrader = transactions.stream()
			.filter(t -> t.getTrader().getCity().equals("Cambridge"))
			.sorted((a,b) -> a.getTrader().getName().compareTo(a.getTrader().getName()))
			.map(t -> t.getTrader())
			.toList();
		generate("4. All traders from Cambridge", cambridgeTrader);
		
		// 5. Return a string of all traders’ names sorted alphabetically.
		String tradersName = transactions.stream()
				.map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
		System.out.println("5. all traders’ names: " + tradersName);
		
		// 6. Are any traders based in Milan ?
		boolean anyTraderInMilan = transactions.stream()
			.anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println("6. " + anyTraderInMilan);
		
		// 7. Count the number of traders in Milan.
		long countOfMilanTrader = transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Milan"))
				.count();
		System.out.println("7. " + countOfMilanTrader);
		
		// 8. Print all transactions’ values from the traders living in Cambridge.
		List<Integer> valueOfCambridgeTrader = transactions.stream()
			.filter(t -> t.getTrader().getCity().equals("Cambridge"))
			.map(t -> t.getValue())
			.toList();
		generate("8. All transactions’ values from the traders living in Cambridge", 
				valueOfCambridgeTrader);
		
		// 9. What’s the highest value of all the transactions ?
		transactions.stream()
			.reduce((max, cur) -> max.getValue().compareTo(cur.getValue()) < 0 ? cur : max)
			.ifPresent(val -> System.out.println(val.getValue()));
			
		// 10. Find the transaction with the smallest value.
		transactions.stream()
		.reduce((max, cur) -> max.getValue().compareTo(cur.getValue()) > 0 ? cur : max)
		.ifPresent(val -> System.out.println(val.getValue()));
		
		
	}
	
}
