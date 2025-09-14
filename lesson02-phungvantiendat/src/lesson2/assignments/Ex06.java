package lesson2.assignments;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = input(sc, 'a');
		int b = input(sc, 'b');
		int c = input(sc, 'c');
		
		int max = Math.max(a, Math.max(b, c));
		int min = Math.min(a, Math.min(b, c));
		
		System.out.println("Max cua 3 so: "+max);
		System.out.println("Min cua 3 so: "+min);
	}

	private static int input(Scanner sc, char c) {
		int n = -5;
		while (n < 0 || n >= 20) {
			System.out.println("Nhap gia tri cho "+ c);
			try {
				n = Integer.parseInt(sc.nextLine());
				if(n < 0 || n>=20) {
					System.out.println("Gia tri nam ngoai khoang [0,20) roi :((");
				}
			} catch (Exception e) {
				System.err.println("Nhap sai vui long nhap lai ");
			}
		}
		return n;
	}
}
