package d1;

import java.util.Scanner;

public class GetMinFract {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double number = 0;
		int count = 0;

		while (count < 3) {
			System.out.println("Nhap so co phan thap phan khac 0: ");
			number = sc.nextDouble();
			if (number % 1 != 0) {
				break;
			}
			System.out.println("nhap lai!");
			count++;
		}
		if (number % 1 == 0) {
			System.out.println("Da nhap qua 3 lan!");

		} else {
			System.out.println("Phan so toi gian la: " + getMinFract(number));
		}

	}

	public static int getUCLN(int a, int b) {

		while (b != 0) {
			int tem = b;
			b = a % b;
			a = tem;
		}
		return a;

	}

	public static String getMinFract(double number) {
		String s = String.valueOf(number);
		int count = 0;

		if (s.contains(".")) {
			count = s.length() - s.indexOf(".") - 1;
		}
		int denominator = powerOf10(count);
		double numberatordb = number * denominator;
		String numberatorStr = String.valueOf(numberatordb);
		if (numberatorStr.contains(".")) {
			numberatorStr.substring(0, numberatorStr.indexOf("."));
		}
		int numberator = 0;
		for (int i = 0; i < numberatorStr.length(); i++) {
			numberator = numberator * 10 + (numberatorStr.charAt(i) - '0');
		}
		int UCLN = getUCLN(numberator, denominator);
		numberator = numberator / UCLN;
		denominator = denominator / UCLN;
		return numberator + "/" + denominator;
	}

	public static int powerOf10(int n) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= 10;
		}
		return result;

	}
}
