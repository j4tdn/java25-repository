package d1;

import java.util.Scanner;

public class GetMaxValidNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhap chuoi: ");
		String s = sc.nextLine();

		int max = getMaxValidNumber(s);
		System.out.println("So lon nhat trong chuoi la: " + max);
	}

	public static int getMaxValidNumber(String s) {
		int max = 0;
		int temp = 0;
		boolean Digit = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				temp = temp * 10 + (c - '0');
				Digit = true;
			} else {
				if (temp > max) {
					max = temp;
					temp = 0;
				}

			}
			if (temp > max) {
				max = temp;
				if (!Digit)
					return 0;
			}

		}
		return max;
	}
}
