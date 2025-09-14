package Exercise;

import java.math.BigInteger;
import java.util.Random;

public class Ex04SumFactorial {

	public static void main(String[] args) {

		/*
		 * Bài 4: Tính tổng giai thừa của 4 số nguyên dương S = a! + b! + c! + d! Trong
		 * đó a, b, c, d là các số nguyên ngẫu nhiên từ 10 đến 20.
		 */

		Random random = new Random();

		// Sinh ngẫu nhiên 4 số nguyên trong đoạn [10, 20]
		int a = random.nextInt(11) + 10; // [10, 20]
		int b = random.nextInt(11) + 10;
		int c = random.nextInt(11) + 10;
		int d = random.nextInt(11) + 10;

		// Tính giai thừa của từng số bằng BigInteger
		BigInteger factA = factorial(a);
		BigInteger factB = factorial(b);
		BigInteger factC = factorial(c);
		BigInteger factD = factorial(d);

		// Tính tổng S = a! + b! + c! + d!
		BigInteger sum = factA.add(factB).add(factC).add(factD);

		// In kết quả
		System.out.println("Các số được chọn: a=" + a + ", b=" + b + ", c=" + c + ", d=" + d);
		System.out.println("Kết quả:");
		System.out.println("S = " + a + "! + " + b + "! + " + c + "! + " + d + "!");
		System.out.println("S = " + sum);
	}

	// Hàm tính giai thừa dùng BigInteger
	private static BigInteger factorial(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i)); // nhân dồn lên.
		}
		return result;
	}
}
