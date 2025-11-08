package function.lambda;

import java.util.Random;


public class Ex02Operation {

	private static Random rd = new Random();

	public static void main(String[] args) {
		int r1 =rd.nextInt(10,20);
		int r2 = rd.nextInt(10,20);
		
		
		System.out.println("r1: "+r1);
		System.out.println("r2: "+r2);
		System.out.println(""
				+ "sum -->" +calculate(r1, r2, (a,b) -> a+b) +"\n" 
				+" sub -->" +calculate(r1, r2, (a,b) -> a-b) +"\n"
				+ "mul -->" +calculate(r1, r2, (a,b) -> a*b) +"\n"	
				+ "div -->" +calculate(r1, r2, (a,b) -> a/b) );
	}
	private static int calculate(int a,int b,Operator operator) {
		return operator.operate(a,b);
	}
}
