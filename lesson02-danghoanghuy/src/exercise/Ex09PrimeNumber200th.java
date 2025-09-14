package exercise;

public class Ex09PrimeNumber200th {
	public static void main(String[] args) {
		int number = 0;
		int count = 0;
		
		while(count < 200) {
			number++;
			if(isPrime(number)) {
				count++;
			}
		}
		System.out.println("So nguyen to thu 200 la: " + number);
	}
	
	private static boolean isPrime(int number) {
		if(number < 2) {
			return false;
		}
		for(int i = 2; i < number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
