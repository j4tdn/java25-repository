package function.lambda;

import java.util.Random;

public class Ex02Operation {
	private static Random rd = new Random();
	
	public static void main(String[] args) {
		int r1 = rd.nextInt(10, 20);
		int r2 = rd.nextInt(10, 20);
		
		System.out.println("r1: " + r1);
		System.out.println("r2: " + r2);
	}
	
	private static int sum(int a, int b) {
		return a + b;
		
	}

}
