package view;

public class Ex02 {

	public static int sumOfSquares(int num) {
		int sum = 0;
		while (num > 0) {
			int digit = num % 10;
			sum += digit * digit;
			num /= 10;
		}
		return sum;
	}

	public static boolean isHappy(int num) {
		int slow = num;
		int fast = num;

		do {
			slow = sumOfSquares(slow);
			fast = sumOfSquares(sumOfSquares(fast));
		} while (slow != fast);

		return slow == 1;
	}

	public static void main(String[] args) {
		int[] testNumbers = { 1, 7, 10, 13, 19, 23, 28, 2, 3, 4 };

		for (int num : testNumbers) {
			if (isHappy(num)) {
				System.out.println(num + " is a Happy Number");
			} else {
				System.out.println(num + " is an Unhappy Number");
			}
		}
	}

}
