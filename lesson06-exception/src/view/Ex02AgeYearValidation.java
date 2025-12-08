package view;

import java.time.Year;
import java.util.Scanner;

public class Ex02AgeYearValidation {
	// Đặt vấn đề
		// Bài toán: Nhập vào năm sinh của người dùng, in ra số tuối của người đó
		//         : Tuổi = Năm hiện tại - năm sinh + 1
		
		public static void main(String[] args) {
			
			Scanner ip = new Scanner(System.in);
			
			System.out.println("Nhập năm sinh: ");
			
			String text = "";
			
			do {
				text = ip.nextLine();
				if(text.matches("\\d+")) {
					break;
				}
				System.out.println("Năm sinh k hợp lệ, vui lòng nhập lại:");
			} while(true);
			
			// Dòng 30: Có khả năng xảy ra ngoại lệ(runtime)
			// Cách 1: Sử dụng validation, đảm bảo dòng code bên dưới k xảy ra ngoại lệ
			// Hiểu logic và cách xử lí để thực hiện validation
			int yob = Integer.parseInt(ip.nextLine());
			
			int age = Year.now().getValue() - yob + 1;
			
			System.out.println("\n => Số tuổi = " + age);
			
			ip.close();

		}
}
