import java.util.*;
import java.util.stream.Collectors;

public class TraderTransactionApp {

    public static void main(String[] args) {

        DataModel.transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(t -> System.out.println("Transaction " + t.getId() + ": " + t.getValue()));

        DataModel.transactions.stream()
                .filter(t -> t.getValue() > 300)
                .sorted(Comparator.comparing(t -> t.getTrader().getCity()))
                .forEach(t -> System.out.println("Transaction " + t.getId() + ": " + t.getValue()));

        DataModel.traders.stream()
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        DataModel.traders.stream()
                .filter(t -> t.getCity().equals("cambridge"))
                .sorted(Comparator.comparing(Trader::getName).reversed())
                .forEach(t -> System.out.println(t.getName()));

        String allTraders = DataModel.traders.stream()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(allTraders);

        boolean anyTradersInMilan = DataModel.traders.stream()
                .anyMatch(t -> t.getCity().equals("milan"));
        System.out.println("Are there traders in Milan? " + anyTradersInMilan);

        long tradersInMilan = DataModel.traders.stream()
                .filter(t -> t.getCity().equals("milan"))
                .count();
        System.out.println("Number of traders in Milan: " + tradersInMilan);

        DataModel.transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        int highestTransactionValue = DataModel.transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .orElse(0);
        System.out.println("Highest transaction value: " + highestTransactionValue);

        int smallestTransactionValue = DataModel.transactions.stream()
                .mapToInt(Transaction::getValue)
                .min()
                .orElse(0);
        System.out.println("Smallest transaction value: " + smallestTransactionValue);
    }
}