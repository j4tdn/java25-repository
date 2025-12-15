package datetime;

import java.util.Date;

public class Ex01DateInitial {
	
	public static void main(String[] args) {
		
		// Date: dùng để lưu trữ, các hàm xử lý hầu như bị deprecated(lỗi thời) --> khuyến khích dùng Calendar trong JDK 1.1
		
		// Date(now) --> Sat Dec 06 20:29:29 ICT 2025
		
		Date date = new Date();
		System.out.println("1. Date(now) --> " + date);
		
		date = new Date(121280);
		System.out.println("2. Date(121280 from epoch time) --> " + date);
		
		// date.get
	}
	
}