package view;

public class Ex05HappyNumber {
	
	private static int DEFAULT_CAPACITY = 1000;
	
	public static void main(String[] args) {
		System.out.println("Số hạnh phúc: " + isHappyNumber(115));
	}
	
	private static boolean isHappyNumber(int number) {
		// Hôm sau xử lý trong bài mảng
		int[] storage = new int[DEFAULT_CAPACITY];
		int counter = 0;
		while(number != 1 && !isExists(number, storage, counter)) {
			System.out.println(number);
			storage[counter++] = number;
			number = sumOfSquares(number);
		}
		System.out.println(number);
		return number == 1;
	}
	
	private static int sumOfSquares(int number) {
		int sum = 0;
		while(number > 0) {
			int digit = number % 10;
			sum += digit * digit;
			number /= 10;
		}
		return sum;
	}
	
	private static boolean isExists(int number, int[] storage, int currentLength) {
		for (int i = 0 ; i < currentLength; i++) {
			if (number == storage[i]) {
				return true;
			}
		}
		return false;
	}
	
}
