package video_array;

import java.util.Arrays;

/*
	 * Tìm những phần tử lẻ trong mảng số nguyên
	 * Input: Mảng
	 * Output Mảng số lẻ
	 */
public class Ex02Filter {
	public static void main(String[] args) {
		 
		int[] numbers = {23,25,18,20,31,33};
		System.out.print("phần tử lẻ là: " );
		int[] OddNumbers = FindOddNumbers(numbers);
		System.out.println(Arrays.toString(OddNumbers));
	}
	
	private static int[] FindOddNumbers(int[] elements) {
		int count =0;
		int[] oddElements = new int[elements.length];
		for(int element : elements) {
			if(element %2 !=0) {
				oddElements[count]= element;
				count++;
			}
		}
		int[] result = new int[count];
		for(int i =0; i<count;i++) {
			result[i] = oddElements[i];
		}
		return result;
	}
}
