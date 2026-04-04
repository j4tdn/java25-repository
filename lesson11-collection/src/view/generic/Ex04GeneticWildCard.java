package view.generic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.Item;
import model.DataModel;

public class Ex04GeneticWildCard {

	public static void main(String[] args) {
		List<Integer> intList = List.of(1, 2, 3, 4, 5);
		List<String> strList = List.of("a", "b", "c", "d", "e");
		List<Number> numberList = List.of(1d, 2f, 3l, 4d, 5);
		List<CharSequence> charSequenceList = List.of("a", new StringBuilder("b"), "c","d","e");
		List<Object> objList = List.of("a",1,"c",40d,"e",LocalDate.now());
		
		List<Item> items = DataModel.mockItems();
	}
	
	private static <T,R> List<R> mapping(List<T> list, Function<T, R> func) {
		List<R> target = new ArrayList<>();
		for(T item: list) {
			target.add(func.apply(item));
		}
		return target;
	}
	
	private static void generate(String prefix, List<?> elements) {
		System.out.println(prefix + "----> (");
		for(Object element: elements) {
			System.out.println("- " +element);
		}
		System.out.println(")\n");
	}
}