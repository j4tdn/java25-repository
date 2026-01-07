package ex05;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
		public static void main(String[] args) {
			int number = 44;
			System.out.println(number + " có phải là số hạnh phúc không? "+Happy(number));
		}
	
		public static boolean Happy(int n) {
			Set<Integer> se = new HashSet<>();
			while(n !=1 ) {
				if(se.contains(n)) {
					return false;
				}
				se.add(n);
				n = sumOfSquares(n);
			}
		return true;
		}

		private static int sumOfSquares(int n) {
			int sum = 0;
			while(n>0) {
				int a = n%10;
				sum = sum + a*a;
				n = n/10;
			}
			
			return sum;
		}
		
		
		
}
