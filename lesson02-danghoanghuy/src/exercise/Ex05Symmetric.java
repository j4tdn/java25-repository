package exercise;

import java.util.Scanner;

public class Ex05Symmetric {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String text;
		
		do {
			System.out.println("Nhap so nguyen toi thieu 2 chu so");
			text = ip.nextLine();
			if(isValid(text)) {
				break;
			}
			System.out.println("Chua hop le");
		}
		while(true);
		int number = Integer.parseInt(text);
		
		if(isSym(number)) {
			System.out.println(number + " la so doi xung");
		}
		else System.out.println(number + " khong phai la so doi xung");
		
		ip.close();
	}
	
	private static boolean isValid(String text) {
		if(text.length() < 2) 
			return false;
		
		for(int i = 0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isSym(int number) {
		int number1 = number;
		int number2 = 0;
		
		while(number1 !=0) {
			number2 = number2 * 10 + number1 % 10;
			number1 /= 10;
		}
		return number == number2;
	}
	
}
