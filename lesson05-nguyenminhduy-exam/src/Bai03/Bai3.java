package Bai03;

public class Bai3 {
	
	public static void main(String[] args) {
		int[] a = {2, 3, 4};
		int x = a[0];
		for(int i = 1; i < a.length; i++) {
			while( x % a[i] != 0) {
				x++;
			}
		}
		System.out.println("BCNN: " + x);
	}

}
