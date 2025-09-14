package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.Random;
import java.util.Scanner;

public class Ex01IfElse {

	private static Random rd = new Random();
	public static void main(String[] args) {

//		int val = rd.nextInt(5, 20);
//
//		if (val % 2 == 0) {
//			int currentYear = YearMonth.now().getYear();
//			System.out.println("Result: " + currentYear);
//		}
		
//		Scanner sc = new Scanner(System.in);
//		String password = sc.nextLine();
//		String result = password.length() >= 8 ? "Mat khau hop le" : "Mat khau ko hop le vui long nhap lai";
//		System.out.println(result);

		double avgPoint = generatePoint();
		if(avgPoint < 5) {
			System.out.println("Yeu");
		}else if(avgPoint < 6.5) {
			System.out.println("Trung Binh");
		}else if (avgPoint < 8) {
			System.out.println("Kha");
		}else {
			System.out.println("Gioi");
		}
	}
	
	private static double generatePoint() {
		double avgPoint = rd.nextFloat(11);
		if(avgPoint > 10f) {
			avgPoint = 10f;
		}
		BigDecimal avgPointBd = BigDecimal.valueOf(avgPoint).setScale(1, RoundingMode.HALF_UP);
		return avgPointBd.doubleValue();
	}
}
