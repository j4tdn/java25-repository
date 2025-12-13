package view;

import java.time.Year;
import java.util.Scanner;

public class Ex03AgeYearCatch {

	// Đặt vấn đề
	// Bài toán: Nhập vào năm sinh của người dùng , in ra số tuổi của người đó
	//			: Tuổi = Năm sinh hiện tại - năm sinh + 1
	
	
		public static void main(String[] args) {
				Scanner ip = new Scanner(System.in);
				
				System.out.print("Nhap nam sinh : ");
			
				//Dòng 19 có khả năng xảy ra ngoại lệ 
				//Cách 2: Sử dụng try/catch để xử lí ngoại lệ ( xảy ra)
				// Đặt doạn mã cí khả năng xảy ra ngoại lệ trong khôis try
				//TH1: Nếu code ko xảy ra ngoại lệ --> ko nhảy vào khối catch--> tiếp tục chương trình bên dưới
				//TH2: Nếu code xảy ra ngoại lệ
				// 		2.1: Bắt đúng ngoại lệ(exception, dùng exception cha của nó) --> nhảy vào khối catch--> tiêp tục chương trình bên dưới
				//		2.2: băts ko đúng ngoại lệ: --> dừng chương trình 
				
				// Hạn chế dùng catch(Exception e)
				//- Vì nó ko rỏ ràng 
				//- Phần xử lí bên trong catch có thể khác với exception mong muốn
				//- Trườg hợp code trong khối try co thể bị nhiều exception 
				//	+ nếu mình xử lí riêgn cho từng loại --> có nhìu khối catch xử lí riêng
				//	+ muốn xử lí chung cho tất cả cac loại exception --> chỉ cần catch(Exception) và xử li
				
				
				int yob = 0;
				do {
					try {
						 yob = Integer.parseInt(ip.nextLine()); //NFE
						 break;
					}catch(Exception e) {
						e.printStackTrace();
						//System.out.println(">> "+ nfe.getMessage());
						System.out.println("Năm sinh ko hợp lệ , vui lòng nhập lại.");
					}
				}while(true);
				
			
				int age = Year.now().getValue() - yob + 1;
				
				System.out.println("So tuoi: "+ age);
				ip.close();
			}
}
