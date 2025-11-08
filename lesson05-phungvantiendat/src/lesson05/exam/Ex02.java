package lesson05.exam;

import java.util.Scanner;

public class Ex02 {
	private static boolean isSpecialNumber(int n, int S) {
		int sum = 0;
		for(int i = 1;i<=n;++i) {
			sum+=i;
		}
		return sum == S;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int S = Integer.parseInt(sc.nextLine());
		System.out.println(isSpecialNumber(n, S));
	}
	
}
