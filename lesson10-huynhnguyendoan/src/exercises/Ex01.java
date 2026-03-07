package exercises;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex01 {

	public static void main(String[] args) {

		int[] arr = ArrayUtils.generateArray(8);

		System.out.println("Array: " + Arrays.toString(arr));

		int[] unique = ArrayUtils.removeDuplicate(arr);
		System.out.println("bo phan tu trung: " + Arrays.toString(unique));

		ArrayUtils.compareAverage(arr);

		int third = ArrayUtils.thirdLargest(arr);
		System.out.println("So lon thu 3 trong mang: " + third);
	}
}