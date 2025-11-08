package ex02;

import java.util.Scanner;

public class SpecialNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số cần kiểm tra: ");
		int n = sc.nextInt();
		
		boolean kq = isSpecialNumber(n);
		if(kq) {
			System.out.println(n + " là số đặc biệt");
		}else {
			System.out.println(n + " không phải số đặc biệt");
		}
		
	}
	
	static boolean isSpecialNumber(int n) {
		int tong = 0;
		for(int i = 1; i <= n; i++) {
			tong  = tong + i;
			if(tong == n)
				return true;
			if(tong > n)
				return false;
		}
		return false;
	}
}
