package sorting.bubble;

import functional.StringComp;
import utils.PrintUtils;

public class Ex03BubbleSortString {
	
	public static void main(String[] args) {
		
		/*
		 Sắp xếp mảng đối tượng, giá trị của từng phần tử có thể tồn tại hoặc là NULL
		 Nếu không xử lý cho giá trị NULL --> NPE khi so sánh để hoán vị
		 
		 Xử lý
		 -----
		 B1: Xử lý cho các phần tử NULL
		     --> NULL first/last
		 
		 B2: Xử lý cho các phần tử còn lại (!NULL)
		     --> Tăng/giảm dần
		 */
		
		String[] elements = {null, null, "welcome", "JDK17", null, "Allocation", null, "Yelop", "calculate", "x6", null};
		
		sort(elements, (s1, s2) -> {
			// B1: Xử lý NULL first cho các giá trị NULL
			if (s1 == null) {
				return -1;
			}
			if (s2 == null) {
				return 1;
			}
			// B2: Xử lý sắp xếp tăng dần cho các phần tử còn lại
			return s1.compareTo(s2);
		});
		
		PrintUtils.generate("1. Sắp xếp tăng dần theo giá trị(NULL first)", elements);
		
		sort(elements, (s1, s2) -> {
			if (s1 == null) {
				return -1;
			}
			if (s2 == null) {
				return 1;
			}
			return s2.compareTo(s1);
		});
		
		PrintUtils.generate("2. Sắp xếp giảm dần theo giá trị(NULL first)", elements);
		
		sort(elements, (s1, s2) -> {
			if (s1 == null && s2 != null) {
				return 1;
			}
			if (s2 == null) {
				return -1;
			}
			return s1.compareTo(s2);
		});
		
		PrintUtils.generate("3. Sắp xếp tăng dần theo giá trị(NULL last)", elements);
		
		sort(elements, (s1, s2) -> {
			if (s1 == null && s2 != null) {
				return 1;
			}
			if (s2 == null) {
				return -1;
			}
			return s2.compareTo(s1);
		});
		
		PrintUtils.generate("4. Sắp xếp giảm dần theo giá trị(NULL last)", elements);
		
	}
	
	/**
	 * Sắp xếp: sau mỗi vòng lặp đưa phần tử lớn/nhỏ nhất sang "bên phải"(nổi bọt)
	 * 
	 * Trong mỗi vòng lặp
	 * + elements[j]: phần tử đứng trước
	 * + elements[j+1]: phần tử đứng sau
	 */
	private static void sort(String[] elements, StringComp stringComp) {
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements.length - i - 1; j++) {
				if (stringComp.compare(elements[j], elements[j+1]) > 0) {
					swap(elements, j, j+1);
				}
			}
		}
	}
	
	private static void swap(String[] elements, int i, int j) {
		String temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
}