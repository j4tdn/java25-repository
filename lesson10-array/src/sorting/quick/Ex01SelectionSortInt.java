package sorting.quick;

import static utils.PrintUtils.generate;

import bean.SortOrder;
import utils.ArrayUtils;

public class Ex01SelectionSortInt {

	public static void main(String[] args) {
		// Sử dụng hàm sort có sẵn của Java --> DualPivotQuickSort.class
		// Với từng mảng với kích thước phù hợp --> cho method sort tương ứng
		
		
		// Sắp xếp mảng nguyên thủy
		// --> Chỉ hỗ trợ sắp xếp tăng dần
		
		int[] numbers = { 4, 2, 8, 5, 0, 9, 1 };

		generate("0. Danh sách các phần tử", numbers);
		
		ArrayUtils.sort(numbers);
		
		generate("1. Sắp xếp tăng dần", numbers);
		
		ArrayUtils.sort(numbers, SortOrder.DESC);
		
		generate("2. Sắp xếp giảm dần", numbers);
		
		// Arrays#sort --> String, Item ...
		// Comparable, Comparator
	}
	
}