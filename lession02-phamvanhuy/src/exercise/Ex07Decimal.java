package exercise;

import java.util.Scanner;

public class Ex07Decimal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhâp n: ");
		int n = sc.nextInt();
		String nhiphan = Integer.toBinaryString(n);
		System.out.println("Hệ nhị phân của " + n + "là: " + nhiphan);
	}
}
