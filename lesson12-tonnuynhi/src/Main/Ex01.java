package Main;

import bean.Trader;
import bean.Transaction;
import java.util.*;
import java.util.stream.Collectors;

public class Ex01 {
    public static void main(String[] args) {
        Trader nhat = new Trader(1, "Nhat", "Ho Chi Minh");
        Trader nhi = new Trader(2, "Nhi", "Hue");
        Trader hoang = new Trader(3, "Hoang", "Ha Noi");
        Trader minh = new Trader(4, "Minh", "Dien Bien Phu");
        Trader khanh = new Trader(5, "Khanh", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(1, nhat, 2011, 400),
            new Transaction(2, nhi, 2011, 300),
            new Transaction(3, hoang, 2012, 1000),
            new Transaction(4, minh, 2011, 500),
            new Transaction(5, khanh, 2024, 700),
            new Transaction(6, nhi, 2012, 950)
        );

        System.out.println("--- KET QUA BAI TAP LESSON 12 ---");

        // 1. Giao dich nam 2011, sap xep gia tri tang dan
        System.out.println("1. Giao dich 2011 (tang dan):");
        transactions.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .forEach(System.out::println);

        // 2. Gia tri > 300, sap xep theo thanh pho cua trader
        System.out.println("\n2. Giao dich > 300 (theo thanh pho):");
        transactions.stream()
            .filter(t -> t.getValue() > 300)
            .sorted(Comparator.comparing(t -> t.getTrader().getCity()))
            .forEach(System.out::println);

        // 3. Cac thanh pho duy nhat
        List<String> cities = transactions.stream()
            .map(t -> t.getTrader().getCity())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("\n3. Cac thanh pho: " + cities);

        // 4. Traders tu Cambridge, sap xep ten Z-A
        System.out.println("\n4. Traders o Cambridge (Z-A):");
        transactions.stream()
            .map(Transaction::getTrader)
            .filter(t -> t.getCity().equals("Cambridge"))
            .distinct()
            .sorted(Comparator.comparing(Trader::getName).reversed())
            .forEach(System.out::println);

        // 5. Chuoi ten tat ca traders (A-Z)
        String allNames = transactions.stream()
            .map(t -> t.getTrader().getName())
            .distinct()
            .sorted()
            .collect(Collectors.joining(", "));
        System.out.println("\n5. Danh sach ten: " + allNames);

        // 6. Co ai o Milan khong?
        boolean hasMilan = transactions.stream()
            .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("\n6. Co trader o Milan: " + hasMilan);

        // 7. So luong trader tai Milan
        long milanCount = transactions.stream()
            .map(Transaction::getTrader)
            .distinct()
            .filter(t -> t.getCity().equals("Milan"))
            .count();
        System.out.println("7. So luong o Milan: " + milanCount);

        // 8. Gia tri giao dich cua nhung nguoi o Cambridge
        System.out.print("\n8. Gia tri giao dich tai Cambridge: ");
        transactions.stream()
            .filter(t -> t.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue)
            .forEach(v -> System.out.print(v + " "));

        // 9. Gia tri cao nhat
        transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::max)
            .ifPresent(max -> System.out.println("\n\n9. Gia tri cao nhat: " + max));

        // 10. Giao dich co gia tri nho nhat
        transactions.stream()
            .min(Comparator.comparing(Transaction::getValue))
            .ifPresent(min -> System.out.println("10. Giao dich thap nhat: " + min));
    }
}