package view;

public class Ex04Test01 {

	static void timSoChan(int[] arr) {
		System.out.print("Các số chẵn: ");
		for (int x : arr) {
			if (x % 2 == 0) {
				System.out.print(x + " ");
			}
		}
		System.out.println();
	}

	static boolean laSoNguyenTo(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static void timSoNguyenTo(int[] arr) {
		System.out.print("Các số nguyên tố: ");
		for (int x : arr) {
			if (laSoNguyenTo(x)) {
				System.out.print(x + " ");
			}
		}
		System.out.println();
	}

	static void timBoi5(int[] arr) {
		System.out.print("Các số là bội của 5: ");
		for (int x : arr) {
			if (x % 5 == 0) {
				System.out.print(x + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		/*
		 * Cho một mảng số nguyên gồm N phần tử Viết chương trình + Tìm các phần tử chẵn
		 * trong mảng + Tìm các phần tử là số nguyên tố trong mảng + Tìm các phần tử là
		 * bội của 5 trong mảng
		 * 
		 * 1: Mỗi yêu cầu viết 1 hàm để xử lý 2: Viết duy nhất 1 hàm để xử lý cho 3 yêu
		 * cầu
		 */
		int[] arr = { 3, 5, 8, 10, 13, 15, 20, 7, 9 };

		timSoChan(arr);
		timSoNguyenTo(arr);
		timBoi5(arr);
	}
}
