package assigment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0;
		boolean isValid = false;

		while (!isValid) {
			try {
				System.out.println("Nhap so a: ");
				a = sc.nextInt();
				if (a == 0) {
					System.out.println("Khong the chia cho 0, vui long nhap lai!");
					continue;
				}
				System.out.println("Nhap so b: ");
				b = sc.nextInt();
				if (b == 0) {
					System.out.println("khong the chia cho 0, vui long nhap lai!");
					continue;
				}
				isValid = true;
			} catch (InputMismatchException ex) {
				System.out.println("Khong the nhap chu, vui long nhap lai! ");
				sc.nextLine();
			}
		}
		int x = -b / a;
		System.out.println("Ket qua cua phuong trinh la: " + x);

		sc.close();
	}
}
