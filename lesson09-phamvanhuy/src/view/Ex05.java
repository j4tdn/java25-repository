package view;

import java.util.Scanner;

public class Ex05 {
	
	static int sumSD(int n) {
		int sum = 0;
		while (n > 0) {
			int d = n % 10;
			sum += d * d;
			n /= 10;
		}
		return sum;
	}
	static boolean isHappy(int n) {
		while (n != 1 && n != 4) {
			n = sumSD(n);
		}
		return n == 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập n: ");
		int n = sc.nextInt();
		
		if(isHappy(n))
			System.out.println("Là số hạnh phúc");
		else
			System.out.println("Không phải số hạnh phúc");
	}
}
