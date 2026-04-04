package view.generic;

import java.util.ArrayList;
import java.util.List;

import functional.Condition;

public class Ex01GenericMethod {

	public static void main(String[] args) {
		Integer[] ints = { 1, 2, 3, 4, 5 };
		Double[] dobs = { 1d, 2d, 3d, 4d, 5d };
		String[] strs = { "a", "b", "c", "d", "e" };

		List<Integer> intList = List.of(1, 2, 3, 4, 5);
		List<String> strList = List.of("a", "b", "c", "d", "e");
		
		generate("1. ints", dobs);

		System.out.println(" ===== Sử dụng Generic Method [List] ======\n");
		printList("1. intList", intList);

		System.out.println("========= Test Filter ============");
		printList("1. intList(filtered)", filter(intList, intE -> intE > 2));
//		printList("3. intList(filtered)", filter(, intE -> intE > 2));
	}

	private static <E> List<E> filter(List<E> elements, Condition<E> condition) {
		List<E> result = new ArrayList<>();
		for (E element : elements) {
			if (condition.test(element)) {
				result.add(element);
			}
		}
		return result;
	}

	// Cách 1: vận dụng kế thừa và đa hình trong đối tượng

	private static void print(String prefix, Object[] elements) {
		System.out.println(prefix + " -------> {");
		for (Object element : elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}

	// Cách 2: sử dụng generic type là tham số cho method --> generic method
	// <Element>: Khai báo generic type tên là Element cho hàm print
	// : phạm vi sử dụng trong hàm print
	// : nhận vào 1 KDL đối tượng(không giới hạn thì = Object)
	// Dùng từ khóa extends, super để giới hạn, mở rộng KDL cho Element
	// : T extends X --> T có thể nhận KDL X hoặc con của nó
	// super --> cha (chỉ dùng cho wildcard)

	private static <Element extends Number> void generate(String prefix, Element[] elements) {
		System.out.println(prefix + " -------> {");
		for (Element element : elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}

	private static <E> void printList(String prefix, List<E> elements) {
		System.out.println(prefix + " -------> {");
		for (E element : elements) {
			System.out.println("- " + element);
		}
		System.out.println("}\n");
	}
}