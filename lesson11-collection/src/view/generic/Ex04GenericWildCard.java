package view.generic;

import java.time.LocalDate;
import java.util.List;

import bean.Item;
import model.DataModel;

public class Ex04GenericWildCard {

	public static void main(String[] args) {
		
		List<Integer> intList = List.of(1, 2, 3, 4, 5);
		List<Double> dobList = List.of(1d, 2d, 3d, 4d, 5d);
		List<Number> numberList = List.of(1d, 2f, 3l, 4d, 5d);
		List<String> strList = List.of("a", "b", "c", "d", "e");
		List<CharSequence> CharSequenceList = List.of("a", new StringBuilder("b"), "c", "d", "e");
		List<Object> objList = List.of("a", "b", 1, "c", 40d, LocalDate.now());
		
		generate("1. intList", intList, number -> number > 1);
//		generate("2. dobList", dobList);
//		generate("3. objList", numberList);
//		generate("4. strList", strList);
//		generate("5. CharSequenceList", CharSequenceList);
//		generate("6. objList", objList);
		
		List<Item> items = DataModel.mockItems();
		// Lay DS itemId
		// Lay DS itemName
		
	}
	
	private static <E> void generate(String prefix, List<E> es, functional.Condition<? super E> condition) {
		System.out.println(prefix + " ---> {");
		for(E e: es) {
			if(condition.test(e)) {
				System.out.println("- " + e);
			}
		}
		System.out.println("}\n");
	}
}
