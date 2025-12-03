package view;

import java.time.Year;
import java.util.Scanner;

public class Ex03AgeYearTryCatch {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập năm sinh: ");
		
		int yob = 0;
		
		do {
			try {
				yob = Integer.parseInt(ip.nextLine());
				break;
			} catch(ArithmeticException ex) {
				System.out.println("Năm sinh ko hợp lệ ==> " + ex.getMessage());
			}
		} while(true);
		
		int age = Year.now().getValue() - yob + 1;
		
		System.out.print("\n==> Số tuổi = " + age);
		
		ip.close();
		
	}
	
}
