package datetime;

import java.util.Date;

public class Ex01DateInitial {
	public static void main(String[] args) {
		
		// Date: dung de luu tru, cac ham xy ly hau nhu bi deprecated(loi thoi) --> khuyen khich dung Calender trong JDK 1.1
		
		// Date(now) --> Sat Dec 06 20:29:29 ICT 2025
		
		Date date = new Date();
		System.out.println("1. Date(now) --> " + date);
		
		date = new Date(6028);
		System.out.println("2. Date(121280) from epoch time) --> " + date);
		
		//date.get
	}

}
