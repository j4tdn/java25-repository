package service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;

public class TransactionService {
//1
	public List<Transaction> get2011Sorted(List<Transaction> list) {
		return list.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue))
				.toList();
	}

//2
	public List<Transaction> getValueGreater300SortedByCity(List<Transaction> list) {
		return list.stream().filter(t -> t.getValue() > 300).sorted(Comparator.comparing(t -> t.getTrader().getCity()))
				.toList();
	}

//3
	public List<String> getUniqueCities(List<Transaction> list) {
		return list.stream().map(t -> t.getTrader().getCity()).distinct().toList();
	}

//4
	public List<Trader> getCambridgeTradersDesc(List<Transaction> list) {
		return list.stream().map(Transaction::getTrader).filter(t -> t.getCity().equals("Cambridge")).distinct()
				.sorted(Comparator.comparing(Trader::getName).reversed()).toList();
	}

//5
	public String getAllTraderNames(List<Transaction> list) {
		return list.stream().map(t -> t.getTrader().getName()).sorted().collect(Collectors.joining(", "));
	}

//6
	public boolean isAnyTraderInMilan(List<Transaction> list) {
		return list.stream().allMatch(t -> t.getTrader().getCity().equals("Milan"));
	}

//7
	public long countTraderInMilan(List<Transaction> list) {
		return list.stream().map(Transaction::getTrader).filter(t -> t.getCity().equals("Milan")).distinct().count();
	}

	public List<Integer> getValuesFromCambridge(List<Transaction> list) {
		return list.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue)
				.toList();
	}

	public int getMaxValue(List<Transaction> list) {
		return list.stream().mapToInt(Transaction::getValue).max().orElse(0);
	}

	public int getMinValue(List<Transaction> list) {
		return list.stream().mapToInt(Transaction::getValue).min().orElse(0);
	}
}