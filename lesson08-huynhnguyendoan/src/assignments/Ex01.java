package assignments;

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        System.out.println("\n--- Mỗi ký tự trên một dòng ---");
        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i));
        }

        System.out.println("\n--- Mỗi từ trên một dòng ---");
        String[] words = input.trim().split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }

        System.out.println("\n--- Chuỗi đảo ngược theo ký tự ---");
        String reverseChar = new StringBuilder(input).reverse().toString();
        System.out.println(reverseChar);

        System.out.println("\n--- Chuỗi đảo ngược theo từ ---");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }

        sc.close();
    }
}
