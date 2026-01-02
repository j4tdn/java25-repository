package exercise;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        String s = sc.nextLine().trim().toLowerCase();

        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String w : words) {
            result.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1))
                  .append(" ");
        }

        System.out.println("Kết quả: " + result.toString().trim());
    }
}

