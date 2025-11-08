package ex02;

import java.util.Scanner;

public class SoDacBiet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so n: ");
		int n = sc.nextInt();
		if(isSpecialNumber(n)) {
			System.out.println("Day la so dac biet!!");
		}else {
			System.out.println("Kh phai so dac biet!!");
		}
		
	}
	public static boolean isSpecialNumber(int n) {
		int tong = 0;
		for(int i =0; i<=n; i++) {
			tong = tong + i;
			if(tong == n) {
				return true;
			}else if(tong > n){
				return false;
			}
		}
		return false;
		
		
	}
}
