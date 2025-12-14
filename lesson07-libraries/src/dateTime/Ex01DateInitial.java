package dateTime;

import java.util.Date;

public class Ex01DateInitial {

	public static void main(String[] args) {
		
		// Date: ung de luu tru, cac ham xu ly hau nhu bi deprecated(loi thoi) --> khuyen lhich dung Calender trong JDK 1.1
		
		Date date = new Date();
		System.out.println("1. Date(now) --> " + date);
		
		date = new Date(60280);
		System.out.println("1. Date(60280 from epoch time) --> " + date);
		
		// date.get
	}
	
}
