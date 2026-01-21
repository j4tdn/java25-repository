package datetime;

import java.util.Date;

public class Ex01DateInitial {

	public static void main(String[] args) {

		// Date: dùng để lưu trữ, các hàm xử lý hầu như bị lỗi thời -> khuyến khích dùng
		// calender trong JDK 1.1

		Date date = new Date();
		System.out.println("1. Date: " + date);

		date = new Date(60280);
		System.out.println("2. Date(60280 from epoch time): " + date);

		// date.getMonth();

	}

}
