package view;

import java.util.Arrays;

import functional.IntCondition;

import static utils.PrintUtils.*;

public class Ex04Test01 {
	
	/*
	 * Cho một mảng số nguyên gồm N phần tử
	 * Viết chương trình
	 * + Tìm các phần tử chẵn trong mảng
	 * + Tìm các phần tử là số nguyên tố trong mảng
	 * + Tìm các phần tử là bội của 5 trong mảng
	 * 
	 * 1: Mỗi yêu cầu viết 1 hàm để xử lý
	 * 2: Viết duy nhất 1 hàm để xử lý cho 3 yêu cầu
	 * 
	 * Functional --> boolean ...(int number)
	 */
	
	public static void main(String[] args) {
		int[] numbers = {11, 22, 15, 40, 66, 128};
		
		generate("Danh sách các phần tử", numbers);
		
		generate("Tìm các phần tử chẵn", find(numbers, nb -> isEven(nb)));
		generate("Tìm các phần tử là số nguyên tố", find(numbers, nb -> isPrime(nb)));
		generate("Tìm các phần tử là bội của 5", find(numbers, nb -> nb % 5 == 0));
	}
	
	private static int[] find(int[] numbers, IntCondition condition) {
		int[] result = new int[numbers.length];
		int count = 0;
		for (int number: numbers) {
			if (condition.test(number)) {
				result[count++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}
	
	private static boolean isEven(int number) {
		return number % 2 == 0;
	}
	
	private static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
