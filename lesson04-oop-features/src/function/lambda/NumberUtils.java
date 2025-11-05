package function.lambda;

import java.util.Scanner;

public class NumberUtils {

	private static Scanner ip = new Scanner(System.in);
	
	private NumberUtils() {
		
	}
	
	public static Integer inputNumber(String statement, Condition con, int maxFailedTime) {
		Integer n = null;
		String text = null;
		
		int wrongTimes = 0;
		do {
			System.out.printf(statement);
			text = ip.nextLine();
			if(isNumber(text) && con.match(Integer.parseInt(text))) {
				n = Integer.parseInt(text);
				if(con.match(wrongTimes)) {
					return n;
				}
			}
			wrongTimes++;
			System.out.println("Sai lần thứ " + wrongTimes);
			if(wrongTimes == maxFailedTime) {
				System.out.println("Đã vượt quá " + maxFailedTime + "lần");
			}
		} while(true);
	}
	
	private static boolean isNumber(String text) {
		return true;
	}
	
}
