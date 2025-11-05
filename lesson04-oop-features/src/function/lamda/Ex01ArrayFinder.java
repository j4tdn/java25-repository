package function.lamda;

public class Ex01ArrayFinder {

	public static void main(String[] args) {
		/**
		 * viết chương trình đếm ố lượng các phần tử là số chẵn số lẻ sốc hai hết cho 3
		 * số chia hết cho 5
		 */
		int[] numbers = { 1, 5, 2, 8, 10, 20, 7, 18 };
		System.out.println("Số chẵn: " + countEvenElements(numbers));
		System.out.println("Số lẻ: " + countOddElements(numbers));
		System.out.println("Số NT: " + countPrimeElements(numbers));
		System.out.println("Số bội của 5: " + countM5Elements(numbers));
		
		System.out.println("\n--------------------------------------\n");
		
		System.out.println("Số chẵn: " + countElements(numbers,nb -> nb % 2 == 0 ));
		System.out.println("Số lẻ: " + countElements(numbers,nb -> nb % 2 != 0 ));
		System.out.println("Số NT: " + countElements(numbers,nb -> isPrime(nb)));
		System.out.println("Số bội của 5: " + countElements(numbers,nb -> nb % 5 == 0 ));
	}
	
	//Từ các logic khác nhau
	//Tìm công thức chung(Strategy): input và ouput
	
	// Bài toán: boolean ?(int element) đặt tên hàm gì cũng được(logic)
	// Tạo interface chứa hàm trừu tượng như công thức chung đó
	
	// Tạo method dưới dạng strategy pattern có tham số là @FI đó
	// Trong method, lúc compile thì sẽ chưa biết hàm trừu tượng sẽ làm gì
	// lúc gọi method mới truyền phần thực thi vào
	
	private static int countElements(int[] elements, NumberTest nTest) {
		int count = 0;
		for(int element: elements) {
			if(nTest.testing(element)) {
				count++;
			}
		}
		return count++;
	}

	// Đếm số chẵn
	private static int countEvenElements(int[] elements) {
		int count = 0;
		for (int element : elements) {
			if (element % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	// Đếm số lẻ
	private static int countOddElements(int[] elements) {
		int count = 0;
		for (int element : elements) {
			if (element % 2 != 0) {
				count++;
			}
		}
		return count;
	}

	// Đếm số nguyên tố
	private static int countPrimeElements(int[] elements) {
		int count = 0;
		for (int element : elements) {
			if (isPrime(element)) {
				count++;
			}
		}
		return count;
	}

	// Đếm số chia hết cho 5
	private static int countM5Elements(int[] elements) {
		int count = 0;
		for (int element : elements) {
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
		for (int i = 2; i <= Math.sqrt(i); i++) {
			 if (number % i == 0) {
		            return false;
		}
	}
		return true;
  }
}
