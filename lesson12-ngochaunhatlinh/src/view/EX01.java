package view;

import bean.Trader;
import bean.Transaction;
import model.DataModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static utils.PrintUtils.*;

public class EX01 {
    public static void main(String[] args) {
        List<Transaction> menu = DataModel.mockTransactionList();

        generate("Danh sach ban dau", menu);

        // 1. Find all transactions in the year 2011 and sort them by value (small to high)
        List<Transaction> cau1 = menu.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        generate("Cau 1", cau1);

        // 2. Find all transactions have value greater than 300 and sort them by trader’s city
        List<Transaction> cau2 = menu.stream()
                .filter(t -> t.getValue() >300)
                .sorted(Comparator.comparing(t -> t.getTrader().getCity()))
                .collect(Collectors.toList());
        generate("Cau 2", cau2);

        //3. What are all the unique cities where the traders work?
        List<String> cau3 = menu.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        generate("Cau 3", cau3);
        
        //4. Find all traders from Cambridge and sort them by name desc.
        List<Trader> cau4 = menu.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName).reversed())
                .collect(Collectors.toList());
        generate("Cau 4", cau4);
        
        //5. Return a string of all traders' names sorted alphabetically.
        String cau5 = menu.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        generate("Cau 5", cau5);
        
        //6.Are any traders based in Milan ?
        boolean cau6 = menu.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        generate("Cau 6", cau6);
        
        //7.Count the number of traders in Milan.
        long cau7 = menu.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t -> t.getCity().equals("Milan"))
                .count();
        generate("Cau 7", cau7);
        
        //8.Print all transactions' values from the traders living in Cambridge.
        List<Integer> cau8 = menu.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(Collectors.toList());
        generate("Cau 8", cau8);
        
        
        //9. What's the highest value of all the transactions ?
        
        
        //10.Find the transaction with the smallest value.
        

    }
}
