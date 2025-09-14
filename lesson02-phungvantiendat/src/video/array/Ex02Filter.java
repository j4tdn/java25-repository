package video.array;

import java.util.Arrays;

/**
 * 1. Tim nhung phan tu le trong mang so nguyen
 * 		Input: Mang
 *      Output: Mang so le
 */

public class Ex02Filter {

	public static void main(String[] args) {
		int[] numbers = {23,25,16,33,66,5};
		System.out.println(Arrays.toString(findOddNumbers(numbers)));
	}

	private static int[] findOddNumbers(int[] elements) {
		int cnt = 0;
		for(int element: elements) {
			if(element % 2 != 0) {
				++cnt;
			}
		}
		int[] result = new int [cnt];
		int i = 0;
		for(int element : elements) {
			if(element % 2 != 0) {
				result[i++] = element;
			}
		}
		return result;
	}
}
