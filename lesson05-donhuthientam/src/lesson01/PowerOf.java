package lesson01;

public class PowerOf {
	public static void main(String[] args) {
		System.out.println(isPowerOf(8, 2));
		System.out.println(isPowerOf(2, 8));
		System.out.println(isPowerOf(20, 4));

	}

	private static boolean isPowerOf(int a, int b) {
		int check = b;
		while (check < a) {
			check *= b;
		}
		if (check == a) {
			return true;
		}
		while (check < b) {
			check *= a;
		}
		if (check == b) {
			return true;
		}

		return false;

	}
}
