package assignments;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		if(isHappyNumber(n)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}

	}

	private static boolean isHappyNumber(int n) {

		long tmp = n;
		while (tmp >= 10) {
			long sum = 0;
			while (tmp != 0) {
				sum += binPow(tmp % 10, 2);
				tmp /= 10;
			}
			tmp = sum;
		}
		
		return tmp == 1;
	}

	public static long binPow(long a, long b) {
		long res = 1;
		while (b != 0) {
			if ((b & 1) == 1) {
				res *= a;
			}
			a *= a;
			b >>= 1;
		}
		return res;
	}
}
