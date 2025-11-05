package function.lamda;

import java.util.Random;

public class Ex02Operator {

	private static Random rd = new Random(
			);
	
	public static void main(String[] args) {
		int r1 = rd.nextInt(10, 20);
		int r2 = rd.nextInt(10, 20);
		
		System.out.println(""
				+ "sum --> " + calculate(r1, r2, (a, b) -> a + b) + "\n"
				+ "sub --> " + calculate(r1, r2, (a, b) -> a - b) + "\n"
				+ "mul --> " + calculate(r1, r2, (a, b) -> a * b) + "\n"
				+ "div --> " + calculate(r1, r2, (a, b) -> a / b) + "\n");
	}
	
	private static int calculate(int a, int b, Operator operator) {
		return operator.operate(a, b);
	}
//	
//	private static int sum(int a, int b) {
//		return a + b;
//	}
//	
//	private static int sub(int a, int b) {
//		return a - b;
//	}
//	
//	private static int mul(int a, int b) {
//		return a * b;
//	}
//	
//	private static int div(int a, int b) {
//		return a / b;
//	}
}
