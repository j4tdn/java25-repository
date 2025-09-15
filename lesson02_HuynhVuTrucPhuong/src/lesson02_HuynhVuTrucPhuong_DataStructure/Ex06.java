package lesson02_HuynhVuTrucPhuong_DataStructure;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		a = nhapso("a:",sc);
		b = nhapso("b:",sc);
		c = nhapso("c:",sc);
		int max = Math.max(a,Math.max(b, c));
		int min = Math.min(a,Math.min(b, c));
		System.out.println("Max: "+max);
		System.out.println("Min: "+min);
		
	}
	public static int nhapso(String x,Scanner sc) {
		int n;
		while(true) {
			System.out.println("Nhap "+x+":");
			if(!sc.hasNextInt()) {
				System.out.println("Loi vui long nhap so nguyen");
				sc.next();
				continue;
				}
			n = sc.nextInt();
			if(n<0||n>=20) {
				System.out.println("Loi so phai trong khoang [0,20)");
				continue;
			}
			break;
			}
		return n;
	}
}
