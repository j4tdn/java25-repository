package lesson02_HuynhVuTrucPhuong_DataStructure;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		BoiChungSo2();
	}
	public static void BoiChungSo2() {
		Scanner sc = new Scanner(System.in);
		int n =0 ;
		boolean hople = false;
		for(int i = 0;i<5;i++) {
			System.out.println("Nhap so nguyen duong n: ");
			String a = sc.nextLine();
			try {
				n = Integer.parseInt(a);
				if(n>0) {
					hople = true;
					break;
				}
				else {
					System.out.println("N phai la so nguyen duong");
				}
			}catch(NumberFormatException e) {
				System.out.println("Khong hop le vui long nhap lai so nguyen duong: ");
			}
		}
		if(hople) {
			if( n%2 == 0 ) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}else {
			System.out.println("Nhap loi sai qua 5 lan");
		}
		sc.close();
	}
}
