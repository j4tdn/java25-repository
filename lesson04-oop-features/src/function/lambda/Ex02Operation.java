package function.lambda;

import java.util.Random;

public class Ex02Operation {
	
	private static Random rd = new Random();
	
	public static void main(String[] args) {
		int r1 = rd.nextInt(10, 20);
		int r2 = rd.nextInt(10, 20);
		
		System.out.println("r1: " + r1);
		System.out.println("r2: " + r2);
		
		System.out.println(""
				+ "sum --> " + sum(r1, r2) + "\n"
				+ "sub --> " + sub(r1, r2) + "\n"
				+ "mul --> " + mul(r1, r2) + "\n"
				+ "div --> " + div(r1, r2) + "\n"
				);
		
		System.out.println(""
				+ "sum --> " + calculate(r1, r2, (a, b) -> a + b) + "\n"
				+ "sub --> " + calculate(r1, r2, (a, b) -> a - b) + "\n"
				+ "mul --> " + calculate(r1, r2, (a, b) -> a * b) + "\n"
				+ "div --> " + calculate(r1, r2, (a, b) -> a / b) + "\n"
				);
		
	}
	
	// int (int, int)
	
	private static int calculate(int a, int b, Operator operator) {
		return operator.operate(a, b);
	}
	
	private static int sum(int a, int b) {
		return a + b;
	}
	
	private static int sub(int a, int b) {
		return a - b;
	}
	
	private static int mul(int a, int b) {
		return a * b;
	}
	
	private static int div(int a, int b) {
		return a / b;
	}
	
}