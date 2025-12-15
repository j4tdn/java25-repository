package view;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

public class Ex03AgeYearTryCatch {
	
	// Đặt vấn đề
	// Bài toán: Nhập vào năm sinh của người dùng, in ra số tuổi của người đó
	//         : Tuổi = Năm hiện tại - Năm sinh + 1
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập năm sinh: ");
		
		// Dòng **: Có khả năng xảy ra ngoại lệ
		// Cách 2: Sử dụng try/catch để xử lý ngoại lệ(xảy ra)
		
		// Đặt đoạn mã có khả năng xảy ra ngoại lệ trong khối try
		// TH1: nếu code không xảy ra ngoại lệ --> không nhảy vào khối catch --> tiếp tục chương trình bên dưới
		// TH2: nếu code xảy ra ngoại lệ
		//      2.1: bắt đúng ngoại lệ(exception, dùng exception cha của nó) --> nhảy vào khối catch --> tiếp tục chương trình bên dưới
		//      2.2: bắt không đúng ngoại lệ --> dừng chương trình
		
		// Hạn chế dùng catch(Exception e)
		// - không rõ ràng
		// - phần xử lý bên trong catch có thể khác với exception mong muốn
		// - trường hợp code trong khối try có thể bị nhiều exception
		//   . nếu mình xử lý riêng cho từng loại --> có nhiều khối catch xử lý riêng
		//   . muốn xử lý chung cho tất cả các loại exception --> chỉ cần catch(Exception) và xử lý
		
		int yob = 0;
		
		do {
			try {
				yob = Integer.parseInt(ip.nextLine()); // NFE
				break;
			} catch(ArithmeticException e) {
				// System.out.println(">> " + nfe.getMessage());
				e.printStackTrace();
				System.out.print("Năm sinh không hợp lệ, vui lòng nhập lại: ");
			}
		} while(true);
		
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