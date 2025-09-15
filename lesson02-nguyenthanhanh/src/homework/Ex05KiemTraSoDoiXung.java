package homework;

import java.util.Scanner;

public class Ex05KiemTraSoDoiXung {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		String text = null;
		int number = 0;
		int max = 0;
		while(true) {
			System.out.print("Nhập số có 2 chữ số n: ");
			text = ip.nextLine();
			if(Integer.parseInt(text) > 0 && hasTwoNumber(text)) {
				number = Integer.parseInt(text);
				break;
			}
			max++;
			if(max == 5) {
				System.out.println("Bạn đã hết số lần nhập");
				ip.close();
				return;
			}
		}
		
		if(isSymetricNumber(number)) {
			System.out.println(number + " là số đối xứng");
		} else {
			System.out.println(number + " không phải là số đối xứng");
		}
		
		ip.close();
		
	}
	
	private static boolean isSymetricNumber(int number) {
		int temp = number;
		int reversedNumber = 0;
		while(number != 0) {
			int modul = number % 10;
			reversedNumber = reversedNumber*10 + modul;
			number /= 10;
		}
		return reversedNumber == temp ? true : false;
	}
	
	private static boolean hasTwoNumber(String text) {
		return text.length() >= 2 ? true : false;
	}
	
}
