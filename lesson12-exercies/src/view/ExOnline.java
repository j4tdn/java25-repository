package view;

import java.util.Comparator;
import java.util.List;

import bean.Trader;
import bean.Transaction;

import static utils.PrintUtils.*;

public class ExOnline {

	public static void main(String[] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = List.of(
		    new Transaction(brian, 2011, 300),
		    new Transaction(raoul, 2012, 1000),
		    new Transaction(raoul, 2011, 400),
		    new Transaction(mario, 2012, 710),
		    new Transaction(mario, 2012, 700),
		    new Transaction(alan, 2012, 950)
		);
		
		// 1. Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> transactions2011 = transactions.stream()
					.filter(t -> t.getYear() == 2011)
					.sorted(Comparator.comparing(Transaction::getValue))
					.toList();
		generate("1. Find all transactions in the year 2011 and sort them by value (small to high)", transactions2011);
		
		// 2. Find all transactions have value greater than 300 and sort them by trader’s city
		List<Transaction> transactionsGreater300 = transactions.stream()
				.filter(t -> t.getValue() > 300)
				.sorted(Comparator.comparing(t -> t.getTrader().getCity()))
				.toList();
		generate("2. Find all transactions have value greater than 300 and sort them by trader’s city", transactionsGreater300);
		
		// 3. What are all the unique cities where the traders work ?
		List<String> cities = transactions.stream()
				.map(t -> t.getTrader().getCity())
				.distinct()
				.toList();
		generate("3. What are all the unique cities where the traders work ?", cities);
		
		// 4. Find all traders from Cambridge and sort them by name desc.
		List<Trader> traders = transactions.stream()
				.map(Transaction::getTrader)
				.filter(t -> t.getCity().equals("Cambridge"))
				.sorted(Comparator.comparing(Trader::getName).reversed())
				.toList();
		generate("4. Find all traders from Cambridge and sort them by name desc", traders);
		
		// 5. Return a string of all traders’ names sorted alphabetically.
		List<String> tradersName = transactions.stream()
				.map(t -> t.getTrader().getName())
				.distinct()
				.toList();
		generate("5. Return a string of all traders’ names sorted alphabetically.", tradersName);
		
		// 6. Are any traders based in Milan ?
		boolean traderMilan = transactions.stream()
			    .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println("6. Are any traders based in Milan ? --> " + traderMilan);
	}
	
}
