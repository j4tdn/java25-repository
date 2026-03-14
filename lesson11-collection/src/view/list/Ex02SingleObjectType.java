package view.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import functional.StringTest;

public class Ex02SingleObjectType {

	public static void main(String[] args) {
		// initial, add, set, remove, removeIf, get, iterate, forEach, forIndex

		List<String> elements = new ArrayList<>(); // import java.util.ArrayList -- Dynamic Type

		elements.add("a1");
		elements.add("a2");
		elements.add("a3");
		elements.add("a4");
		elements.add("a5");
		elements.add("a6");
		elements.add("A7");
		elements.add("A8");

		elements.set(1, "A3");
		elements.set(5, "A6");
		
		elements.remove(0);
		elements.remove("A6");
		
		// Xóa các phần tử có kí tự bắt đầu là A
//		elements.removeIf(s -> s.startsWith("A"));
		
		
		forEachList(elements);
		forIndexList(elements);
		iterateList(elements);

		System.out.println("\nsize: " + elements.size());
		
		
	}
	
	private static void removeIf(List<String> elements, StringTest testing) {
		Iterator<String> iterator = elements.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			if(testing.check(element)) {
				iterator.remove(); // remove phần tử tại vị trí iterator đang đứng
			}
		}
	}

	// duyệt [bất] đồng bộ
	// với duyệt bất đồng bộ: có thể lúc duyệt hiện tại phần tử đang ở vị trí thứ i nhưng cũng có thể truy cập phần tử ở vị trí k
	private static void forEachList(List<String> elements) {
		System.out.println("ForEach --> List");
		for (String element : elements) {
			System.out.print(element + " ");
		}
	}

	private static void forIndexList(List<String> elements) {
		System.out.println("\nForIndex --> List");
		for (int i = 0; i < elements.size(); ++i) {
			System.out.print(elements.get(i) + " ");
		}
	}

	// duyệt đồng bộ, tuần tự
	private static void iterateList(List<String> elements) {
		System.out.println("\nIterate --> List");
		Iterator<String> iterator = elements.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.print(element+" ");
		}
	}
}
