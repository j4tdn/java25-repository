package view;

import function.NumberTest;

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
	 */
	
	public static void main(String[] args) {
		
		int[] numbers = {1, 4, 15, 23, 29, 30, 31, 35, 45};
		
		// Mỗi yêu cầu viết 1 hàm
		findEvenNumbers(numbers);
		findPrimeNumbers(numbers);
		findMultiplesOfFive(numbers);
		
		System.out.println("=====================================");
		
		//1 hàm để xử lý cho 3 yêu cầu
		System.out.println("Các phần tử chẵn trong mảng: ");
		findNumbers(numbers, nb -> nb % 2 == 0);
		
		System.out.println("Các phần tử là số nguyên tố trong mảng: ");
		findNumbers(numbers, nb -> isPrime(nb));
		
		System.out.println("Các phần tử là bội của 5 trong mảng: ");
		findNumbers(numbers, nb -> nb % 5 == 0);
	}
	
	private static void findNumbers(int[] numbers, NumberTest nTest) {
		for(int number: numbers) {
			if(nTest.testing(number)) {
				System.out.println(number);
			}
		}
		System.out.println();
	}
	
	private static void findEvenNumbers(int[] numbers) {
		System.out.println("Các phần tử chẵn trong mảng: ");
		for(int number: numbers) {
			if(number % 2 == 0) {
				System.out.println(number);
			}
		}
		System.out.println();
	}
	
	private static void findPrimeNumbers(int[] numbers) {
		System.out.println("Các phần tử là số nguyên tố trong mảng: ");
		for(int number: numbers) {
			if(isPrime(number)) {
				System.out.println(number);
			}
		}
		System.out.println();
	}
	
	private static boolean isPrime(int number) {
		if(number < 2) return false;
		for(int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0) return  false;
		}
		return true;
	}
	
	private static void findMultiplesOfFive(int[] numbers) {
		System.out.println("Các phần tử là bội của 5 trong mảng: ");
		for(int number: numbers) {
			if(number % 5 == 0) {
				System.out.println(number);
			}
		}
		System.out.println();
	}
}
