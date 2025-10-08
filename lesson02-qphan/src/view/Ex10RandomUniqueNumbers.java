package view;

import java.util.Arrays;
import java.util.Random;

public class Ex10RandomUniqueNumbers {
	
	private static Random rd = new Random();
	
	public static void main(String[] args) {
		// Random 5 số nguyên ngẫu nhiên [20, 30]
		// Yêu cầu các phần tử không trùng nhau
		
		System.out.println("Số nguyên ngẫu nhiêu: " + Arrays.toString(random(5, 20, 30)));
		
	}
	
	private static int[] random(int amountOfElements, int fromIncl, int endIncl) {
		int[] result = new int[amountOfElements];
		
		int i = 0;
		while(i < amountOfElements) {
			int element = rd.nextInt(fromIncl, endIncl + 1); 
			if (!isExist(result, element, i)) {
				result[i] = element;
				i++;
			}
		}
		
		return result;
	}
	
	private static boolean isExist(int[] elements, int element, int currentIndex) {
		for (int i = 0; i < currentIndex; i++) {
			if (element == elements[i]) {
				return true;
			}
		}
		return false;
	}
	
}
