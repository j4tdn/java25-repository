package view;

import java.util.Comparator;
import java.util.List;

import bean.Transaction;
import model.DataModel;

public class Ex01TraderExecutingTransactions {
	
	public static void main(String[] args) {
		List<Transaction> transactions = DataModel.mockTransactions();
		
		// 1.
		transactions.stream()
				.filter(t -> t.getYear() == 2011)
				.sorted((a,b) -> Integer.compare(a.getValue(), b.getValue()));
		
		//2. 
		transactions.stream()
				.filter(t -> t.getValue() > 300)
				.sorted((a,b) -> a.getTrader().getCity().compareTo(b.getTrader().getCity()));
		
		// 3.
		transactions.stream()
				.map(t -> t.getTrader().getCity())
				.distinct()
				.toList();
		
		// 4. 
		transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.sorted((a,b) -> a.getTrader().getName().compareTo(a.getTrader().getName()));
		
		// 5.
		
		transactions.stream()
				.map(t -> t.getTrader().getName())
				.sorted(Comparator.naturalOrder());
		
		// 6.
		transactions.stream()
				.anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		
		// 7.
		System.out.println(
				transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Milan"))
				.count()
		);
		
		// 8.
		System.out.println(
				transactions.stream()
					.filter(t -> t.getTrader().getCity().equals("Cambridge"))
					.map(t -> t.getValue())
					.toList()
		);
		
		// 9.
		System.out.println(
				transactions.stream()
					.map(t -> t.getValue())
					.reduce(Integer::max)
		);
		
		// 10.
		System.out.println(
				transactions.stream()
					.map(t -> t.getValue())
					.reduce(Integer::min)
		);
		
	}
	
	
}
