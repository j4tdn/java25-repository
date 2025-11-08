package view;

import java.util.Scanner;

public class Ex04 {

	/*
	 * Bài 4 (20đ): Viết chương trình tìm tổng các phần tử không trùng nhau trong
	 * mảng ngoại trừ phần tử lớn nhất và phần tử nhỏ nhất. Ví dụ ▪ int[] a = {1, 5,
	 * 8, 9, 2, 5, 9} → Tổng = 2 + 5 + 8 = 15 ▪ int[] a = {4, 2, 6, 6, 4, 15, 1} →
	 * Tổng = 2 + 4 + 6 = 12 Method signature: int sum(....)
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		System.out.println(sum(a));
		sc.close();
	}
	
	private static int sum(int[] a) {
		int[] a1 = uniqueNumbers(a);
		
		return maxMin(a1);
	}

	private static int[] uniqueNumbers(int[] a) {
		int n = a.length;	
		int[] temp = new int[n];
		int count = 0;
			
		for(int i = 0; i < n; i++) {
			int current = a[i];
			boolean flag = false;
			
			for(int j = 0; j <= count; j++) {
				if(temp[j] == current) {
					flag = true;
					break;
					}
				}
			if(!flag) {
				temp[count] = current;
				count++;
				}
			}
		
		int[] output = new int[count];
		for(int i = 0; i < count; i++) {
			output[i] = temp[i];
		}
		return output;
	}
	
	private static int maxMin(int[] output) {
		int max = output[0];
		int min = output[0];
		
		for(int i = 0; i < output.length; i++) {
			if(output[i] < min) {
				min = output[i];
			}
			
			if(output[i] > max) {
				max = output[i];
			}
		}
		
		int total = 0;
		for(int i = 0; i < output.length; i++) {
			int current = output[i];
			
			if(current != min && current != max) {
				total += current;
			}
		}
		
		return total;
	}
}
