package datetime;

import java.util.Date;

public class Ex01DateInitial {

	public static void main(String[] args) {
		
		// Date: dùng để lưu trữ, các hàm xử lý hầu như đều bị deprecated
		//		--> khuyến khích dùng Calender trong JDK 1.1
		
		// Sat Dec 06 20:29:47 ICT 2025
		Date date = new Date();
		System.out.println("1. Date(now) --> " + date);
		
		date = new Date(60280);
		System.out.println("2. Date(60280 from epoch time) --> " + date);
		
	}
	
}
