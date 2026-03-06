package assignments;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static utils.PrintUtils.*;

import bean.Pair;

public class Ex01 {
	public static void main(String[] args) {
		Random rand = new Random();

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng phần tử cho mảng (n < 10): ");
		int n = 0;

		do {
			n = Integer.parseInt(sc.nextLine());
			if (n >= 10) {
				System.out.println("Số lượng phần tử phải nhỏ hơn 10. Vui lòng nhập lại");
			} else {
				break;
			}
		} while (true);

		int[] arr = new int[n];

		for (int i = 0; i < n; ++i) {
			arr[i] = rand.nextInt(50) + 1;
		}
		
		generate("1. Mảng ban đầu", arr);

		int[] results = removeDuplicateElement(arr);
		generate("2. Loại bỏ phần tử trùng nhau trong mảng", arr);
		
		System.out.println();
		
		compareHalfFirstAndHalfLast(arr);
		
		System.out.println("4. Số lớn nhất thứ ba trong mảng: "+getThe3rdMaxElement(arr));

	}
	
	private static void compareHalfFirstAndHalfLast(int[] arr) {
		int mid = arr.length / 2;
		int sumOfHalfFirst = 0;
		int sumOfHalfLast = 0;
		
		int quantity = arr.length;
		
		for(int i = 0; i< mid;++i) {
			sumOfHalfFirst+= arr[i];
		}
		
		if(quantity % 2 == 1) {
			for(int i = mid+1;i<quantity;++i) {
				sumOfHalfLast+=arr[i];
			}
		} else {
			for(int i = mid;i<quantity;++i) {
				sumOfHalfLast+=arr[i];
			}
		}
		
		double avgFirst = sumOfHalfFirst / mid;
		double avgLast = sumOfHalfLast / mid;
		
		if(avgFirst > avgLast) {
			System.out.printf("3. Trung bình nửa đầu (%.2f) > Trung bình nửa cuối (%.2f)\n", avgFirst,avgLast);
		} else if(avgFirst < avgLast) {			
			System.out.printf("3. Trung bình nửa đầu (%.2f) < Trung bình nửa cuối (%.2f)\n", avgFirst,avgLast);
		}else {
			System.out.printf("3. Trung bình nửa đầu (%.2f) = Trung bình nửa cuối (%.2f)\n", avgFirst,avgLast);
		}
		
	}
	
	private static int getThe3rdMaxElement(int[] arr) {
		Pair[] pairs = statisticElement(arr);
		
		Arrays.sort(pairs, (n1,n2) -> {
			return n2.getValue() - n1.getValue();
		});
		
		return pairs[2].getValue();
	}
	
	private static int[] removeDuplicateElement(int[] arr) {
		Pair[] pairs = statisticElement(arr);
		
		int[] results = new int[arr.length];
		int counter = 0;
		for(int i = 0;i<pairs.length;++i) {
			if(pairs[i].getCount() == 1) {
				results[counter++] = pairs[i].getValue();
			}
		}
		
		return Arrays.copyOfRange(results, 0, counter);
	}
	
	private static Pair[] statisticElement(int[] arr) {
		Pair[] pairs = new Pair[arr.length];
		int counter = 0;
		for(int i = 0;i<arr.length;++i) {
			Pair found = get(arr[i], pairs, counter);
			if(found != null) {
				found.plusCount();
			}else {
				pairs[counter++] = new Pair(arr[i], 1);
			}
		}
		return Arrays.copyOfRange(pairs, 0, counter);
	}
	
	private static Pair get(int value, Pair[] pair, int counter) {
		Objects.requireNonNull(value,"value không được là giá trị null");
		for(int i = 0;i<counter;++i) {
			if(pair[i].getValue() == value) {
				return pair[i];
			}
		}
		return null;
	}
}
