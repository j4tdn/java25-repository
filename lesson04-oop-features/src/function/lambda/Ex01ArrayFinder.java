package function.lambda;

public class Ex01ArrayFinder {

	public static void main(String[] args) {
		
		int[] numbers = {1,5,2,8,10,20,7,18};
		System.out.println("So phan tu chan: " +countEvenElements(numbers));
		System.out.println("So phan tu le: " +countOddElements(numbers));
		System.out.println("So phan tu Prime: " +countPrimeElements(numbers));
	
		System.out.println("-----------------");
		System.out.println("phan tu chan: " +countElements(numbers,nb -> nb%2==0));
		System.out.println("phan tu le: " +countElements(numbers, nb-> nb%2 !=0));
		System.out.println("phan tu Prime: " +countElements(numbers, nb->isPrime(nb)));
	}
	private static int countElements(int [] elements, NumberTest nTest) {
		int count =0;
		for(int element : elements) {
			if(nTest.testing(element)) {
				count ++;
			}
		}
		return count;
	}
	
	private static int countEvenElements(int [] elements) {
		int count =0;
		for(int element : elements) {
			if(element %2 ==0) {
				count ++;
			}
		}
		return count;
	}
	private static int countOddElements(int [] elements) {
		int count =0;
		for(int element : elements) {
			if(element %2 !=0) {
				count ++;
			}
		}
		return count;
	}
	private static int countPrimeElements(int [] elements) {
		int count =0;
		for(int element : elements) {
			if(isPrime(element)) {
				count ++;
			}
		}
		return count;
	}
	private static boolean isPrime(int number) {
		if (number<2) {
			return false;
		}
		for(int i=2; i<=Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
				}
	    	}
	    return true;
		}
}

