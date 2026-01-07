package view;

import java.util.Scanner;

public class Ex05HappyNumber {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập n: ");
		int n = Integer.parseInt(ip.nextLine());
		if (isHappyNumber(n)) {
			System.out.println(n + "là số hạnh phúc");
			
			}else {
				System.out.println(n+ "không phải là số hạnh phúc");
			
		}
	}
	
	private static int sqrt(int number) {
		int sum = 0;
		while (number > 0) {
			int r = number % 10;
			sum += r*r;
			number = number /10;
		}
		return sum;
	}
	
	
	
	 public static boolean isHappyNumber(int n) {
		 int a = n;
		 int b = n;
	do {
		a = sqrt(a);
		b = sqrt(sqrt(b));
	} while (a!= b);
	return a == 1;
	 }

}
