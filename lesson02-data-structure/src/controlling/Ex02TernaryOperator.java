package controlling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Ex02TernaryOperator {
	public static void main(String[] args) {
		/*
		 if (expression){
		 	statements if exp is true
		 } else{
		 	statements if exp is false
		 }
		 
		 Toan tu 3 ngoi: (expression) ? statements(1) : statements(2);
		 				(expression) ? return_data(1) : return_data(2)
		 */
		Random rd = new Random();
		int val = rd.nextInt();
		
		System.out.println("Gia tri: " + val);
		if(val % 2 == 0) {
			System.out.println("Gia tri random la so chan");
		}
		else System.out.println("Gia tri random la so le");
		
		System.out.println("[Toan tu 3 ngoi]" + ((val % 2 == 0) ? "Gia tri random la so chan" : "Gia tri random la so le"));
		
		int a = rd.nextInt(20);
		int b = rd.nextInt(20);
		int c = rd.nextInt(20);
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		int max1 = (a > b) ? a : b;
		int max2 = (max1 > c) ? max1 : c;
		
		System.out.println("GTLN 2 so a, b: " + max1);
		System.out.println("GTLN 3 so a, b, c: " + max2);
		
		float mark = rd.nextFloat(10);
		String s1 = mark < 5 ? "Yeu"
								: mark < 6.5 ? "Trung Binh"
											 : mark < 8 ? "Kha"
													    : "Gioi";
		System.out.println("Hoc Luc: " + s1);
		System.out.println("Diem: " + mark);
	}
}
