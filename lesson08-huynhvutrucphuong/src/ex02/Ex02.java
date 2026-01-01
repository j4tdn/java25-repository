package ex02;

import java.util.Scanner;
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().trim().toLowerCase();

        String[] words = name.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String w : words) {
            if (!w.isEmpty()) {
                result.append(Character.toUpperCase(w.charAt(0)))
                      .append(w.substring(1))
                      .append(" ");
            }
        }

        System.out.println(result.toString().trim());
	}
}
