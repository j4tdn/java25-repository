package homework;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,3,2,1,4,5,4};
		
		System.out.print("Phần tử không lặp:");
		System.out.println(" "+ Arrays.toString(DeleteDuplicationOfElements(arr)));
		System.out.println("--------------------------");
		
		System.out.println("So sánh giá trị 2 nửa trong mảng:");
		if (compareTo(arr) > 0) {
			System.out.println("Kết quả TB n/2 phần tử đầu tiên > n/2 phần tử cuối đầu");
		} else if (compareTo(arr) < 0) {
			System.out.println("Kết quả TB n/2 phần tử đầu tiên < n/2 phần tử cuối đầu");
		} else {
			System.out.println("Kết quả TB n/2 phần tử đầu tiên = n/2 phần tử cuối đầu");
		}
		System.out.println("--------------------------");
		
		System.out.print("Phần tử lớn thứ 3 trong mảng (Không tính lặp):");
		System.out.println(" "+FindMaxNumberOfThird(arr));
	}
	private static int[] DeleteDuplicationOfElements(int[] numbers) {
		int[] result = new int[numbers.length];
		int k=0;
		
		for(int i=0;i<numbers.length;i++) {
			int count=0;
			for(int j=0;j<numbers.length;j++) {
				if(numbers[i]==numbers[j]) {
					count++;
				}
			}
			if(count==1) {
				result[k++]=numbers[i];
			}
		}
		
		return Arrays.copyOfRange(result, 0, k);
	}
	private static int compareTo(int[] numbers) {
		int k = numbers.length / 2;

		int SumLeft = 0, SumRight = 0;
		for (int i = 0; i < k; i++) {
			SumLeft += numbers[i];
			SumRight += numbers[numbers.length - i - 1];
		}
		return (SumLeft - SumRight) / k;
	}
	
	private static int FindMaxNumberOfThird(int[] numbers) {
		
		int Max1 = Integer.MIN_VALUE;
		int Max2 = Integer.MIN_VALUE;
		int Max3 = Integer.MIN_VALUE;

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > Max1) {
				Max1 = numbers[i];
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > Max2 && numbers[i] != Max1) {
				Max2 = numbers[i];
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > Max3 && numbers[i] != Max1 && numbers[i] != Max2) {
				Max3 = numbers[i];
			}
		}

		return Max3;
	}
}
