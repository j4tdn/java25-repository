package view;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Input: ");
		int n = sc.nextInt();
		
		isHappyNumber(n);
		
		sc.close();
	}

	private static void isHappyNumber(int n) {
		int condition1 = n;
		int condition2 = happyNumber(n);
		while(condition2 != 1 && condition1 != condition2) {
			condition1 = happyNumber(condition1);
			condition2 = happyNumber(happyNumber(condition2));
		}
		
		if(condition2 == 1) {
			System.out.println(n + " is happy number");
		}
		else System.out.println(n + " is not a happy number");;
	}
	
	private static int happyNumber(int n) {
		int total = 0;
		while(n > 0) {
			int digit = n % 10;
			n = n / 10;
			total += digit * digit;
		}
		return total;
	}
	
}
