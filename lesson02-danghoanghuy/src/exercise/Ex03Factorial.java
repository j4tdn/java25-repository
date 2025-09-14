package exercise;

import java.util.Scanner;

public class Ex03Factorial {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap 1 so nguyen");
		int number = ip.nextInt();
		
		factorial(number);
		ip.close();
	}
	
	private static int factorial(int number) {
		int fac = 1;
		System.out.print(number + "! = ");
		for(int i = number; i > 0; i--) {
			fac *= i;
			if(i == 1) {
				System.out.print(i);
			}
			else System.out.print(i + ".");
		}
		System.out.println(" = " + fac);
		return fac;
	}
	
}
