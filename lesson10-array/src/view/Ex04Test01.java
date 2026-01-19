package view;

import java.util.Arrays;

import bean.Predicate;

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
		int[] arr = { 1,2,3,4,5,6,7,8,9,10 };
		System.out.println("Các phần tử là số nguyên tố trong mảng --> " + Arrays.toString(findByPredicate(arr, new Predicate() {
			@Override
			public boolean check(int n) {
				return isPrime(n);
			}
		})));
	}
	
	private static int[] getEvenNumbers(int[] source) {
		int count = 0;
		int[] target = new int[source.length];
		for(int i = 0; i < source.length; i++) {
			int num = source[i];
			if(source[i] % 2 == 0) {
				target[count] = num;
				count++;
			}
		}
		return Arrays.copyOfRange(target, 0, count);
	}
	
	private static int[] findPrimes(int[] source) {
		int count = 0;
		int[] target = new int[source.length];
		for(int i = 0; i < source.length; i++) {
			int num = source[i];
			if(isPrime(num)) {
				target[count] = num;
				count++;
			}
		}
		return Arrays.copyOfRange(target, 0, count);
    }
	
	private static int[] findMultiplesOf5(int[] source) {
		int count = 0;
		int[] target = new int[source.length];
		for(int i = 0; i < source.length; i++) {
			int num = source[i];
			if(source[i] % 5 == 0) {
				target[count] = num;
				count++;
			}
		}
		return Arrays.copyOfRange(target, 0, count);
	}
	
	private static int[] findByPredicate(int[] source, Predicate predicate) {
		int count = 0;
		int[] target = new int[source.length];
		for(int i = 0; i < source.length; i++) {
			int num = source[i];
			if(predicate.check(num)) {
				target[count] = num;
				count++;
			}
		}
		return Arrays.copyOfRange(target, 0, count);
	}
	
	private static boolean isPrime(int n) {
        if (n < 2) {
        	return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
            	return false;
            }
        }
        return true;
    }
	
}
