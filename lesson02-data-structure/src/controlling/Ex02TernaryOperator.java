package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Ex02TernaryOperator {
	public static void main(String[] args) {
		/*
		 * Toán tử 3 ngôi: (
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		Random rd = new Random();
		int val = rd.nextInt();
		System.out.println("Gtri: " + val);
//		if(val %2==0 ) {
//			System.out.println("gtri random la so chan: ");
//		}else {
//			System.out.println("gtri random la so le");
//		}
//		

		System.out.println("gtri random la: " + ((val % 2 == 0) ? "chan" : "le"));

		int a = rd.nextInt(20);
		int b = rd.nextInt(20);
		int c = rd.nextInt(20);

		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);

		int max1 = (a > b) ? a : b;
		int max2 = max1 > c ? max1 : c;
		System.out.println("gtri lon nhat a, b: " + max1);
		System.out.println("gtri lon nhat a, b, c: " + max2);

		
		//
		float point = 6.8f;
		String ranking = (point < 5) ? "Yeu" : (point < 6.5) ? "Trung binh" : (point < 8) ? "Kha" : "Gioi";
		System.out.println("Hoc luc: " + ranking);

	}
}
