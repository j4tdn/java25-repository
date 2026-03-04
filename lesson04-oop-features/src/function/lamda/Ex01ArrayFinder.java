package function.lamda;

public class Ex01ArrayFinder {
	public static void main(String[] args) {
		int[] number = { 1, 5, 2, 8, 10, 20, 7, 18 };
	}

	// đếm số chẵn
	private static int countEventElement(int[] elements) {
		int count = 0;
		for (int element : elements) {
			if (element % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	// đếm số lẻ
	private static int countOddElements(int[] elements) {
		int count = 0;
		for (int element : elements) {
			if (element % 2 != 0) {
				count++;

			}
		}
		return count;
	}
	private static int countPrimeElements(int[] elements) {
		int count =0;
		for(int element: elements) {
			if(isPrime(element)) {
				count++;
			}
		}return count;
	}

	private static boolean isPrime(int number) {
		if(number<2) {
		return false;
	}
		for(int i =2; i<= Math.sqrt(number);i++) {
			if(number % i ==0) {
				return false;
			}
		}return true;
	}

}
