package view;

import java.time.Year;
import java.util.Scanner;

public class Ex02AgeYearValidation {
	public static void main(String[] args) {

		Scanner ip = new Scanner(System.in);

		// cách 1: sử dung validation, đảm bảo dòng code bên dưới ko xảy ra ngoại lệ
		System.out.println("NHAP NAM SINH");
		
		String text = "";
		do {
			text = ip.nextLine();
			if (text.matches("\\d+")) {
				break;
			}
			System.out.println("Năm sinh chưa hợp lệ, vui lòng nhập lại");
			
		} while(true);
		
		
		int yob = Integer.parseInt(text);

		int age = Year.now().getValue() - yob + 1;

		System.out.println("\n n --> Số tuổi: " + age);

		ip.close();

	}

}
