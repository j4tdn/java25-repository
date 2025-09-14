package lesson2.assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		while(cnt <= 5) {
			System.out.println("Nhap n: ");
			try {
				int n = Integer.parseInt(sc.nextLine());
				System.out.println((n%2==0 ? "true" : "false"));
				++cnt;
			} catch (NumberFormatException	 e) {
				System.err.println("So ban nhap khong hop le vui long nhap lai");
			}
		}
	}
}
