package view;

import java.util.Scanner;

/*
  Viết hàm kiểm tra một số có phải là số đặc biệt không. Biết rằng nếu
tổng tất cả các số nguyên từ 1 đến n bằng S thì S là số đặc biệt.
  */
public class Ex02IsSpecialNumber {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		System.out.println("Nhập số cần kiểm tra: ");
		int S = ip.nextInt();

		if (isSpecialNumber(S)) {
			System.out.println(S + "là số đặc biệt");

		} else {
			System.out.println(S + "không phải là số đặc biệt");
		}

	}

	private static boolean isSpecialNumber(int s) {
		if (s < 1)
			return false;
		int i = 1;
		while (true) {
			int sum = i * (i + 1) / 2;

			if (sum == s) {
				return true;
			}
			if (sum > s) {
				return false;
			}
			i++;
		}

	}

}
