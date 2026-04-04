package view.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.PrintUtils.*;

public class Ex06ListInitialData {

	public static void main(String[] args) {
		
		// Array --> new Type[] {...}
		
		// 1st
		// dynamic ArrayList
		// Allow to add, remove, get, set
		List<String> list1 = new ArrayList<String>();
		list1.add("A1"); list1.add("A2");
		System.out.println("list1: " + list1.size());
		
		generateStrings("1. list1", list1);
		
		// 2nd
		// Fixed-size ArrayList
		List<String> list2 = Arrays.asList("A2", "B2", "C2");
		generateStrings("2. list2", list2);
		
		// 3rd
		// unmodified list
		// only allow to get, throw NPE if assign null values
		List<String> list3 = List.of("A3", "C3", "B3");
		generateStrings("3. list3", list3);
		
		// 4th
		// copyOf
		List<String> list4 = new ArrayList<String>(list3);
		list4.add("D4");
		list4.set(0, "A4");
		generateStrings("4. list4", list4);
		
	}
	
}
