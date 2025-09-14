package lesson2.assignments;

public class Ex04 {

	public static void main(String[] args) {
		long a = giaiThua(getRandomNumber());
		long b = giaiThua(getRandomNumber());
		long c = giaiThua(getRandomNumber());
		long d = giaiThua(getRandomNumber());


		System.out.println("a = " + a + " b = " + b + " c = " + c + " d = " + d);

		System.out.println("Tong giai thua: " + tongGiaiThua(a, b, c, d));
	}

	private static int getRandomNumber() {
		int max = 20;
		int min = 10;
		int range = max - min + 1;

		int rand = (int) (Math.random() * range) + min;
		return rand;
	}

	private static long giaiThua(int n) {
		long res = 1;
		for (int i = 1; i <= n; ++i) {
			res *= i;
		}
		return res;
	}

	private static long tongGiaiThua(long a, long b, long c, long d) {
		return a + b + c + d;
	}

}
