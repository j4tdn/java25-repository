
//Bài 2 (20đ):Viết hàm kiểm tra một số có phải là số đặc biệt không. Biết rằng nếu
//tổng tất cả các số nguyên từ 1 đến n bằng S thì S là số đặc biệt. Ví dụ
//▪ 1 → 1
//▪ 3 → 1 + 2
//▪ 6 → 1 + 2 + 3
//▪ 10 → 1 + 2 + 3 + 4
//Method signature: boolean isSpecialNumber(...)

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Nhập vào số bạn muốn kiểm tra: ");
		int n = sc.nextInt();
		if (isSpecialNumber(n)) {
			System.out.println("Đây là số đặc biệt");
		}

		sc.close();

	}

	public static boolean isSpecialNumber(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			sum += i;
			if (sum == n) {
				break;
			}
		}
		return sum == n;

	}
}
