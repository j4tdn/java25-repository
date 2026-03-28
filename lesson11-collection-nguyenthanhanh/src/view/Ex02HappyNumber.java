package view;

import java.util.HashSet;

public class Ex02HappyNumber {

	public static void main(String[] args) {
		
	}
	
	public static boolean isHappyNumber(int n) {
		HashSet<Integer> checkedNumbers = new HashSet<>();
		return true;
	}
	
	private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
	
}
