package view;

public class Ex05HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(18));
	}
	
	private static boolean isHappy(int n) {
		int sum, remainder;
		while(n != 1 && n != 4) {
			sum = 0;
			while(n > 0) {
				remainder = n % 10;
				sum += remainder * remainder;
				n /= 10;
			}
			n = sum;
		}
		return n == 1;
	}
	
}
