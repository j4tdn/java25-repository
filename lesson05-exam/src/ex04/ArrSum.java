package ex04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrSum {

	public static void main(String[] args) {

		int arr[] = {1, 5, 8, 9, 2, 5, 9}; // 1+8+2=11
		int n = arr.length;
		System.out.println("Tổng của các số xuất hiện 1 lần là: "+sum(arr ,n));
		
	}

	public static int sum(int arr[], int n) {
		
		Arrays.sort(arr);
		int sum = 0;
		if(arr[0] != arr[1]) {
			sum = sum +arr[0];
		}
		
		for (int i = 1; i< n-1; i++) {
			if(arr[i] != arr[i-1] && arr[i] != arr[i+1]){
				sum = sum + arr[i];
			}
		if(arr[n-2] != arr[n-1]) {
			sum = sum + arr[n-1];
		}

	}
		return sum;
	}
	
}
