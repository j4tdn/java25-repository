package view;

import java.util.Scanner;

public class Ex01PrintString {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập vào một chuỗi kí tự bất kì: ");
		String s = ip.nextLine();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			System.out.print(c + " ");
		}

		System.out.println("\n\n========================\n");
		String[] words = s.split(" ");
		for (String word : words) {
			System.out.println(word);
		}
		System.out.println("\n========================\n");
		int x = s.length() - 1;
		for (int i = x; i >= 0; i--) {
			char c1 = s.charAt(i);
			System.out.print(c1 + " ");
		}

		System.out.println("\n\n========================\n");
		String[] word1 = s.split(" ");
		StringBuilder text = new StringBuilder();
		for (int i = word1.length - 1; i >= 0; i--) {
			text.append(word1[i] + " ");

		}
		System.out.println(text);
		
		ip.close();

	}

}
