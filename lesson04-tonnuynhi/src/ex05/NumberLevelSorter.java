package ex05;

public class NumberLevelSorter {

	public static int calculateLevel(int number) {
		if (number <= 0) {
			return 0;
		}
		int level = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				level++;
			}
		}
		return level;
	}

	public static void sortByLevel(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {

				int level1 = calculateLevel(arr[j]);
				int level2 = calculateLevel(arr[j + 1]);

				if (level1 > level2) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + (i < arr.length - 1 ? " " : ""));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] numbers = { 8, 5, 9, 20 };

		System.out.println("--- BÀI TẬP TÌM LEVEL VÀ SẮP XẾP ---");
		System.out.print("Mảng ban đầu: ");
		printArray(numbers);
		sortByLevel(numbers);

		System.out.print("Mảng sau khi sắp xếp theo level tăng dần: ");
		printArray(numbers);
	}
}