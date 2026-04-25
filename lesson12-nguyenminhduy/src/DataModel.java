import java.util.Arrays;
import java.util.List;

public class DataModel {
    public static List<Trader> traders = Arrays.asList(
            new Trader(1, "John", "Cambridge"),
            new Trader(2, "Paul", "Milan"),
            new Trader(3, "Mary", "Cambridge"),
            new Trader(4, "Emma", "Milan")
    );

    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(1, traders.get(0), "item1", 500, 2011),
            new Transaction(2, traders.get(1), "item2", 150, 2012),
            new Transaction(3, traders.get(2), "item3", 1000, 2011),
            new Transaction(4, traders.get(3), "item4", 250, 2013)
    );
}