package exercise;

import java.util.Scanner;

public class Ex02PowerOf2 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String text;
		int wrongTimes = 0;
		
		do {
			System.out.println("Nhap vao 1 so nguyen");
			text = ip.nextLine();
			if(isValid(text)) {
				break;
			}
			if(++wrongTimes == 6) {
				System.out.println("Nhap sai qua 5 lan, cookkkkkk");
				ip.close();
				return;
			}
			System.out.println("Chua hop le");
		} while(true);
		
		int number = Integer.parseInt(text);
		
		if(isPowOf2(number)) {
			 System.out.println(number + " la luy thua cua 2");
		}
		else  System.out.println(number + " khong phai la luy thua cua 2");
		
		ip.close();
	}
	
	public static boolean isValid(String text) {
		for(int i = 0; i < text.length(); i++) {
			if(!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPowOf2(int number) {
		if(number == 0) {
			System.out.println("Khong phai luy thua cua 2");
			return false;
		}
		while(number % 2 ==0) {
			number /= 2;
		}
		if(number == 1) {
			 return true;
		}
		else {
			 return false;
		}
	}
	
}
