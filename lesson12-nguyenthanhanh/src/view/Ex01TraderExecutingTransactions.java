package view;

import java.util.Arrays;
import java.util.List;

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
				.sorted((t1, t2) -> t1.getYear().compareTo(t2.getYear()))
				.toList();
		generate("1. All transaction in the year 2011", transactionsIn2011);
		
	}
	
}
