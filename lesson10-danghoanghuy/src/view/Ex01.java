package view;

import java.util.Arrays;
import java.util.Random;

public class Ex01 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		
		int n = rd.nextInt(9) + 1;
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = rd.nextInt(41) + 10;
		}
		
		System.out.println("Mang a: " + Arrays.toString(a));
		
		filterUnique(a);
		
		System.out.println("\n====================");
		
		compareFirstLast(a);
		
		System.out.println("\n====================");
		
		findThirdLargest(a);
		
	}
	
	private static void filterUnique(int[] a) {
		System.out.print("Loai bo phan tu trung: ");
		for(int i = 0; i < a.length; i++) {
			int count = 0;
			for(int j = 0; j < a.length; j++) {
				if(a[i] == a[j]) {
					count++;
				}
			}
			if(count == 1) {
				System.out.print(a[i] + " ");
			}
		}
	}
	
	private static void compareFirstLast(int[] a) {
		System.out.print("So sanh 2 nua: ");
		int half = a.length/2;
		int sumFirst = 0;
		int sumLast = 0;
		
		for(int i = 0; i < half; i++) {
			sumFirst += a[i];
			sumLast += a[a.length - i -1];
		}
		
		double avgFirst = sumFirst/half;
		double avgLast = sumLast/half;
		
		if(avgFirst > avgLast) System.out.print("Nua dau lon hon");
		if(avgFirst < avgLast) System.out.print("Nua sau lon hon");
	}
	
	private static void findThirdLargest(int[] a) {
		Arrays.sort(a);
		int count = 0;
		int rs = 0;
		
		for(int i = a.length - 2; i >= 0; i--) {
			if(a[i] != a[i+1]) {
				count++;
			}
			if(count == 2) {
				rs = a[i];
			}
		}
		System.out.println("So lon thu 3 la: " + rs);
		
	}
}
