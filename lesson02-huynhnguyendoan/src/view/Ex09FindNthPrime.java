package view;

import utils.MathUtils;

public class Ex09FindNthPrime {
	
	public static void main(String[] args) {
		System.out.println("Số nguyên tố thứ 200: " + findNthPrime(200));
	}
	
	private static long findNthPrime(int nth) {
		long running = 2;
		int count = 0;
		while(true) {
			if (MathUtils.isPrime(running)) {
				count++;
				if (count == nth) {
					return running;
				}
			}
			running++;
		}
	}
	
}