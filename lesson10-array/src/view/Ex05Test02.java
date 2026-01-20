package view;

import function.lambda.NumberTest;

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
		
		//1 hàm để xử lý cho 3 yêu cầu
		
		System.out.println("Tổng các phần tử trong mảng: ");

		System.out.println("Tích các phần tử trong mảng: ");
		
		System.out.println("Giá trị lớn nhất trong mảng: ");
		findNumbers(numbers, nb -> nb > numbers[0]);
		
		System.out.println("Giá trị nhỏ nhất trong mảng: ");
		findNumbers(numbers, nb -> nb < numbers[0]);
	}

//	private static void calculationNumbers(int[] numbers, int n, NumberTest nTest) {
//		for(int number: numbers) {
//			int rs = nTest.testing(number);
//		}
//		System.out.println(rs);
//		
//		System.out.println();
//	}
	
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
