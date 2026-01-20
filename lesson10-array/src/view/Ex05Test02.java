package view;

import java.util.Scanner;

import function.lambda.Number;

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
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so luong phan tu cho mang: ");
		int n = Integer.parseInt(sc.nextLine());
		int[] a = new int[n];
		for(int i = 0;i < n;++i) {
			a[i] = Integer.parseInt(sc.nextLine());
		}
		
		System.out.println(solve(a, 0, (res,x) -> res + x));
		System.out.println(solve(a, 1, (res,x) -> res * x));
		System.out.println(solve(a, Long.MIN_VALUE, (res,x) -> Math.max(res, x)));
		System.out.println(solve(a, Long.MAX_VALUE, (res,x) -> Math.min(res, x)));
	}
	
	public static long solve(int[] a, long initValue, Number func) {
	    long result = initValue;
	    for (int x : a) {
	        result = func.calc(result, x);
	    }
	    return result;
	}

	private static long solveYC1(int[] a) {
		long sum = 0;
		for(int i = 0; i< a.length;++i) {
			sum += a[i];
		}
		return sum;
	}
	
	private static long solveYC2(int[] a) {
		long result = 1;
		for(int i = 0;i<a.length;++i) {
			result *= a[i];
		}
		return result;
	}
	
	private static long solveYC3(int[] a) {
		long maxVal = Long.MIN_VALUE;
		for(int i = 0;i<a.length;++i) {
			maxVal = Math.max(maxVal, a[i]);
		}
		return maxVal;
	}
	
	private static long solveYC4(int[] a) {
		long minVal = Long.MAX_VALUE;
		for(int i = 0;i<a.length;++i) {
			minVal = Math.min(minVal, a[i]);
		}
		return minVal;
	}
}
