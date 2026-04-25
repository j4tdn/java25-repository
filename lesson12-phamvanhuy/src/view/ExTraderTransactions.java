package view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;
import model.DataModel;

public class ExTraderTransactions {

    public static void main(String[] args) {

        List<Transaction> transactions = DataModel.mockTransactionList();

        System.out.println("1. Giao dịch năm 2011 sắp xếp tăng dần theo value:");
        transactions.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .forEach(System.out::println);

        System.out.println("\n2. Giao dịch có value > 300 sắp xếp theo city:");
        transactions.stream()
            .filter(t -> t.getValue() > 300)
            .sorted(Comparator.comparing(t -> t.getTrader().getCity()))
            .forEach(System.out::println);

        System.out.println("\n3. Các city duy nhất:");
        transactions.stream()
            .map(t -> t.getTrader().getCity())
            .distinct()
            .forEach(System.out::println);

        System.out.println("\n4. Trader ở Cambridge sắp xếp tên giảm dần:");
        transactions.stream()
            .map(Transaction::getTrader)
            .filter(t -> t.getCity().equals("Cambridge"))
            .distinct()
            .sorted(Comparator.comparing(Trader::getName).reversed())
            .forEach(System.out::println);

        String names = transactions.stream()
            .map(t -> t.getTrader().getName())
            .distinct()
            .sorted()
            .collect(Collectors.joining(", "));
        System.out.println("\n5. Chuỗi tên trader sắp xếp alphabet:");
        System.out.println(names);

        boolean hasMilan = transactions.stream()
            .map(Transaction::getTrader)
            .anyMatch(t -> t.getCity().equals("Milan"));
        System.out.println("\n6. Có trader nào ở Milan không: " + hasMilan);

        long countMilan = transactions.stream()
            .map(Transaction::getTrader)
            .distinct()
            .filter(t -> t.getCity().equals("Milan"))
            .count();
        System.out.println("7. Số trader ở Milan: " + countMilan);

        System.out.println("\n8. Value của giao dịch từ trader ở Cambridge:");
        transactions.stream()
            .filter(t -> t.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue)
            .forEach(System.out::println);

    }
}