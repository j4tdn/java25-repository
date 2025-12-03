package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeYearProblem {

	// Đặt vấn đề
	// Bài toán: Nhập vào năm sinh của người dùng, in ra số tuổi của người đó
	//		   : Tuổi = Năm hiện tại - Năm sinh + 1
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập năm sinh: ");
		
		String text = "";
		do {
			text = ip.nextLine();
			if(text.matches("\\d+")) {
				break;
			}
			System.out.print("Năm sinh ko hợp lệ, nhập lại: ");
		} while(true);
		
		int yob = Integer.parseInt(text);
		
		int age = Year.now().getValue() - yob + 1;
		
		System.out.println("\n==> Số tuổi = " + age);
		
		ip.close();
		
	}
	
}
