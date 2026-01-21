package view;

public class Ex04Test01 {

	/*
	 * Cho một mảng số nguyên gồm N phần tử Viết chương trình Tìm các phần tử chẵn
	 * trong mảng Tìm các phần tử là số nguyên tố trong mảng Tìm các phần tử là bội
	 * của 5 trong mảng
	 *
	 * 1: Mỗi yêu cầu viết 1 hàm để xử lý 2: Viết duy nhất 1 hàm để xử lý cho 3 yêu
	 * cầu
	 */
	public static void timSoChan(int[] a) {
		System.out.print("Cac so chan: ");
		for (int x : a) {
			if (x % 2 == 0) {
				System.out.print(x + " ");
			}
		}
		System.out.println();
	}

	public static boolean laSoNguyenTo(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void timSoNguyenTo(int[] a) {
		System.out.print("Cac so nguyen to: ");
		for (int x : a) {
			if (laSoNguyenTo(x)) {
				System.out.print(x + " ");
			}
		}
		System.out.println();
	}

	public static void timBoi5(int[] a) {
		System.out.print("Cac so la boi cua 5: ");
		for (int x : a) {
			if (x % 5 == 0) {
				System.out.print(x + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 7, 10, 12, 15, 17, 20 };

		timSoChan(arr);
		timSoNguyenTo(arr);
		timBoi5(arr);
	}

}
