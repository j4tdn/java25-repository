package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeYearProblem {

	// Đặt vấn đề
	// Bài toán: Nhập vào năm sinh của người dùng , in ra số tuổi của người đó
	//			: Tuổi = Năm sinh hiện tại - năm sinh + 1
	
	
		public static void main(String[] args) {
				Scanner ip = new Scanner(System.in);
				
				System.out.print("Nhap nam sinh : ");
			
				//Dòng 19 có khả năng xảy ra ngoại lệ 
				//Cách 1 : Sử dụng Validation , đảm bảo dòng code bên dưới ko xảy ra ngoại lệ 
				int yob = Integer.parseInt(ip.nextLine());
			
				int age = Year.now().getValue() - yob + 1;
				
				System.out.println("So tuoi: "+ age);
				ip.close();
			}
}
