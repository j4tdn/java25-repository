package view;

import java.util.Arrays;

public class Ex04GetUniqueNumbers {

	public static void main(String[] args) {
		System.out.println("{3, 15, 21, 0, 15, 17, 21} --> " + 
				Arrays.toString(getUniqueNumbers(new int[] {3, 15, 21, 0, 15, 17, 21})));
	}
	
	private static int[] getUniqueNumbers(int[] nums) {
		int[] appearanceNums = new int[100];
		for(int num : nums) {
			if(num >= 0 && num <= 100) {
				appearanceNums[num]++;
			}
		}
		
		System.out.println(Arrays.toString(appearanceNums));
		
		int countOfUniqueNums = 0;
		for(int i = 1; i < appearanceNums.length; i++) {
			if(appearanceNums[i] == 1) {
				countOfUniqueNums++;
			}
		}
		
		System.out.println(countOfUniqueNums);
		
		int[] uniqueNums = new int[countOfUniqueNums + 1];
		int index = 0;
		for(int i = 0; i <= appearanceNums.length - 1; i++) {
			if(appearanceNums[i] == 1) {
				uniqueNums[index] = i;
				index++;
			}
		}
		return uniqueNums;
	}
	
}
