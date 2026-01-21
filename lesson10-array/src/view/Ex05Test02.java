package view;

public class Ex05Test02 {

	/*
	 * Cho một mảng số nguyên gồm 5 phần tử Viết chương trình + Tìm tổng các phần tử
	 * trong mảng + Tìm tích các phần tử trong mảng + Tìm giá trị lớn nhất + Tìm giá
	 * trị nhỏ nhất
	 *
	 * Yêu cầu 1: Tạo mỗi hàm thực hiện một chức năng Yêu cầu 2: Tạo một hàm để thực
	 * hiện tất cả các chức năng
	 */

	public static int tinhTong(int[] a) {
		int tong = 0;
		for (int x : a) {
			tong += x;
		}
		return tong;
	}

	public static int tinhTich(int[] a) {
		int tich = 1;
		for (int x : a) {
			tich *= x;
		}
		return tich;
	}

	public static int timMax(int[] a) {
		int max = a[0];
		for (int x : a) {
			if (x > max)
				max = x;
		}
		return max;
	}

	public static int timMin(int[] a) {
		int min = a[0];
		for (int x : a) {
			if (x < min)
				min = x;
		}
		return min;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 7, 5 };

		System.out.println("Tong = " + tinhTong(arr));
		System.out.println("Tich = " + tinhTich(arr));
		System.out.println("Max = " + timMax(arr));
		System.out.println("Min = " + timMin(arr));
	}

}
