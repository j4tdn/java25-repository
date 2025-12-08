package view;

import java.time.Year;
import java.util.Scanner;

public class Ex03AgeYearTryCatch {
	public static void main(String[] args) {

		Scanner ip = new Scanner(System.in);

		System.out.println("NHAP NAM SINH");
		
		// cách 2: sử dụng Try catch để xử lý ngoại lệ(xảy ra)
		// đặt đoạn mã có khả năng xảy ra ngoại lệ trong khối try
		// TH1: nếu code ko xảy ra ngoại lệ, thì ko nhảy vào khối catch và tiếp tục bình thường
		// TH2: nếu code xảy ra ngoại lệ:
		//      + bắt đúng ngoại lệ(exception, dùng exception cha của nó) --> nhảy vào khối catch --> tiếp tục chương trình bên dưới
		//      + bắt ko đúng ngoại lệ --> dừng chương trình
		
		// hạn chế dùng catch(Exception e)
		//   - ko rõ ràng
		//   - phần xử lý bên trong catch có thể khác với exception mong muốn
		//   - trường hợp code trong khối try có thể bị nhiều exception
		//     + nếu mình xử lý riêng cho từng loại --> có nhiều khối catch xử lý riêng
		//     + muốn xử lý chung cho tất cả các loại exception --> chỉ cần catch(exception) và xử lý
		int yob = 0;
		do {
			try {
				yob = Integer.parseInt(ip.nextLine());
				break;
			} catch(Exception nfe) {
				System.out.println(">> " + nfe.getMessage());
				nfe.printStackTrace();
				System.out.println("Năm sinh chưa hợp lệ, vui lòng nhập lại");
				
			}
			
		} while (true);
		
		

		int age = Year.now().getValue() - yob + 1;

		System.out.println("\n n --> Số tuổi: " + age);

		ip.close();

	}

}
