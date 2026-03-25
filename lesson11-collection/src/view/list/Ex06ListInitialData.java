package view.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static utils.PrintUtils.*;

public class Ex06ListInitialData {

	public static void main(String[] args) {
		// 1st
		// Dynamic ArrayList
		// Allow to add, remove, get, set
		List<String> list1 = new ArrayList<>();
		list1.add("A1");
		list1.add("B1");
		generateString("1. List1", list1);
		
		// 2nd
		// Fixed-size java.util.Arrays.ArrayList
		// Allow to get/set
		List<String> list2 = Arrays.asList("A2","B2","C2");
		
		
		// 3rd
		// Unmodifiable List
		// Allow to get, throw NPE if assign null values
		List<String> list3 = List.of("A3", "B3", "C3");
		generateString("2. List3", list3);
		
		// 4th
		List<String> list4 = new ArrayList<>(list3);
		list4.add("D4");
		list4.set(0, "X4");
		generateString("3. List4", list4);
	}

}
