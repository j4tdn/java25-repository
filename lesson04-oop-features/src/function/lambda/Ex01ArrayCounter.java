package function.lambda;

public class Ex01ArrayCounter {
	
	public static void main(String[] args) {
		// Viết chương trình đếm s�? lượng các phần tử l�?
		// S�? chẵn
		// S�? lẻ
		// S�? nguyên t�?
		// S�? chia hết cho 5
		int[] numbers = {1, 5, 2, 8, 10, 20, 7, 18, 25};
		
		System.out.println("S�? chẵn: " + countEvenElements(numbers));
		System.out.println("S�? lẻ: " + countOddElements(numbers));
		System.out.println("S�? nguyên t�?: " + countPrimeElements(numbers));
		System.out.println("S�? chia hết cho 5: " + countM5Elements(numbers));
		
		System.out.println("\n-------------------\n");
		
		System.out.println("S�? chẵn: " + countElements(numbers, nb -> nb % 2 == 0));
		System.out.println("S�? lẻ: " + countElements(numbers, nb -> nb % 2 != 0));
		System.out.println("S�? nguyên t�?: " + countElements(numbers, nb -> isPrime(nb)));
		System.out.println("S�? chia hết cho 5: " + countElements(numbers, nb -> nb % 5 == 0));
		
	}
	
	// Từ các logic khác nhau
	// Tìm công thức chung (strategy): input v�? output
	
	// B�?i toán: boolean ?(int element) đặt tên h�?m gì cũng được(logic)
	// Tạo interface chứa h�?m trừu tượng như công thức chung đó
	
	// Tạo method dưới dạng strategy pattern có tham s�? l�? @FI đó
	// Trong method, lúc compile thì sẽ chưa biết h�?m trừu tượng sẽ l�?m gì
	// Lúc gọi method mới truyền phần thực thi v�?o
	
	private static int countElements(int[] elements, NumberTest nTest) {
		int count = 0;
		for (int element: elements) {
			if (nTest.testing(element)) {
				count++;
			}
		}
		return count;
	}
	
	// Đếm s�? chẵn
	private static int countEvenElements(int[] elements) {
		int count = 0;
		for (int element: elements) {
			if (element % 2 == 0) {
				count++;
			}
		}
		return count;
	}
	
	// Đếm s�? lẻ
	private static int countOddElements(int[] elements) {
		int count = 0;
		for (int element: elements) {
			if (element % 2 != 0) {
				count++;
			}
		}
		return count;
	}
	
	// strategy pattern
	// lý thuyết
	// b�?i tập
	
	// Đếm s�? nguyên t�?
	private static int countPrimeElements(int[] elements) {
		int count = 0;
		for (int element: elements) {
			if (isPrime(element)) {
				count++;
			}
		}
		return count;
	}
	
	// Đếm s�? chia hết cho 5
	private static int countM5Elements(int[] elements) {
		int count = 0;
		for (int element: elements) {
			if (element % 5 == 0) {
				count++;
			}
		}
		return count;
	}
	
	private static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}