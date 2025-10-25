package view;

import util.NumberUtils;

public class Bai5 {

	public static void main(String[] args) {
		int n = NumberUtils.inputNumber(3, 20, 3, "Nhập số lượng phần tử n (3 <= n <= 20): ");
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
            numbers[i] = NumberUtils.inputNumber(3, "Nhập phần tử thứ " + i + ": ");
        }
		
		System.out.print("\nMảng gốc: ");
        display(numbers);
        
        sortByLevel(numbers);

        System.out.print("Kết quả sau khi sắp xếp (Level tăng dần): ");
        display(numbers);
	}
	
	public static int findLevel(int n) {
        if (n <= 0) return 0;
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            if(n%i == 0) {
            	count++;
            }
        }
        return count;
    }
	
	public static void sortByLevel(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (findLevel(arr[j]) > findLevel(arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } 
            }
        }
    }
	
	public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        System.out.println();
    }
	
}
