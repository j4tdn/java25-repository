package test01;

public class Ex02SpecialNumber {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 5, 6, 8, 10, 21, 22, 28 };
		for (int number: numbers) {
			System.out.printf("isSpecialNumber(%s) --> %s\n", number, isSpecialNumber(number));
		}
		
	}

	private static boolean isSpecialNumber(int number) {
		if (number < 1) {
			return false;
		}
		int sum = 0, i = 1;
		while (sum < number) {
			sum += i++;
		}
		return sum == number;
	}

}
