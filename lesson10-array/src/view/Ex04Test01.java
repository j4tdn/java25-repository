package view;

public class Ex04Test01 {

	// Hàm kiểm tra số nguyên tố
	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// Hàm tìm số chẵn
	public static void findEven(int[] arr) {
		System.out.print("Các số chẵn: ");
		for (int x : arr) {
			if (x % 2 == 0)
				System.out.print(x + " ");
		}
		System.out.println();
	}

	// Hàm tìm số nguyên tố
	public static void findPrime(int[] arr) {
		System.out.print("Các số nguyên tố: ");
		for (int x : arr) {
			if (isPrime(x))
				System.out.print(x + " ");
		}
		System.out.println();
	}

	// Hàm tìm bội của 5
	public static void findMultipleOf5(int[] arr) {
		System.out.print("Các số bội của 5: ");
		for (int x : arr) {
			if (x % 5 == 0)
				System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 10, 15, 17, 20, 23 };
		findEven(arr);
		findPrime(arr);
		findMultipleOf5(arr);
	}
}