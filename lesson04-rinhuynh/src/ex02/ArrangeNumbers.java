package ex02;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrangeNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		System.out.print("Enter the number of randomly genareated numbers :  ");
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = rd.nextInt(90) + 10;
		}
		System.out.print("Random numbers: ");
		printArray(arr);
		
		List<Integer> div5 = new ArrayList<>();
		List<Integer> div7 = new ArrayList<>();
		List<Integer> others = new ArrayList<>();
		
		for (int x : arr) {
			boolean d5 = x % 5 == 0;
			boolean d7 = x % 7 == 0;
			
			if (d5 && d7) {
				others.add(x);
			} else if (d7) {
				div7.add(x);
			} else if (d5) {
				div5.add(x);
			} else {
				others.add(x);
			}
			
		}
		
		System.out.print("\nSorted list: ");
		printList(div7);
		System.out.print(" | ");
		printList(others);
		System.out.print(" | ");
		printList(div5);
	}
	
	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length -1) {
				System.out.print(", ");
			}
		}
	}
	
	private static void printList(List<Integer>list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i < list.size() -1 ) {
				System.out.print(", ");
			}
		}
		
	}
}
