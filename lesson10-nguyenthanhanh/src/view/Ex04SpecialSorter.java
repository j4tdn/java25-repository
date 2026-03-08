package view;

import static utils.PrintUtils.generate;

import java.util.Arrays;

public class Ex04SpecialSorter {

	public static void main(String[] args) {
		
		String[] arr = {"-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx"};
		sort(arr);
		
		generate("Mảng sau khi sắp xếp ASC", arr);
		
	}
	
	private static int getPriority(String item) {
		if(item == null) {
			return 5;
		}
		
		if("Special".equals(item)) {
			return 1;
		}
		
		try {
            int val = Integer.parseInt(item);
            return val < 0 ? 2 : 3;
        } catch (NumberFormatException e) {
            return 4;
        }
	}
	
	private static void sort(String[] arr) {
		Arrays.sort(arr, (item1, item2) -> {
			int p1 = getPriority(item1);
			int p2 = getPriority(item2);
			
			if(p1 != p2) {
				return Integer.compare(p1, p2);
			}
			
			if(p1 == 5) {
				return 0;
			}
			
			if(p1 == 2 || p1 == 3) {
				return Integer.compare(Integer.parseInt(item1), Integer.parseInt(item2));
			}
			
			return item1.compareTo(item2);
		});
	}
	
}
