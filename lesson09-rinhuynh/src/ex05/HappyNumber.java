package ex05;

public class HappyNumber {
	public static void main(String[] args) {
		int n = 44;
		
		System.out.println(isHappyNumber(n) ? n + " la so hanh phuc" : n + " khong phai la so hanh phuc");
	}
	
	private static boolean isHappyNumber(int n) {
		while (n != 1 && n != 4) {
			int sum = 0;
			
			while (n > 0) {
				int digit = n % 10;
				sum += digit * digit;
				n /= 10;
			}
			
			n = sum;
		}
		return n == 1;
	}

}
