package exercise;

import java.util.Scanner;

public class Ex08PrimeNumber {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String text;
		int wrongTimes = 0;
		
		do {
			System.out.println("Nhap so");
			text = ip.nextLine();
			if(isValid(text)) {
				 break;
			}
			if(++wrongTimes == 6) {
				System.out.println("Nhap sai qua 5 lan oi");
				ip.close();
				return;
			}
			System.out.println("Chua hop le");
		}
		while(true);
		
		int number = Integer.parseInt(text);
		isPrime(number);
		
		ip.close();
	}
	
	private static boolean isValid(String text) {
		for(int i = 0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	private static int isPrime(int number) {
		if(number < 2) {
			System.out.println(number + " khong phai la so nguyen to");
			return number;
		}
		for(int i = 2; i < number; i++) {
			if(number % i == 0) {
				System.out.println(number + " khong phai la so nguyen to");
				return number;
			}
		}
		System.out.println(number + " la so nguyen to");
		return number;
	}
	
}
