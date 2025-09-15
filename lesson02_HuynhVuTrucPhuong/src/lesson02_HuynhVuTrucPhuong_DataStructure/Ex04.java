package lesson02_HuynhVuTrucPhuong_DataStructure;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap a");
		int a = sc.nextInt();
		System.out.println("Nhap b");
		int b = sc.nextInt();
		System.out.println("Nhap c");
		int c = sc.nextInt();
		System.out.println("Nhap d");
		int d = sc.nextInt();
		int sum= giaithua(a)+giaithua(b)+giaithua(c)+giaithua(d);
		System.out.println("SUM = "+sum);
		sc.close();
	}
	public static int giaithua(int n) {
		if(n==0 || n==1) {
			return 1;
		}else {
			return n*giaithua(n-1);
		}
	}
	
	
	
}
