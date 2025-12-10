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
		
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		System.out.println("a3: " + a3);
		
		
		float b7 = rd.nextFloat(10f);
		BigDecimal bd7 = BigDecimal.valueOf(b7).setScale(4, RoundingMode.HALF_UP);
		
		
	}

}
