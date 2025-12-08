package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeYearProblem {

	// Đặt vấn đề
	// Bài toán: Nhập vào năm sinh của người dùng, in ra số tuối của người đó
	//         : Tuổi = Năm hiện tại - năm sinh + 1
	
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập năm sinh: ");
		
		// Dòng 19: Có khả năng xảy ra ngoại lệ(runtime)
		int yob = Integer.parseInt(ip.nextLine());
		
		int age = Year.now().getValue() - yob + 1;
		
		System.out.println("\n => Số tuổi = " + age);
		
		ip.close();

	}
}
/*
Exception in thread "main" java.lang.NumberFormatException: For input string: "14dd"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:662)
	at java.base/java.lang.Integer.parseInt(Integer.java:778)
	at view.Ex01AgeYearProblem.main(Ex01AgeYearProblem.java:19)

 * */
 