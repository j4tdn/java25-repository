package exercises;

import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = 0;
		int temp = 0;
		System.out.print(" Nhap so nguyen duong N: ");
		while (temp < 5) {

			try {
				N = sc.nextInt();

				if (N > 0) {
					break;
				} else {
					System.out.print("N khong hop le, nhap lai N: ");
				}

			} catch (Exception e) {
				System.out.print("N khong hop le, nhap lai N: ");
				sc.nextLine();
			}

			temp++;

			if (temp == 5) {
				System.out.println("Qua so lan nhap, ket thuc chuong trinh!");
				sc.close();
				return;
			}
		}

		int number = N;
		while (number % 2 == 0) {
			number = number / 2;
		}

		if (number == 1) {
			System.out.println(N + " là lũy thừa của 2");
		} else {
			System.out.println(N + " không phải là lũy thừa của 2");
		}
	}
}
