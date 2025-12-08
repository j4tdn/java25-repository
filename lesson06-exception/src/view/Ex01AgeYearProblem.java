package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeYearProblem {
	// Đặt vấn đề 
	// Bài toán :Nhập vào năm sinh cỉa người dùng in ra só tuỏi của ngừi đó 
	//   : Tuổi = năm hiện tại - năm sinh +1
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhập năm sinh: ");
		int yob = Integer.parseInt(ip.nextLine());
		int age = Year.now().getValue() - yob+1;
		System.out.println("\n ==> số tuổi = "+age);
		ip.close();
		}

}
