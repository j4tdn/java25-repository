package view;

import function.LongOperation;
import function.NumberTest;

import util.*;

public class Ex05Test02 {

	/*
	 Cho một mảng số nguyên gồm N phần tử
	 Viết chương trình
	 + Tìm tổng các phần tử trong mảng
	 + Tìm tích các phần tử trong mảng
	 + Tìm giá trị lớn nhất trong mảng
	 + Tìm giá trị nhỏ nhất trong mảng
	 
	 1: Mỗi yêu cầu viết 1 hàm để xử lý
	 2: Viết duy nhất 1 hàm để xử lý cho 4 yêu cầu trên
	 */
	
public static void main(String[] args) {
		
		int[] numbers = {1, 4, 15, 23, 29};

		// Mỗi yêu cầu viết 1 hàm
		sumNumbers(numbers);
		mulNumbers(numbers);
		findMax(numbers);
		findMin(numbers);

		System.out.println("=====================================");
		
		//1 hàm để xử lý cho 3 yêu cầu phake
		
		System.out.println("Tổng các phần tử trong mảng: ");

		System.out.println("Tích các phần tử trong mảng: ");
		
		System.out.println("Giá trị lớn nhất trong mảng: ");
		findNumbers(numbers, nb -> nb > numbers[0]);
		
		System.out.println("Giá trị nhỏ nhất trong mảng: ");
		findNumbers(numbers, nb -> nb < numbers[0]);
		
		//1 hàm để xử lý cho 3 yêu cầu 
		
		PrintUtils.generate("DS phan tu", numbers);
		
		System.out.printf("Tong cac phan tu --> %s\n", process(numbers, 0, (n1, n2) -> n1 + n2));
		
		System.out.printf("Tich cac phan tu --> %s\n", process(numbers, 1, (n1, n2) -> n1 * n2));
	
		System.out.printf("GTLN trong mang --> %s\n", process(numbers, numbers[0], (n1, n2) -> Math.max(n1, n2)));
		
		System.out.printf("GTNN trong mang--> %s", process(numbers, numbers[0], (n1, n2) -> Math.min(n1, n2)));
}

//=====================================================


	private static long process(int[] numbers, long init, LongOperation operation) {
		long rs = init;
		for(int number: numbers) {
			rs = operation.operate(rs, number);
		}
		return rs;
	}

//=====================================================

	private static void findNumbers(int[] numbers, NumberTest nTest) {
		int max = numbers[0];
		for(int number: numbers) {
			if(nTest.testing(number)) {
				max = number;
			}
		}
		System.out.println(max);
		
		System.out.println();
	}
	
	private static void sumNumbers(int[] numbers) {
		System.out.println("Tổng các phần tử trong mảng: ");
		int sum = 0;
		for(int number: numbers) {
			sum += number;
		}
		System.out.println(sum);
		
		System.out.println();
	}
	
	private static void mulNumbers(int[] numbers) {
		System.out.println("Tích các phần tử trong mảng: ");
		int mul = 1;
		for(int number: numbers) {
			mul *= number;
		}
		System.out.println(mul);
		
		System.out.println();
	}
	
	private static void findMax(int[] numbers) {
		System.out.println("Giá trị lớn nhất trong mảng: ");
		int max = numbers[0];
		for(int number: numbers) {
			if(max < number) {
				max = number;
			}
		}
		System.out.println(max);
		
		System.out.println();
	}
	
	private static void findMin(int[] numbers) {
		System.out.println("Giá trị nhỏ nhất trong mảng: ");
		int min = numbers[0];
		for(int number: numbers) {
			if(min > number) {
				min = number;
			}
		}
		System.out.println(min);
		
		System.out.println();
	}
}
