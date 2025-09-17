package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Ex06Random {
	public static void main(String[] args) {
		Random rd = new Random();
		int a1 = rd.nextInt(); 
		int a2 = rd.nextInt(88);
		int a3 = rd.nextInt(10, 20);
		
		System.out.println("==== Random so nguyen ==== ");
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		System.out.println("a3: " + a3);
		
		System.out.println("==== Random so thuc ==== ");
		float b1 = rd.nextFloat();
		float b2 = rd.nextFloat(17.62f);
		float b3 = rd.nextFloat(2.84f, 11.5f);
		
		double b4 = Math.random() * 8.8f; // [0.0 : 8.8); --> Math.random() * a = rd.nextDouble(a);
		double b5 = 2.2 + Math.random() * 6.6f; //[2.2 : 8.8);
		
		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		System.out.println("b3: " + b3);
		System.out.println("b4: " + b4);
		System.out.println("b5: " + b5);
		
		System.out.println(" \n=== Random so thuc co 4 chu so thap phan trong pham vi [0, 10]");
		
		float c1 = rd.nextFloat(10f);
		System.out.println("c1: " + c1);
		BigDecimal cc1 = BigDecimal.valueOf(c1).setScale(4, RoundingMode.HALF_UP);
		System.out.println("c1: " + c1);
		System.out.println("cc1: " + cc1);
	}
}
