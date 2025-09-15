package homeword;

import java.util.Random;

/**
 * Bài 4: Viết chương trình tính tổng giải thừa của các số nguyên dương S = a!
 * +b! + c! + d! Biết rằng a,b,c,d là các số nguyên ngẫu nhiên từ 10 đến 20 →
 * [10, 20]
 */
public class task4 {
	public static void main(String[] args) {
		Random rd = new Random();
		int a = rd.nextInt(10, 20);
		int b = rd.nextInt(10, 20);
		int c = rd.nextInt(10, 20);
		int d = rd.nextInt(10, 20);
		System.out.println("a: " + a);
		System.out.println("b " + b);
		System.out.println("c: " + c);
		System.out.println("d: " + d);
		System.out.println("==========================");

		System.out.println("Lũy thừa của a là: " + luythua(a));
		System.out.println("Lũy thừa của b là: " + luythua(b));
		System.out.println("Lũy thừa của c là: " + luythua(c));
		System.out.println("Lũy thừa của d là: " + luythua(d));
		int total = luythua(a) + luythua(b) + luythua(c) + luythua(d);
		System.out.println("Tổng: " + total);
	}

	private static int luythua(int n) {
		int b = 1;
		for (int i = 2; i <= n; i++) {
			b *= i;
		}
		return b;
	}

}
