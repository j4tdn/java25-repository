package exercise;

import java.util.Scanner;

public class Ex08Prime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;

		for (int i = 0; i < 5; i++) {
			System.out.print("Nhập số nguyên dương : ");
			String text = sc.nextLine();

			if (laSoNguyenDuong(text)) {
				n = Integer.parseInt(text);
				break;
			} else {
				System.out.println("Không hợp lệ, nhập lại");
			}
		}

		if (n > 0)
			System.out.println(n + " → " + prime(n));
		else
			System.out.println("Nhập sai quá 5 lần");
	}
	
	public static boolean laSoNguyenDuong(String text) {
		if (text.length() == 0)
			return false;
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i)))
				return false;
		}
		return Integer.parseInt(text) > 0;
	}
	public static boolean prime(int n) {
		if(n < 2)
			return false;
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}

}
