package utils;

public class MathUtils {
	
	private MathUtils() {
	}
	
	public static Long fact(int n) {
		if (n < 2) {
			return null;
		}
		long f = n;
		while (n >= 2) {
			f *= --n;
		}
		return f;
	}
	
	public static boolean isPrime(long number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
