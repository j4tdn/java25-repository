package function.lambda;

public class ArrayFinder {
	public static void main(String[] args) {
		// Viết chườn trình đếm dố lượng các phần tử là
		// Số chẵn 
		// Số lẻSố chia hết cho 3
		// Số chia hết cho 5 
		
		int[] numbers = {1,5,2,8,10,20,7,18};
		System.out.println("So chan  "+ countEvenElements(numbers));
		System.out.println("So le  "+ countOddElements(numbers));
		System.out.println("So nguyen to  "+ countPrimeElements(numbers));
		System.out.println("So chia het cho 5  "+ countEvenElement(numbers));
		
	}
	
	private static int countEvenElements(int[] elements) {
		int count = 0;
		for( int element: elements) {
			if(element % 2 == 0) {
				count ++;
			}
		}
		return count;
	}
	// dem so le 
	private static int countOddElements(int[] elements) {
		int count = 0;
		for( int element: elements) {
			if(element % 2 != 0) {
				count ++;
			}
		}
		return count;
	}
	// dem so nguyen to 
	private static int countPrimeElements(int[] elements) {
		int count = 0;
		for (int element : elements) {
			if(isPrime(element)) {
				count ++;
			}
		}
		return count;
	}
	private static int countM5Element (int elements) {
		
	}
	
}
