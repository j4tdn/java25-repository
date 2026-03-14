package sorting.bubble;

import function.lambda.StringComp;
import utils.PrintUtils;

public class Ex03BubbleSortString {

	public static void main(String[] args) {
		/*
		 Sap xep mang doi tuong, gia tri cua tung phan tu co the ton tai hoac NULL
		 Neu khong xu ly gia tri NULL --> NPE khi so sanh de hoan vi
		 
		 Xu ly
		 ----
		 B1: Xu ly cac phan tu NULL
		 	--> NULL first/last
		 
		 B2: Xu ly cho cac phan tu con lai (!NULL)
		 	--> tang/giam dan
		 */
		
		String[] elements = { null, null, "welcome", "JDK17", null, "Allocation", null, "Yelop", "calculate", "x6",
				null };

		sort(elements, (s1, s2) -> {
			if(s1 == null) {
				return -1;
			}
			if(s2 == null) {
				return 1;
			}
			return s1.compareTo(s2);
		});

		PrintUtils.generate("1. Sắp xếp tăng dần (NULL first)", elements);


		sort(elements, (s1, s2) -> {
			if(s1 == null) {
				return -1;
			}
			if(s2 == null) {
				return 1;
			}
			return s2.compareTo(s1);
		});
		
		
		PrintUtils.generate("2. Sắp xếp giảm dần (NULL first)", elements);
		
		
		sort(elements, (s1, s2) -> {
			if(s1 == null && s2 != null) {
				return 1;
			}
			if(s2 == null) {
				return -1;
			}
			return s1.compareTo(s2);
		});
		PrintUtils.generate("2. Sắp xếp tăng dần (NULL last)", elements);
	}

	private static void sort(String[] elements, StringComp stringComp) {
		for (int i = 0; i < elements.length; ++i) {
			for (int j = 0; j < elements.length - i - 1; ++j) {
				if (stringComp.compare(elements[j], elements[j + 1]) > 0) {
					swap(elements, j, j + 1);
				}
			}
		}
	}

	private static void swap(String[] elements, int i, int j) {
		String tmp = elements[i];
		elements[i] = elements[j];
		elements[j] = tmp;
	}

}
