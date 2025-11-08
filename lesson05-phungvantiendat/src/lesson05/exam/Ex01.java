package lesson05.exam;

import java.util.Scanner;

public class Ex01 {
	
	private static boolean isPowerOf(int a, int b) {
		return pow(a,b) || pow(b,a);
	}
	
	private static boolean pow(int a, int n) {
		if(n==1) {
			return true;
		}
		while(a%n==0) {
			a/=n;
		}
		return a==1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		System.out.println(isPowerOf(8,2));
		System.out.println(isPowerOf(64,4));
		System.out.println(isPowerOf(a,b));
	}
	
}
