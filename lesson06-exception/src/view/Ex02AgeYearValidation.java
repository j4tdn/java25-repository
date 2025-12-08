package view;

import java.time.Year;
import java.util.Scanner;

public class Ex02AgeYearValidation {
	// Đặt vấn đề 
		// Bài toán :Nhập vào năm sinh cỉa người dùng in ra só tuỏi của ngừi đó 
		//   : Tuổi = năm hiện tại - năm sinh +1
			public static void main(String[] args) {
				Scanner ip = new Scanner(System.in);
				System.out.println("Nhập năm sinh: ");
				
				// Dòng ** :Có khả năng xảy ra ngoại lệ 
				// Cách 1: Sử dụng validation đảm bảo dòng cod bên dứoi không xảy a ngoại lẹ 
				
				String text ="";
		
				do {
					text = ip.nextLine();
					if(text.matches("\\d+")) {
						break;
					}
				System.out.println("Năm sinh không hợp lệ, vui lòng nhập lại  ");
				}while(true);
				
				int yob = Integer.parseInt(text);
				int age = Year.now().getValue() - yob+1;
				System.out.println("\n ==> số tuổi = "+age);
				ip.close();
			}
}
