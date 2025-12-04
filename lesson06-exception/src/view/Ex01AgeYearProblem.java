package view;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

public class Ex01AgeYearProblem {
	
	// Đặt vấn đề
	// Bài toán: Nhập vào năm sinh của người dùng, in ra số tuổi của người đó
	//         : Tuổi = Năm hiện tại - Năm sinh + 1
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập năm sinh: ");
		
		// Dòng 19: Có khả năng xảy ra ngoại lệ
		int yob = Integer.parseInt(ip.nextLine());
		
		int age = Year.now().getValue() - yob + 1;
		
		System.out.println("\n==> Số tuổi = " + age);
		
		ip.close();
	}
	
	/*
	 Exception in thread "main" java.lang.NumberFormatException: For input string: "1abc"
		at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
		at java.base/java.lang.Integer.parseInt(Integer.java:668)
		at java.base/java.lang.Integer.parseInt(Integer.java:786)
		at view.Ex01AgeYearProblem.main(Ex01AgeYearProblem.java:18)
	 */
}
