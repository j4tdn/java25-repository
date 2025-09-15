package lesson02_HuynhVuTrucPhuong_DataStructure;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap n:");
		int n = sc.nextInt();
		System.out.println(n+"!="+Giaithua(n));
		sc.close();
		
	}
	public static int Giaithua(int n) {
		if(n==0 ||n==1) {
			return 1;
		}else {
			return n*Giaithua(n-1);
		}
	}
	
}
	
