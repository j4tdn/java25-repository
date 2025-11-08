package view;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập 2 số: ");
		int a = ip.nextInt();
		int b = ip.nextInt();

		if (b > a) {
			int c = a;
			a = b;
			b = c;
		}
		
		while (a % b == 0) {
			 a = a / b;
		}
		if (a == 1) {
			System.out.print("True");
		}
		else {
			System.out.print("False");
		}
		
		ip.close();
	}
}