package view;

import java.time.Year;
import java.util.Scanner;


public class Ex03AgeYearTRyCatch {
	
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhặp năm sinh: ");
		
		// Dongf có khả năng xảy ra ngoại lệ
		// Cách 2: sử dụng try/catch để xử lý ngoại lệ xảy ra
		// Đặt đoạn mã có khả năng xảy ra ngoại lệ trong khối try
		// TH1: nếu code không xảy ra ngoại lệ --> không nhảy vào khối catch --> tiếp tục chương trình bên dưới
		// TH2: nếu code xảy ra ngoại lệ
		// 		2.1: bắt đúng ngoại lệ(exception, dung exception cha của nó) --> nhảy vào khối catch --> tiếp tục chương trình bên dưới
		//		2.2: bắt không đúng ngoiaj lệ --> dừng chương trình
		
		// Hạn chế dùng catch(Exception e)
		//Không rõ ràng
		// phần xử lý bên trong catch có thể khác với exception mong muốn 
		// -trường hợp code trong khối try có thể bị nhiều exception
		// 	. nếu mình xử lý riêng cho từng loại --> có nhiều khối catch xử lý riêng
		// 	. muốn xử lý chung cho tất cả các loại exception --> chỉ cần catch(Exception) và xử lý
		int yob = 0;
	do {
		try {
			 yob = Integer.parseInt(ip.nextLine());
			 break;
		}catch(ArithmeticException e){
			System.out.println(">> " + e.getMessage());
			System.out.println("Năm sinh không hợp lệ, hãy nhập lại: ");
		}
	}while(true);
		
		int age = Year.now().getValue() - yob + 1;
		
		System.out.println(age);
		
		ip.close();
		
	}

}
