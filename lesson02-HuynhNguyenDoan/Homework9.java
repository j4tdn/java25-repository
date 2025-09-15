package homework;

public class Homework9 {
	public static void main(String[] args) {
		int number = 2;
		int primeNumberCount = 0;
		do {
			if (isPrimeNumber(number)) {
				primeNumberCount++;
			}
			if (primeNumberCount == 200) {
				System.out.println("So nguyen to thu 200 la " + number);
				break;
			}
			number++;

		} while (true);
	}

	private static boolean isPrimeNumber(int number) {
		if (number == 2) {
			return true;
		}
		if (number % 2 == 0) {
			return false;
		}
		for (int i = 2; i < number; i++ ) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
