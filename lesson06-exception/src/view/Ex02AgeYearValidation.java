package view;

import java.time.Year;
import java.util.Scanner;

public class Ex02AgeYearValidation {
	
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhặp năm sinh: ");
		
		String text = " ";
		
		do {
			text = ip.nextLine();
			if (text.matches("\\d+")) {
				break;
			}
			System.out.println("Nâm sinh không hợp lệ, vui longf nhập lại: ");
		}while(true);
		
		//Dongf 30: có khả nưang xảy ra ngoại lệ
		// Cách 1: Sưer dụng validation, đảm bảo dòng code bên dưới không xảy ra ngoại lệ
		// Hiểu login và cách xử lý để thực hiện validate
		
		int yob = Integer.parseInt(text);
		
		int age = Year.now().getValue() - yob + 1;
		System.out.println("Số tuổi: " + age);
		ip.close();
		
	}

}
