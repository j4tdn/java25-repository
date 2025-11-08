package Bai04;

public class Bai	4 {

	public static int[] getNumbers(int[] arr) {
		int n = arr.length;
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j < n; j++) {
				if(arr[i] == arr[j]) {
					sum++;
				}
				if(sum == 1) count++;
			}
		}
	}
}
