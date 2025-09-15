package homework.lesson02;

import java.util.Scanner;

public class Ex06MaxMin {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int numbera = 0;
		int numberb = 0;
		int numberc = 0;

		while (true) {
			System.out.println("Nhập a ");
			String text = ip.nextLine();
			if (isValid(text)) {
				numbera = Integer.parseInt(text);
				if (numbera >= 0 && numbera < 20) {
					System.out.println(numbera);
					break;
				} else {
					System.out.println("Nhập lại");
				}
			} else {
				System.out.println("không phải số nguyên, Nhập lại");
			}
		}

		while (true) {
			System.out.println("Nhập b ");
			String text = ip.nextLine();

			if (isValid(text)) {
				numberb = Integer.parseInt(text);
				if (numberb >= 0 && numberb < 20) {
					System.out.println(numberb);
					break;
				} else {
					System.out.println("Nhập lại");
				}
			} else {
				System.out.println("không phải số nguyên, Nhập lại");
			}
		}

		while (true) {
			System.out.println("Nhập c ");
			String text = ip.nextLine();

			if (isValid(text)) {
				numberc = Integer.parseInt(text);
				if (numberc >= 0 && numberc < 20) {
					System.out.println(numberc);
					break;
				} else {
					System.out.println("Nhập lại");
				}
			} else {
				System.out.println("không phải số nguyên, Nhập lại");
			}
		}
		ip.close();

		System.out.println("\nSố lớn nhất của a,b,c --> " + Max(numbera, numberb, numberc));
		System.out.println("\nSố nhỏ nhất của a,b,c --> " + Min(numbera, numberb, numberc));

	}

	private static int Max(int a, int b, int c) {
		int max1 = (a > b) ? a : b;
		int max2 = max1 > c ? max1 : c;
		return max2;
	}

	private static int Min(int a, int b, int c) {
		int min1 = (a < b) ? a : b;
		int min2 = min1 < c ? min1 : c;
		return min2;
	}

	private static boolean isValid(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
