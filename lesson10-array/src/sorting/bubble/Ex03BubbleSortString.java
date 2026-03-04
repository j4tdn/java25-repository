package sorting.bubble;

import function.StringComp;
import util.PrintUtils;

public class Ex03BubbleSortString {

	public static void main(String[] args) {
		
		/*
		 SX mang ddoi tuong, gia tri cua tung phan tu co the ton tai hoac la NULL
		 Neu k xu ly cho gia tri la NULL --> NPE khi so sanh de hoan vi
		 
		 Xu ly
		 ---------
		 B1: Xu ly cho cac phan tu NULL
		 	--> NULL first/last
		 
		 B2: Xu ly cho cac phan tu con lai (!NULL)
		 	--> Tang/giam dan
		 */
		
		String[] elements = {null, null, "Welcome", null, "JDK17", null, "Allocation", "Yelop", "Calculate", "x6", null};
		sort(elements, (s1, s2) -> {
			//B1: Xu ly NULL first cho cac gia tri NULL
			if(s1 == null) {
				return -1;
			}
			if(s2 == null) {
				return 1;
			}
			//B2: Xu ly sx tang dadn cho cac phan tu con lai
			return s1.compareTo(s2);
		});
		PrintUtils.generate("1. SX tang dan theo gia tri (NULL first)", elements);
		
		sort(elements, (s1, s2) -> {
			//B1: Xu ly NULL first cho cac gia tri NULL
			if(s1 == null) {
				return -1;
			}
			if(s2 == null) {
				return 1;
			}
			//B2: Xu ly sx tang dadn cho cac phan tu con lai
			return s2.compareTo(s1);
		});
		PrintUtils.generate("2. SX giam dan theo gia tri (NULL first)", elements);
		
		sort(elements, (s1, s2) -> {
			//B1: Xu ly NULL first cho cac gia tri NULL
			if(s1 == null && s2 != null) {
				return 1;
			}
			if(s2 == null) {
				return -1;
			}
			//B2: Xu ly sx tang dadn cho cac phan tu con lai
			return s1.compareTo(s2);
		});
		PrintUtils.generate("3. SX tang dan theo gia tri (NULL last)", elements);
		
		sort(elements, (s1, s2) -> {
			//B1: Xu ly NULL first cho cac gia tri NULL
			if(s1 == null && s2 != null) {
				return 1;
			}
			if(s2 == null) {
				return -1;
			}
			//B2: Xu ly sx tang dadn cho cac phan tu con lai
			return s2.compareTo(s1);
		});
		PrintUtils.generate("4. SX giam dan theo gia tri (NULL last)", elements);
	}
	
	private static void sort(String[] elements, StringComp stringComp) {
		for(int i = 0; i < elements.length; i++) {
			for(int j = 0; j < elements.length - i - 1; j++) {
				if(stringComp.compare(elements[j], elements[j+1]) > 0) {
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
