import java.util.Arrays;
import java.util.List;

import bean.Trader;
import bean.Transaction;
import service.TransactionService;

public class Main {
	public static void main(String[] args) {

		// Tạo trader
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		// Tạo transaction
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Gọi service
		TransactionService service = new TransactionService();

		System.out.println("1: " + service.get2011Sorted(transactions));
		System.out.println("2: " + service.getValueGreater300SortedByCity(transactions));
		System.out.println("3: " + service.getUniqueCities(transactions));
		System.out.println("4: " + service.getCambridgeTradersDesc(transactions));
		System.out.println("5: " + service.getAllTraderNames(transactions));
		System.out.println("6: " + service.isAnyTraderInMilan(transactions));
		System.out.println("7: " + service.countTraderInMilan(transactions));
		System.out.println("8: " + service.getValuesFromCambridge(transactions));
		System.out.println("9: " + service.getMaxValue(transactions));
		System.out.println("10: " + service.getMinValue(transactions));
	}
}