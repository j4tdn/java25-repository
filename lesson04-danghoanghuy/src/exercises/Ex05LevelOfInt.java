package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05LevelOfInt {
	public static void main(String[] args) {
		inputArray();
	}
	
	private static int[] inputArray() {
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.println("Nhap n: ");
			n = sc.nextInt();
			if(n <= 3 || n >= 20)
			System.out.println("Nhap lai");
		}
		while(n <= 3 || n >= 20);
		
		int[] array = new int[n];
		
		System.out.println("Nhap n phan tu:");
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
		soft(array);
		for(int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		
		sc.close();
		return array;
	}
	
	private static void soft(int[] array) {
		int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                
                int levelI = getLevel(array[i]);
                int levelJ = getLevel(array[j]);
                
                if (levelI > levelJ) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
	}
	
	private static int getLevel(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }
}
