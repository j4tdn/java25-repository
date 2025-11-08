package view;

import java.util.Scanner;

public class Ex02 {

	/*
			 Bài 2 (20đ):Viết hàm kiểm tra một số có phải là số đặc biệt không. Biết rằng nếu
		tổng tất cả các số nguyên từ 1 đến n bằng S thì S là số đặc biệt. Ví dụ
		▪ 1 → 1
		▪ 3 → 1 + 2
		▪ 6 → 1 + 2 + 3
		▪ 10 → 1 + 2 + 3 + 4
		Method signature: boolean isSpecialNumber(...)
	 */
	
	public static void main(String[] args) {
	
		Scanner sc  = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(isSpecialNumber(n)) {
			System.out.println("La so dac biet");
		}
		else System.out.println("Khong phai so dac biet");
		
		sc.close();
	}
	
	private static boolean isSpecialNumber(int n) {
		int sum = 0;
		
		if(n == 1) {
			return true;
		}
		
		for(int i = 0; sum < n; i++) {
			sum += i;
		}
		
		if(sum != n) {
			return false;
		}
		return true;
	}
}
