package Bai02;

public class Bai2 {
	
	public static int getMissingNumber(int[] arr, int n) {
		int sum = n * (n + 1) / 2;
		for(int x : arr) {
			sum = sum - x;
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] a = {3, 2, 1, 6, 5};
		System.out.println(getMissingNumber(a, 6));
	}

}
