package view;

import static utils.PrintUtils.generate;

import functional.LongOperation;

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
	 
	 Functional --> ... 
	 	- initial value
	 	- numbers
	 	- long ...(long result, long number) 
	 */
	
	public static void main(String[] args) {
		int[] numbers = {11, 22, 15, 40, 66, 128};
		
		generate("Danh sách các phần tử", numbers);
		
		System.out.printf("Tổng các phần tử trong mảng --> %s\n", process(numbers, 0, (n1, n2) -> n1 + n2));
		
		System.out.printf("Tích các phần tử trong mảng --> %s\n", process(numbers, 1, (n1, n2) -> n1 * n2));
		
		System.out.printf("Tích giá trị lớn nhất trong mảng --> %s\n", process(numbers, Long.MIN_VALUE, (n1, n2) -> Math.max(n1, n2)));
		
		System.out.printf("Tích giá trị nhỏ trong mảng --> %s\n", process(numbers, Long.MAX_VALUE, (n1, n2) -> Math.min(n1, n2)));
	}
	
	private static long process(int[] numbers, long initial, LongOperation operation) {
		long result = initial;
		for (int number: numbers) {
			result = operation.operate(result, number);
		}
		return result;
	}
}