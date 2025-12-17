package datetime;

import java.util.Date;

public class Ex01DateInitial {
	public static void main(String[] args) {
		// date hàm dùng để lưu trữ các hàm xử lí hầu như bị deprecated (lỗi thời) --> khuyến khích dùng 
		
		//Date(now)--> Thu Dec 11 09:57:40 ICT 2025
		Date date = new Date();
		System.out.println("1.Date(now)--> "+ date);
		
		date = new Date(60280);
		System.out.println("1.Date(60280)--> "+ date);
		
		//date.get
	}

}
