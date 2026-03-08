package view;

import java.util.Arrays;

import bean.NumberStatistic;

import static utils.PrintUtils.generateInt;

public class Ex01 {

	public static void main(String[] args) {
			
		int[] nums = {1, 2, 3, 4, 3, 1};
		
		nums = removeDuplicates(nums);
		
		generateInt("Mảng sau khi loại phần tử trùng lặp", nums);
		
	}
	
	private static int[] removeDuplicates(int[] nums) {
		NumberStatistic[] stats = new NumberStatistic[nums.length];
		int size = 0;
		for(int num : nums) {
			NumberStatistic existingNum = null;
			for (int i = 0; i < size; i++) {
				if(stats[i].getValue() == num) {
					existingNum = stats[i];
					break;
				}
			}
			
			if(existingNum != null) {
				existingNum.increment();
			} else {
				stats[size++] = new NumberStatistic(num);
			}
		}
		
		int[] temp = new int[size];
        int finalSize = 0;
        for (int i = 0; i < size; i++) {
            if (stats[i].getCount() == 1) {
                temp[finalSize++] = stats[i].getValue();
            }
        }

        return Arrays.copyOf(temp, finalSize);
	}
	
}
