package assigment;

import java.util.Scanner;

public class Ex04 extends NumberUtils{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhập số (0 - 999): ");
		int n = sc.nextInt();

		System.out.println(readNumber(n));
		sc.close();
	}


}
