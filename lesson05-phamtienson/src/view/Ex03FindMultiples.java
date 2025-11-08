package view;

import java.util.Scanner;

public class Ex03FindMultiples {
	public int agreement(int a, int b) {
		while (b!=0) {
			int temp = b;
			b = a/b;
			a = temp;
		}
		return a;
	}
	public int multiple(int a, int b) {
		return (a*b)/ agreement(a,b);
	}
	public int getLeastCommonMultiple(int[] a) {
		int multiples = a[0];
		for (int i = 1; i <a.length;  i++) {
			multiples = multiple(multiples, a[i]);
		}
		return multiples;
	}
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhập số lượng phần tử: ");
		int n = ip.nextInt();
		
		int[] a= new int[n];
		System.out.println("Nhập " + n + " phần tử của mảng");
		for (int i = 0; i<n ; i++) {
			a[i] = ip.nextInt();
		}
		Ex03FindMultiples ex03 = new Ex03FindMultiples();
		int resufl = ex03.getLeastCommonMultiple(a);
		System.out.println("Bội chung nhỏ nhất của mảng là: "+ resufl);
		ip.close();
		
	}

}
