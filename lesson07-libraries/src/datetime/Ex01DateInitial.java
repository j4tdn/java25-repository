package datetime;

import java.util.Date;

public class Ex01DateInitial {

	public static void main(String[] args) {
		
		// Date: dùng để lưu trữ, các hàm xử lý hầu như bị deprecated(lỗi thời) --> khuyến khích dùng calendar trong IDK 1.1
		
		Date date = new Date();
		System.out.println("1. Date(now) : " + date);
		
		date = new Date(60280);
		System.out.println("2. Date(60280) from epoch(1/1/1970) time : " + date);

		// date.get => nên sd Calendar.MONTH
	}
}
