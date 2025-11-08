package function.lambda;

import java.util.Random;

public class Ex02Operation {
	
	private static Random rd = new Random();
	public static void main(String[] args) {
		int r1 = rd.nextInt(10, 20);
		int r2 = rd.nextInt(10, 20);
		
		System.out.println("r1 : " + r1);
		System.out.println("r2 : " + r2);
		
		
		System.out.println("sum --> " + caculate(r1, r2, (a, b) -> a+b));
		System.out.println("sub --> " + caculate(r1, r2, (a, b) -> a-b));
		System.out.println("mul --> " + caculate(r1, r2, (a, b) -> a*b));
		System.out.println("div --> " + caculate(r1, r2, (a, b) -> a/b));
	}
	
	private static int caculate(int a, int b, Operator operator) {
		return operator.operate(a, b);
	}
	
	private static int sum(int a, int b){
		return a + b;
	}
	private static int sub(int a, int b){
		return a - b;
	}
	private static int mul(int a, int b){
		return a * b;
	}
	private static int div(int a, int b){
		return a / b;
	}
}
