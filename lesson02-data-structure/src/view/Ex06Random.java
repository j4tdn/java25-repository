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

		System.out.println("=== Random so nguyen ===");
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		System.out.println("a3: " + a3);

		System.out.println("=== Random so thuc ===");
		float b1 = rd.nextFloat();
		float b2 = rd.nextFloat(17.62f);
		float b3 = rd.nextFloat(2.84f, 11.5f);

		double b4 = Math.random();
		double b5 = Math.random() * 8.8f;
		double b6 = 2.2f + Math.random() * 6.6f;

		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		System.out.println("b3: " + b3);
		System.out.println("b4: " + b4);
		System.out.println("b5: " + b5);
		System.out.println("b6: " + b6);

		double b7 = (Math.random() * 10f);
		BigDecimal bd7 = BigDecimal.valueOf(b7).setScale(4, RoundingMode.HALF_UP);
		System.out.println(bd7);
	}

}
