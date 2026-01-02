package view;

import static utils.StringUtils.*;

public class Ex04 {

	public static void main(String[] args) {
		int a,b;
		try {
			a = inputNumber("Nhập vào 1 số: ");
			b = inputNumber("Nhập vào 1 số: ");
			if(!isPrime(a) || !isPrime(b)) {
				throw new IllegalArgumentException("Số bạn nhập không phải số nguyên tố");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static boolean isPrime(int n) {
		if(n <= 1) {
			return false;
		}
		
		for(int i = 0; i <= Math.sqrt(i); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
}
