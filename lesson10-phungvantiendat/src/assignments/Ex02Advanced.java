package assignments;

import java.util.Arrays;

import bean.Pair;

public class Ex02Advanced {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };

		Pair[] pairs = statisticRowAndCol(arr);

		for (int i = 0; i < pairs.length; ++i) {
			int rowIndex = pairs[i].getValue();
			int colIndex = pairs[i].getCount();

			markRowZero(arr, rowIndex);

			markColZero(arr, colIndex);
		}

		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void markRowZero(int[][] arr, int rowIndex) {
		for (int i = 0; i < arr[rowIndex].length; ++i) {
			arr[rowIndex][i] = 0;
		}
	}

	private static void markColZero(int[][] arr, int colIndex) {
		for (int i = 0; i < arr.length; ++i) {
			arr[i][colIndex] = 0;
		}
	}

	private static Pair[] statisticRowAndCol(int[][] arr) {
		Pair[] pairs = new Pair[arr.length];

		int counter = 0;
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				if (arr[i][j] == 0) {
					pairs[counter++] = new Pair(i, j);
				}
			}
		}

		return Arrays.copyOfRange(pairs, 0, counter);
	}

}
