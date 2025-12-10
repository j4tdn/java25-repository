package function.lambda;

public class Ex01ArrayCounter {
	public static void main(String[] args) {
		
		// viết chương trình đếm số lượng các phần tử là
		// số chẵn
		// số lẻ
		// số chia hết cho 3
		// số chia hết cho 5
		
		int[] numbers = {1, 5, 2, 8, 10, 20, 7, 18};
		
		System.out.println("So chan: " + countEvenElements(numbers));
		System.out.println("So le: " +  countOddElements(numbers));
		System.out.println("So nguyen to: " + countPrimeElements(numbers));
		System.out.println("So chia het cho 5: " + countM5Elements(numbers));
		
		System.out.println("\n----------------------------------\n");
		
		System.out.println("So chan: " + countElements(numbers, nb ->  nb % 2 == 0));
		System.out.println("So le: " +  countElements(numbers, nb -> nb % 2 != 0 ));
		System.out.println("So nguyen to: " + countElements(numbers, nb -> isPrime(nb)));
		System.out.println("So chia het cho 5: " + countElements(numbers, nb -> nb % 5 == 0));
	}
	
	private static int countElements(int[] elements, NumberTest nTest) {
		int count = 0;
		for (int element: elements) {
			if (nTest.testing(element) ) {
				count++;
			}
		}
		return count;
	}
	
	
	
	
	private static int countEvenElements(int[] elements) {
		int count = 0;
		for (int element: elements) {
			if (element % 2 == 0) {
				count++;
			}
		}
		return count;
	}
	
	private static int countOddElements(int[] elements) {
		int count = 0;
		for (int element: elements) {
			if (element % 2 != 0) {
				count++;
			}
		}
		return count;
	}
	
	private static int countPrimeElements(int[] elements) {
		int count = 0;
		for (int element: elements) {
			if (isPrime(element)) {
				count++;
			}
		}
		return count;
	}
	
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
				return true;
			}
		}
		return true;
	}
	

}
