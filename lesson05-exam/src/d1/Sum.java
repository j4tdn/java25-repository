package d1;

import java.util.Arrays;

public class Sum {
	public static void main(String[] args) {
		int[] a = { 1, 5, 8, 9, 2, 5, 9 };
		System.out.println("Tong cac phan tu khong trung nhau: " + Sum(a));
	}

	public static int Sum(int[] a) {
		if (a == null || a.length == 0)
			return 0;
		int[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		int sum = 0;
		int prev = Integer.MIN_VALUE;
		for (int x : b) {
			if (x != prev) {
				sum += x;
				prev = x;
			}
		}
		return sum;

	}
}
