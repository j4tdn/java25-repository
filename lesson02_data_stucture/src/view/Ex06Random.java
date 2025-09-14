package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Ex06Random {
	
	public static void main(String[] args) {
		
		Random rd = new Random();
		int a1 = rd.nextInt();  // [min_int : max_int]
		int a2 = rd.nextInt(88); // 0 ~ 88
		int a3 = rd.nextInt(10,20); // 10 ~ 20
		
		
		System.out.println("=== Random so nguyen ===");  // int, long, bigint
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		System.out.println("a3: " + a3);
		
		
		System.out.println("\n=== Random so thuc ===");  // float, double, bigdecimal
		float b1 = rd.nextFloat();
		float b2 = rd.nextFloat(17.62f);
		float b3 = rd.nextFloat(2.84f, 11.5f);
		double b4 = Math.random(); // 0.0 ~ 1.0
		double b5 = Math.random() * 8.8f; // 0.0 ~ 8.8   Math.random() * a = rd.nextDouble(a)
		double b6 = 2.2 + Math.random() * 6.6f; // 2.2 ~ 8.8    a + ard * (b-a)
		System.out.println("b1 :" + b1);
		System.out.println("b2 :" + b2);
		System.out.println("b3 :" + b3);
		System.out.println("b4 :" + b4);
		System.out.println("b5 :" + b5);
		System.out.println("b6 :" + b6);
		
		// Sau khi random lay ket qua vs 4 so thap phan
		// DecimalFormat truyen vao so --> format ra sting
		// BigDecimal -> setScale
		
		
		System.out.println("\n=== Random so thuc co 4 chu so thap phan trong pham vi tu [0:10] ===");
		
		float b7 = rd.nextFloat();
		BigDecimal bd7 = BigDecimal.valueOf(b7).setScale(4, RoundingMode.HALF_UP);
		
		System.out.println("b7 :" + b7);
		System.out.println("bd7 :" + bd7);
		
	}

}
