package view;

import java.util.Arrays;

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
		int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		System.out.print("Tìm tổng các phần tử trong mảng: " );
		sum(list);
		
		System.out.print("\nTìm tích các phần tử trong mảng: ");
		multiple(list);
		
		System.out.println("\nTìm giá trị lớn nhất trong mảng: " + max(list) );
		
		
		System.out.println("\nTìm giá trị nhỏ nhất trong mảng: " + min(list));

		System.out.println();
	}
	
	private static int[] Demo(int[] element, NumberTest n) {
		int result = 0;
		
		for (int number : element) {
			if (n.testing(number)) {
				result = number;
			}
		}
		return Arrays.copyOfRange(element, 0, result);
	}
	
	private static int min(int[] number) {
		int min = number[0];
		
		for (int i = 1; i < number.length; i++) {
			if (number[i] < min) {
				min = number[i];
			}
		}
		return min;
	}
	
	private static int max(int[] number) {
		int max = number[0];
		
		for (int i = 1; i < number.length; i++) {
			if (number[i] > max) {
				max = number[i];
			}
		}
		return max;
	}
	
	private static void multiple(int[] number) {
		int multi = 1;
		for (int i = 0; i < number.length; i++) {
			multi *= number[i];
		}
		System.out.println(multi);
	}

	private static void sum(int[] number) {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum += number[i];
		}
		System.out.println(sum);

	}

}
