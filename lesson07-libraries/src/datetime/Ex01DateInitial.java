package datetime;

import java.util.Date;

public class Ex01DateInitial {
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println("1. Date(now) --> " + date);
		
		date = new Date(121280);
		System.out.println("2. Date(121280 from epoch time) -> " + date);
		
		
		
	}
}
