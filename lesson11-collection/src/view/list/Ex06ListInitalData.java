package view.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.PrintUtils.*;

public class Ex06ListInitalData {
	
	public static void main(String[] args) {
		// Array --> new type[]{....}
		
		List<String> list1 = new ArrayList<>();
		list1.add("A1"); list1.add("B1");
		generateStrings("1. list1", list1);
		
		
		//2nd
		//Fixed-size java.util.Arays.ArayList
		// Allow to get/set
		List<String> list2 = Arrays.asList("A2", "B2", "C2");
		list2.set(1, "x2");
		generateStrings("2. list2", list2);
		
		//3rd
		//unmodifiable List
		// Allow to get, throws NPE if assign null values
		List<String> list3 = List.of("A3", "B3", "C3");
		generateStrings("3. list3", list3);
		
		//4rd
		List<String> list4 = new ArrayList<>(list3);
		list4.add("D4");
		list4.set(0, "X4");
		generateStrings("4. list4", list4);
	}

}
