package model;

import java.util.List;

import bean.Trader;
import bean.Transaction;

public class DataModel {
	 private DataModel() {
	    }

	    public static List<Trader> mockTraderList() {
	        return List.of(
	            new Trader(1, "Raoul", "Cambridge"),
	            new Trader(2, "Mario", "Milan"),
	            new Trader(3, "Alan", "Cambridge"),
	            new Trader(4, "Brian", "Cambridge")
	        );
	    }

	    public static List<Transaction> mockTransactionList() {
	        Trader raoul = new Trader(1, "Raoul", "Cambridge");
	        Trader mario = new Trader(2, "Mario", "Milan");
	        Trader alan = new Trader(3, "Alan", "Cambridge");
	        Trader brian = new Trader(4, "Brian", "Cambridge");

	        return List.of(
	            new Transaction(1, brian, 2011, 300),
	            new Transaction(2, raoul, 2012, 1000),
	            new Transaction(3, raoul, 2011, 400),
	            new Transaction(4, mario, 2012, 710),
	            new Transaction(5, mario, 2012, 700),
	            new Transaction(6, alan, 2012, 950)
	        );
	    }
}
