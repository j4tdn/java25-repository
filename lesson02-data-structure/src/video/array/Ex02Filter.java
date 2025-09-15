package video.array;

import java.util.Arrays;

public class Ex02Filter {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6 };
		int[] result = findOddNumbers(numbers);
		System.out.println(Arrays.toString(result));

	}

	private static int[] findOddNumbers(int[] elements) {
		int[] oldArray = new int[elements.length];

		int count = 0;
		for (int e : elements) {
			if (e % 2 != 0) {
				oldArray[count] = e;
				count++;

			}
		}
		int[] result = new int[count];
		for (int i = 0; i < count; i++) {
			result[i] = oldArray[i];
		}
		return result;

	}

}
