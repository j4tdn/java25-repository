package view;

import java.util.ArrayList;
import java.util.List;

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
	        int[] arr = { 1, 3, 4, 5, 7, 8, 10, 11, 15, 20, 25 };

	       
	        System.out.println("Số phần tử chẵn: " + FindEven(arr));
	        System.out.println("Số phần tử nguyên tố: " + FindPrime(arr));
	        System.out.println("Số phần tử là bội của 5: " + FindMultipleOf5(arr));

	    }
	
   
    public static List<Integer> FindEven(int[] arr) {
        List<Integer> result = new ArrayList<>();
       
        if (arr == null) {
        	return result;
        }

        for (int x : arr) {
            if (x % 2 == 0) {
            	result.add(x);
            }
        }
        return result;
    }

    public static List<Integer> FindPrime(int[] arr) {
        List<Integer> result = new ArrayList<>();
        if (arr == null) {
        	return result;
        }

        for (int x : arr) {
            if (IsPrime(x)) {
            	result.add(x);
            }
        }
        return result;
    }

    public static List<Integer> FindMultipleOf5(int[] arr) {
        List<Integer> result = new ArrayList<>();
        if (arr == null) {
        	return result;
        }

        for (int x : arr) {
            if (x % 5 == 0) {
            	result.add(x);
            }
        }
        return result;
    }

    private static boolean IsPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

      
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
            	return false;
            }
        }
        return true;
    }
}
