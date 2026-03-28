package view.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static utils.PrintUtils.*;

public class Ex06ListInitialData {
	public static void main(String[] args) {
		
		
		//1st
		//Dynamic java.util.ArrayList
		//Allow to add, remove, get, set
		List<String> list1 = new ArrayList<>();
		list1.add("A1");
		list1.add("A2");
		generateStrings("1. List1", list1);
		
		
		//2nd
		//Fixed-size java.util.Arrays.ArrayList
		//Allow to get/set
		List<String> list2 =  Arrays.asList("A2", "B2", "C3");
		generateStrings("2. List2", list2);
		
		
		//3rd
		//Umodifiable list
		//allow to get, throw NPE if assign null values
		List<String> list3 = List.of("A3", "B3", "C3");
		generateStrings("3. List3", list3);
		
		//4th
		//CopyOf
		List<String> list4 = new ArrayList<>(list3);
		list4.add("D4");
		list4.set(0, "X4");
		generateStrings("4. List4", list4);
		
	}
}
