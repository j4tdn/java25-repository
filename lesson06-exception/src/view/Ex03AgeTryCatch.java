package view;

import java.time.Year;
import java.util.Scanner;

public class Ex03AgeTryCatch {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);		
		System.out.print("Nhap nam sinh: ");
		
		// Dòng **: có khả năng xảy ra ngoịa lệ
		// Cách 2: sử dụng try/catch để xử lý ngoại lệ(xảy ra)
		
		// Đặt đoạn mã có khả năng xảy ra ngoại lệ trong khối try
		// TH1: nếu code không xảy ra ngoại lệ --> không nhảy vào khối catch --> tiếp tục chương trình bên dưới
		// TH: nếu code xảy ra ngoại lệ
		//	2.1: bắt đúng ngoại lệ(exception, dùng exception cha của nó) --> nhảy vào khối catch --> tiếp tục ctrinh bên dưới
		//	2.2: bắt không đúng ngoại lệ --> dừng trinh
		
		// Hạn chế dùng catch(Exception e)
		// - không rõ ràng
		// - phần xử lý bên trong catch có thể khác với exception mong muốn
		// - trường hợp code trong khối try có thể bị nhiều exception
		//	. nếu mình xử lý riêng cho từng loại exception --> chỉ cần catch(Exception) và xử lý
		//	. muốn xử lý chung cho tất cả các loại exception....

		int yob = 0;
		
		do {
			try {
				yob = Integer.parseInt(ip.nextLine());
				break;
			} catch(ArithmeticException nfe) {
				System.out.println(">> " + nfe.getMessage());
				System.out.println("Nam sinh khong hop le, vui long nhap lai");
			}
		} while (true);
		
		
		
		int age = Year.now().getValue() - yob + 1;
		
		System.out.print("\n==> so toi = " + age);
		
		ip.close();
	}

}
