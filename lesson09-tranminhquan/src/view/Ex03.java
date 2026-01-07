package view;

import java.util.Scanner;

public class Ex03 {

	public static String revert(String s) {
		String[] words = s.trim().split("\\s+");
		StringBuilder result = new StringBuilder();
		
		for (String word : words ) {
			result.append(new StringBuilder(word).reverse().append(" "));
		}
		return result.toString().trim();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập chuỗi: ");
		String input = sc.nextLine();
		
		System.out.println(revert(input));
	}
}
