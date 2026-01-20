package view;

import java.util.Arrays;
import java.util.Scanner;

import function.lambda.NumberFilter;

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
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so luong phan tu cho mang: ");
		int n = Integer.parseInt(sc.nextLine());
		int[] a = new int[n];
		for(int i = 0;i < n;++i) {
			a[i] = Integer.parseInt(sc.nextLine());
		}

		System.out.println(Arrays.toString(solve(a, (num) -> num%2==0)));
		System.out.println(Arrays.toString(solve(a, (num) -> {
			for(int i = 2;i * i <= num;++i) {
				if(num%i == 0) {
					return false;
				}
			}
			return num > 1;
		})));
		
		System.out.println(Arrays.toString(solve(a, (num) -> num%5==0)));
	}
	
	private static int[] solve(int[] arr, NumberFilter num) {
		int[] result = new int[arr.length];
		int cnt = 0;
		for(int i = 0;i < arr.length ; ++i) {
			if(num.test(arr[i])) {
				result[cnt++] = arr[i];
			}
		}
		return Arrays.copyOfRange(result, 0, cnt);
	}
	
	private static boolean isEven(int number) {
		return number % 2 == 0;
	}
	
	private static boolean isPrimeNumber(int number) {
		for(int i = 0;i * i < number; ++i) {
			if(number%i==0) {
				return false;
			}
		}
		return number > 1;
	}
	
	private static boolean isBoiOfFive(int number) {
		return number % 5 == 0;
	}
}
