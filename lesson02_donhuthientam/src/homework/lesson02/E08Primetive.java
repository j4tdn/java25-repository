package homework.lesson02;

import java.util.Scanner;

public class E08Primetive {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		while(true) {
			System.out.println("Nhập N");
			String text = ip.nextLine();
			
			int count = 0;
			if (isvalid(text)) {
				int number = Integer.parseInt(text);
				System.out.println(isprime(number));
				break;
			} else {
				System.out.println("không phải là sô nguyên tố");
			}
			count++;
			if (count == 5) {
				System.out.println("số lần nhập quá 5 lần");
				ip.close();
			}
		}
		
		
	}
	
	private static boolean isprime (int val) {
		for (int i = 3; i <= Math.sqrt(val); i+=2) {
			if (val % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isvalid(String text) {
		for (int i = 0; i < text.length(); i++ ) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
		
	}

}
