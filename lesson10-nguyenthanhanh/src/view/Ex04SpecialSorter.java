package view;

import static utils.NumberUtils.*;

import java.util.Arrays;

public class Ex04SpecialSorter {

	public static void main(String[] args) {
		
		String[] arr = {"-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx"};
		sort(arr);
		
	}
	
	private static int getPriority(String item) {
		if(item == null) {
			return 5;
		}
		
		if("Special".equals(item)) {
			return 1;
		}
		
		if(isValidNumber(item)) {
			return Integer.parseInt(item) < 0 ? 2 : 3;
		}
		
		return 4;
	}
	
	private static void sort(String[] arr) {
		Arrays.sort(arr, (item1, item2) -> {
			int p1 = getPriority(item1);
			int p2 = getPriority(item2);
			
			if(p1 != p2) {
				return p2 - p1;
			}
			
			if(p1 == p2) {
				return Integer.compare(p1, p2);
			}
			
			return item1.compareTo(item2);
		});
	}
	
}
