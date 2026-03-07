package utils;
import java.util.Random;

public class ArrayUtils {

    public static int[] generateArray(int n) {
        Random rd = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(41) + 10;
        }

        return arr;
    }
    
    public static int[] removeDuplicate(int[] arr) {

		int countUnique = 0;

		for (int i = 0; i < arr.length; i++) {
			int count = 0;

			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}

			if (count == 1) {
				countUnique++;
			}
		}

		int[] result = new int[countUnique];
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			int count = 0;

			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}

			if (count == 1) {
				result[index++] = arr[i];
			}
		}

		return result;
	}
    public static void compareAverage(int[] arr) {

		int half = arr.length / 2;

		double sumFirst = 0;
		double sumLast = 0;

		for (int i = 0; i < half; i++) {
			sumFirst += arr[i];
		}

		for (int i = half; i < arr.length; i++) {
			sumLast += arr[i];
		}

		double avg1 = sumFirst / half;
		double avg2 = sumLast / half;

		System.out.println("trung binh nua dau = " + avg1);
		System.out.println("trung binh nua cuoi = " + avg2);

		if (avg1 > avg2) {
			System.out.println("nua dau lon hon");
		} else if (avg1 < avg2) {
			System.out.println("nua cuoi lon hon");
		} else {
			System.out.println("bang nhau");
		}
	}
    public static int thirdLargest(int[] arr) {

		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;

		for (int num : arr) {

			if (num > first) {
				third = second;
				second = first;
				first = num;
			} else if (num > second && num != first) {
				third = second;
				second = num;
			} else if (num > third && num != second && num != first) {
				third = num;
			}
		}

		return third;
	}

}