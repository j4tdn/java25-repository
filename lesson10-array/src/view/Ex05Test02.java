package view;

public class Ex05Test02 {
	/*
	 * Cho một mảng số nguyên gồm N phần tử Viết chương trình + Tìm tổng các phần tử
	 * trong mảng + Tìm tích các phần tử trong mảng + Tìm giá trị lớn nhất trong
	 * mảng + Tìm giá trị nhỏ nhất trong mảng
	 * 
	 * 1: Mỗi yêu cầu viết 1 hàm để xử lý 2: Viết duy nhất 1 hàm để xử lý cho 4 yêu
	 * cầu trên
	 */
	public static void main(String[] args) {

		int[] arr = { 2, 4, 6, 1, 9, 3 };

		System.out.println("Mang:");
		for (int x : arr) {
			System.out.print(x + " ");
		}

		System.out.println("\n\n--- cách 1: Mỗi yêu cầu viết 1 hàm ---");
		System.out.println("Tổng = " + tinhTong(arr));
		System.out.println("Tích = " + tinhTich(arr));
		System.out.println("Giá trị lớn nhất = " + timMax(arr));
		System.out.println("Giá trị nhỏ nhất = " + timMin(arr));

		System.out.println("\n--- Cách 2: Một hàm xử lý tất cả ---");
		xuLyTatCa(arr);
	}

	public static int tinhTong(int[] arr) {
		int tong = 0;
		for (int x : arr) {
			tong += x;
		}
		return tong;
	}

	public static int tinhTich(int[] arr) {
		int tich = 1;
		for (int x : arr) {
			tich *= x;
		}
		return tich;
	}

	public static int timMax(int[] arr) {
		int max = arr[0];
		for (int x : arr) {
			if (x > max) {
				max = x;
			}
		}
		return max;
	}

	public static int timMin(int[] arr) {
		int min = arr[0];
		for (int x : arr) {
			if (x < min) {
				min = x;
			}
		}
		return min;
	}

	public static void xuLyTatCa(int[] arr) {

		int tong = 0;
		int tich = 1;
		int max = arr[0];
		int min = arr[0];

		for (int x : arr) {
			tong += x;
			tich *= x;

			if (x > max)
				max = x;
			if (x < min)
				min = x;
		}

		System.out.println("Tổng = " + tong);
		System.out.println("Tích = " + tich);
		System.out.println("Giá trị lớn nhất = " + max);
		System.out.println("Giá trị nhỏ nhất = " + min);
	}
}
