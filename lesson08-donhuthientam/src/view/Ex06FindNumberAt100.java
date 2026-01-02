package view;

import java.util.Scanner;

public class Ex06FindNumberAt100 {
	
public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập vào một dãy số");
		String number = ip.nextLine();
		
		int pos = 100;
		
		if (pos <= 0 || pos > number.length()) {
			System.out.println("Vị trí sai");
		} else {
			char c = number.charAt(pos - 1);
			System.out.println("Vị trí thứ 100 là số: " + c);
		}
		
		
		ip.close();
		
	}

}
