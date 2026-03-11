package view.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02SingleObjectType {
	
	public static void main(String[] args) {
		// create-add read-get update-set delete-remove
		// initial, add, set, remove, removeIf, get, iterate, forEach, forIndex ...
		
		// List --> size
		// Array --> length
		// Sức chứa hiện tại tối đa của Array trong ArrayList trước khi tạo Array mới --> capacity
		
		List<String> elements = new ArrayList<>(); // java.util.ArrayList --> Dynamic Size
		elements.add("a1"); elements.add("a6");
		elements.add("a2"); elements.add("a5");
		elements.add("a3"); elements.add("a4");
		elements.add("A7"); elements.add("A8");
		
		System.out.println("size: " + elements.size());
		
		elements.set(1, "A3");
		elements.set(5, "A6");
		
		elements.remove(0); // by index
		elements.remove("A6"); // by object
		
		// A3 a2 a5 a3 A7 A8 
		
		// Xóa các phần tử có kí tự bắt đầu là 'A'
		// Kết quả: a2 a5 a3
		// removeIf(elements, e -> e.startsWith("a")); // tự viết
		
		elements.removeIf(e -> e.startsWith("A"));
		
		
		forEachList(elements);
		forIndexList(elements);
		iterateList(elements);
	}
	
	/*
	private static void removeIf(List<String> elements, StringTest testing) {
		Iterator<String> iterator = elements.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			if (testing.check(element)) {	
				iterator.remove(); // remove phần tử tại vị trí iterator đang đứng
			}
		}
	}
	*/
	
	// duyệt [bất] đồng bộ
	// với duyệt bất đồng bộ: có thể lúc duyệt hiện tại phần tử đang ở vị trí thứ i nhưng cũng có thể truy cập phần tử ở vị trí k
	private static void forEachList(List<String> elements) {
		System.out.println("\nForEach ---> List");
		for (String element: elements) {
			System.out.print(element + " ");
		}
	}

	private static void forIndexList(List<String> elements) {
		System.out.println("\n\nForIndex ---> List");
		for (int i = 0; i < elements.size(); i++) {
			System.out.print(elements.get(i) + " ");
		}
	}

	// duyệt đồng bộ, tuần tự
	private static void iterateList(List<String> elements) {
		System.out.println("\n\nIterate ---> List");
		Iterator<String> iterator = elements.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.print(element + " ");
		}
	}
	
}
