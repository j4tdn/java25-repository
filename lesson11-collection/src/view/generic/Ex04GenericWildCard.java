package view.generic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.Item;
import functional.Condition;
import model.DataModel;

public class Ex04GenericWildCard {
	
	public static void main(String[] args) {
		
		List<Integer> intList = List.of(1, 2, 3, 4, 5);
		List<Double> dobList = List.of(1d, 2d, 3d, 4d, 5d);
		List<Number> numberList = List.of(1d, 2f, 3l, 4d, 5);
		List<String> strList = List.of("a", "b", "c", "d", "e");
		List<CharSequence> charSequenceList = List.of("a", new StringBuilder("b"), "c", "d", "e");
		List<Object> objList = List.of("a", 1, "c", 40d, "e", LocalDate.now());
		
		generate("1. intList", intList, (Number number) -> number.intValue() > 1);
		// generate("2. dobList", dobList);
		// generate("3. numberList", numberList);
		
		
		// generate("4. strList", strList);
		// generate("5. charSequenceList", charSequenceList);
		// generate("6. objList", objList);
		
		List<Item> items = DataModel.mockItems();
		// lấy danh sách itemId
		// lấy danh sách itemName
		
		List<String> letters = List.of("A", "K", "c", "d", "W");
		// lấy ra vị trí trong bảng mã ASCII --> số
		
		generate("1. Danh sách mã mặt hàng", mapping(items, item -> item.getId()));
		generate("2. Danh sách tên mặt hàng", mapping(items, item -> item.getName()));
		generate("3. Chuyển đôi sang KDL byte(s)", mapping(letters, letter -> (byte)letter.charAt(0)));
		
	}
	
	// T strategy(Item item)
	
	// E: KDL của từng phần tử truyền vào
	// T: KDL của từng phần tử lấy ra
	private static <T, R> List<R> mapping(List<T> list, Function<T, R> func) {
		List<R> target = new ArrayList<>();
		for(T item: list) {
			target.add(func.apply(item));
		}
		return target;
	}
	
	private static void generate(String prefix, List<?> elements) {
		System.out.println(prefix + " ----> {" );
		for (Object element: elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}
	
	
	private static void generate(String prefix, List<Integer> elements, Condition<? super Integer> condition) {
		System.out.println(prefix + " ----> {" );
		for (Integer element: elements) {
			if (condition.test(element)) {
				System.out.println("- " + element);
			}
		}
		System.out.println("}\n");
	}
	
}
