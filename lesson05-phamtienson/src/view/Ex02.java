package view;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhập n: ");
		
		int n = ip.nextInt();
		int[] a = new int[n-1];
		System.out.println("Nhập " + (n-1) + " phần tử của mảng");
		
		for (int i = 0; i< a.length; i++) {
			a[i] = ip.nextInt();
		}
		
		int miss = -1;
		for (int i=1; i<=n; i++) {
			boolean number = false;
			for (int j = 0; j< a.length; j++) {
				if (a[j] == i) {
					number = true;
					break;
				}
			}
			if (number = false) {
				miss = i;
				break;
			}
		}
		System.out.println("Số bị th iếu là: " + miss);
		ip.close();
	}
      
}
