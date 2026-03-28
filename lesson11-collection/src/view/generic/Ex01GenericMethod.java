package view.generic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import functional.Condition;

public class Ex01GenericMethod {

	public static void main(String[] args) {
		Integer[] ints = { 1, 2, 3, 4, 5 };
		Double[] dobs = { 1d, 2d, 3d, 4d, 5d };
		String[] strs = { "a", "b", "c", "d", "e" };
		
		print("1. ints", ints);
		print("2. dobs", dobs);
		print("3. strs", strs);
		
		System.out.println("===== Sử dụng Generic Method =====\n");
		
		generate("1. ints", ints);
		generate("2. dobs", dobs);
		// generate("3. strs", strs);
		
		System.out.println("===== Sử dụng Generic Method [List] =====\n");
		
		List<Integer> intList = List.of(1, 2, 3, 4, 5);
		List<Double> dobList = List.of(1d, 2d, 3d, 4d, 5d);
		List<String> strList = List.of("a", "b", "c", "d", "e");
		List<Object> objList = List.of("a", 1, "c", 40d, "e", LocalDate.now());
		
		printList("1. intList", intList);
		printList("2. dobList", dobList);
		printList("3. strList", strList);
		printList("4. objList", objList);
		
		System.out.println("==== Test Filter ====\n");
		
		printList("1. intList(filtered)", filter(intList, intE -> intE > 2));
		printList("3. strList(filtered)", filter(strList, str -> str.compareTo("c") > 0));
		
	}
	
	private static <E> List<E> filter(List<E> elements, Condition<E> condition) {
		List<E> result = new ArrayList<>();
		for(E element: elements) {
			if (condition.test(element)) {
				result.add(element);
			}
		}
		return result;
	}
	
	
	// Tham số là
	// List<Object> bắt buộc bên ngoài truyền vào phải là List<Object>
	// List<T> bên ngoài truyền vào là List<KDL đối tượng cho T>
	private static <E> void printList(String prefix, List<E> elements) {
		System.out.println(prefix + " ----> {" );
		for (E element: elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}
	
	// Cách 2: Sử dụng generic type là tham số cho method --> generic method
	// <Element>: khai báo generic type tên là Element cho hàm print
	//          : phạm vi sử dụng trong hàm print
	//          : nhận vào 1 KDL đối tượng(ko giới hạn thì = Object)
	// Dùng từ khóa extends, super để giới hạn, mở rộng KDL cho Element
	//          : T extends X --> T có thể nhận vào KDL X hoặc con của nó

	private static <E extends Number> void generate(String prefix, E[] elements) {
		System.out.println(prefix + " ----> {" );
		for (E element: elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}
	
	// Cách 1: Vận dụng tính chất kết thừa và đa hình trong đối tượng
	private static void print(String prefix, Object[] elements) {
		System.out.println(prefix + " ----> {" );
		for (Object element: elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}
}