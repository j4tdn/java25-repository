package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Ex06Random {
	public static void main(String[] args) {
		Random rd = new Random();

		int a1 = rd.nextInt(); // [min_int : max int]
		int a2 = rd.nextInt(88); // [0, 88)
		int a3 = rd.nextInt(10, 20); // [10, 20)

		System.out.println("=== Random số nguyên ===");
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		System.out.println("a3: " + a3);

		System.out.println("\n=== Random số thực ===");
		float b1 = rd.nextFloat();
		float b2 = rd.nextFloat(17.62f);
		float b3 = rd.nextFloat(2.84f, 11.5f);

		double b4 = Math.random(); // [0.0, 1.0)
		double b5 = Math.random() * 8.8f; // [0.0, 8.8)
		double b6 = 2.2 + Math.random() * 6.6f; // [2.2, 8.8)

		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		System.out.println("b3: " + b3);
		System.out.println("b4: " + b4);
		System.out.println("b5: " + b5);
		System.out.println("b6: " + b6);
		// sau khi random lấy kết quả vs 4 số thập phân
		// DecimalFormat truyền vào số -->format ra string
		// Bigdecimal -> set Scale ra

		System.out.println("\n=== Random số thực có 4 chữ số thập phân trong phạm vi từ [0, 10) ===");
		float b7 = rd.nextFloat(10.1f);
		BigDecimal bd7 = BigDecimal.valueOf(b7).setScale(4, RoundingMode.HALF_EVEN);
		System.out.println("b7: " + b7);
		System.out.println("b7: " + bd7);
	}
}
