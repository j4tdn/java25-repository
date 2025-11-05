package function.lambda;

public class Ex01ArrayCounter {
	
	public static void main(String[] args) {
		// Viết chương trình đếm số lượng các phần tử là
		// Số chẵn
		// Số lẻ
		// Số nguyên tố
		// Số chia hết cho 5
		int[] numbers = {1, 5, 2, 8, 10, 20, 7, 18, 25};
		
		System.out.println("Số chẵn: " + countEvenElements(numbers));
		System.out.println("Số lẻ: " + countOddElements(numbers));
		System.out.println("Số nguyên tố: " + countPrimeElements(numbers));
		System.out.println("Số chia hết cho 5: " + countM5Elements(numbers));
		
		System.out.println("\n-------------------\n");
		
		System.out.println("Số chẵn: " + countElements(numbers, nb -> nb % 2 == 0));
		System.out.println("Số lẻ: " + countElements(numbers, nb -> nb % 2 != 0));
		System.out.println("Số nguyên tố: " + countElements(numbers, nb -> isPrime(nb)));
		System.out.println("Số chia hết cho 5: " + countElements(numbers, nb -> nb % 5 == 0));
		
	}
	
	// Từ các logic khác nhau
	// Tìm công thức chung (strategy): input và output
	
	// Bài toán: boolean ?(int element) đặt tên hàm gì cũng được(logic)
	// Tạo interface chứa hàm trừu tượng như công thức chung đó
	
	// Tạo method dưới dạng strategy pattern có tham số là @FI đó
	// Trong method, lúc compile thì sẽ chưa biết hàm trừu tượng sẽ làm gì
	// Lúc gọi method mới truyền phần thực thi vào
	
	private static int countElements(int[] elements, NumberTest nTest) {
		int count = 0;
		for (int element: elements) {
			if (nTest.testing(element)) {
				count++;
			}
		}
		return count;
	}
	
	// Đếm số chẵn
	private static int countEvenElements(int[] elements) {
		int count = 0;
		for (int element: elements) {
			if (element % 2 == 0) {
				count++;
			}
		}
		return count;
	}
	
	// Đếm số lẻ
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
	// bài tập
	
	// Đếm số nguyên tố
	private static int countPrimeElements(int[] elements) {
		int count = 0;
		for (int element: elements) {
			if (isPrime(element)) {
				count++;
			}
		}
		return count;
	}
	
	// Đếm số chia hết cho 5
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
