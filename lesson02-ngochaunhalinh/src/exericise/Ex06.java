package exericise;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = 0;
		int b = 0 ;
		int c = 0;

		while (true) {

			if (sc.hasNextInt()) {
				if (0 <= a && a < 20) {
					a = sc.nextInt();
					break;
				} else {
					System.out.println("gtri phai be hon 20");
				}
			} else {
				System.out.println("Day kh phai so nguyen to");
				sc.next();
			}
		}
		while (true) {

			if (sc.hasNextInt()) {
				if (0 <= b && b < 20) {
					b = sc.nextInt();
					break;
				} else {
					System.out.println("gtri phai be hon 20");
				}
			} else {
				System.out.println("Day kh phai so nguyen to");
				sc.next();
			}
		}
		while (true) {

			if (sc.hasNextInt()) {
				if (0 <= c && c < 20) {
					c = sc.nextInt();
					break;
				} else {
					System.out.println("gtri phai be hon 20");
				}
			} else {
				System.out.println("Day kh phai so nguyen to");
				sc.next();
			}
		}

		int max = Math.max(a, Math.max(b, c));
		int min = Math.min(a, Math.min(b, c));
		
		System.out.println("max cua a, b, c: " + max);
		System.out.println("min cua a, b, c: " + min);

	}
	
}
