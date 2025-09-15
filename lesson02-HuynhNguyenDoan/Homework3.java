package homework;

import java.util.Scanner;

public class Homework3 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		System.out.println("Nhap so: ");
		int number = ip.nextInt();
		int factorialNumber = 1;
		for (int i = 1; i <= number; i++) {
			factorialNumber *= i;
		}
		System.out.println("Giai thua cua so " + number + " La " + factorialNumber);
		ip.close();
	}
	
}
