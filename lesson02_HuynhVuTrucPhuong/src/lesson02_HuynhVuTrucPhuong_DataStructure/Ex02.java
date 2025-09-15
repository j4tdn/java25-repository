package lesson02_HuynhVuTrucPhuong_DataStructure;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		LuyThuaCua2();
	}
	public static void LuyThuaCua2() {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		boolean hople = false ;
		for (int i=0;i<5;i++) {
			System.out.println("Nhap so nguyen duong n: ");
			String a = sc.nextLine();
			try {
				n = Integer.parseInt(a);
				if(n>0) {
					hople = true; 
					break;
				}
				else {
					System.out.println("n phai la so nguyen duong");
				}
				
			}
			catch(NumberFormatException e) {
				System.out.println("Khong hop le hay nhap lai so nguyen duong: ");
			}
		}
		if(hople) {
			while(n%2 == 0){
				n = n/2;
			}
			if(n == 1)System.out.println("true");
			else System.out.println("false");
		}else {
			System.out.println("Ban da nhap sai qua 5 lan ");
		}
	}
}
