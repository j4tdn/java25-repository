package view;

import java.util.Arrays;

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
		
		int[] list = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.print("Tìm các phần tử chẵn trong mảng: ");
		even(list);
		
		System.out.println("\n===================\n");
		
		System.out.print("Tìm các phần tử là số nguyên tố trong mảng: ");
		findPrime(list);
		
		System.out.println("\n===================\n");
		
		System.out.print("Tìm các phần tử là bội của 5 trong mảng: ");
		multipleOf5(list);
		
		System.out.println("\n\n===================\n\n");
		
		int[] even = Demo(list, nb -> nb % 2 == 0);
		System.out.println("Tìm các phần tử chẵn trong mảng: " + Arrays.toString(even));
		
		int[] prime = Demo(list, nb -> prime(nb));
		System.out.println("Tìm các phần tử là số nguyên tố trong mảng: " + Arrays.toString(prime));
		
		int[] muti = Demo(list, nb -> nb % 5 == 0);
		System.out.println("Tìm các phần tử là bội của 5 trong mảng: " + Arrays.toString(muti));
		
		
		
	}
	
	private static int[] Demo(int[] element, NumberTest n) {
		int[] num = new int[element.length];
		int count = 0;
		
		for (int number : element) {
			if (n.testing(number)) {
				num[count++] = number;
			}
		}
		
		return Arrays.copyOfRange(num, 0, count);
		
	}
	
	private static void multipleOf5(int[] num) {
		for (int number : num) {
			if (number % 5 == 0) {
				System.out.print(number + " ");
			}
		}
	}
	
	private static void even(int[] number) {
		for (int numbers : number) {
			if (numbers % 2 == 0) {
				System.out.print(numbers + " ");
			}
		}
		
		
		
	}
	
	private static void findPrime(int[] number) {
		for (int numbers : number) {
			if (prime(numbers)) {
				System.out.print(numbers + " ");
			}
		}
	}
	
	private static boolean prime(int n) {
	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0)
	            return false;
	    }
	    return true;
	}
	

}
