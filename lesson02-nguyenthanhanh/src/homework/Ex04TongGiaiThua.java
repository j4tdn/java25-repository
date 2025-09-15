package homework;

import java.util.Random;
import static homework.Ex03GiaiThuaCuaN.calcFactorial;

public class Ex04TongGiaiThua {

	public static void main(String[] args) {
		System.out.printf("S = %s", sumOfFactorials(createNumbers()));
		
	}
	
	// Em chưa hiểu vì sao để int lại ra số âm
	private static long sumOfFactorials(int[] numbers) {
		long sum = 0;
		for(int number:numbers) {
			sum += calcFactorial(number);
		}
		
		return sum;
	}
	
	private static int[] createNumbers() {
		int[] numbers = new int[4];
		Random rd = new Random();
		
		for(int i = 0; i < 4; i++) {
			numbers[i] = rd.nextInt(10, 21);
		}
		
		return numbers;
	}
	
}
