package exercise;

import java.util.Random;

public class Ex04SumFac {
	public static void main(String[] args) {
		Random rd = new Random();
		int a = rd.nextInt(10, 20);
		int b = rd.nextInt(10, 20);
		int c = rd.nextInt(10, 20);
		int d = rd.nextInt(10, 20);
		int S = Fac(a) + Fac(b) + Fac(c) + Fac(d);
		
		System.out.printf("Tong giai thua S = %s! + %s! + %s! +%s! = %s", a, b, c, d, S);
	}
	
	private static int Fac(int number) {
		int fac = 1;
		for(int i = 1; i <= number; i++) {
			fac *= i;
		}
		return fac;
	}
	
}
