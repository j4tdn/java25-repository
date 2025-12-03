package view;

import java.util.Scanner;

public class Ex04TryMutipleCatches {

	// Nếu tồn tại exception có qh cha co
	// 		- Đặt exception con trước exception cha
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		try {
			System.out.print("Nhập tử số: ");
			int numerator = Integer.parseInt(ip.nextLine());
			
			System.out.print("Nhập mẫu số: ");
			int denominator = Integer.parseInt(ip.nextLine());
			
			int result = numerator/denominator;
		// Exception ko phải cha con thì đặt như thế này được
		} catch(NumberFormatException | ArithmeticException ex) {
			
		} 
		
		ip.close();
		
	}
	
}
