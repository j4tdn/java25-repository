package lab2;

import java.util.Random;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.printf("Nhập vào độ dài của mảng: ");
		String text = sc.nextLine();
		int length = 0;
		while (true) {
			int count = 0;
			if (isNumber(text)) {
				length = Integer.parseInt(text);
				break;
			}
			if (count++ == 3) {
				break;
			}

		}
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(5, 101);
		}

		printArrayMain(arr);
		sc.close();

	}

	private static boolean isNumber(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static void printArray(int[] arr, int count) {
		for (int i = 0; i < count; i++) {
			System.out.printf("%d", arr[i]);
			if (i < count - 1) {
				System.out.printf(",");
			}
		}
	}

	private static void printArrayMain(int[] arr) {
		int[] multipleOf7 = new int[arr.length];
		int[] multipleOf5 = new int[arr.length];
		int[] middle = new int[arr.length];
		int countOf7 = 0;
		int countOf5 = 0;
		int countOfMid = 0;
		for (int x : arr) {
			if (x % 7 == 0) {
				multipleOf7[countOf7++] = x;
			} else if (x % 5 == 0) {
				multipleOf5[countOf5++] = x;
			} else
				middle[countOfMid++] = x;
		}
		printArray(multipleOf7, countOf7);
		System.out.printf("|");
		printArray(multipleOf5, countOf5);
		System.out.printf("|");
		printArray(middle, countOfMid);

	}

}
