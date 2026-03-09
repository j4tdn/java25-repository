import java.util.Random;
import java.util.Scanner;

public class Ex01Array {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		System.out.print("Nhập n (<10): ");
		int n = sc.nextInt();

		int[] arr = new int[n];

		System.out.println("Mảng ngẫu nhiên:");

		for (int i = 0; i < n; i++) {
			arr[i] = rd.nextInt(41) + 10;
			System.out.print(arr[i] + " ");
		}

		System.out.println();

		System.out.print("Các phần tử không trùng nhau: ");
		for (int i = 0; i < n; i++) {
			boolean duplicate = false;
			for (int j = 0; j < n; j++) {
				if (i != j && arr[i] == arr[j]) {
					duplicate = true;
				}
			}
			if (!duplicate) {
				System.out.print(arr[i] + " ");
			}
		}

		System.out.println();

		int half = n / 2;
		double sum1 = 0, sum2 = 0;

		for (int i = 0; i < half; i++) {
			sum1 += arr[i];
		}

		for (int i = half; i < n; i++) {
			sum2 += arr[i];
		}

		double avg1 = sum1 / half;
		double avg2 = sum2 / (n - half);

		System.out.println("Trung bình nửa đầu: " + avg1);
		System.out.println("Trung bình nửa cuối: " + avg2);

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println("Số lớn thứ 3: " + arr[2]);
	}
}