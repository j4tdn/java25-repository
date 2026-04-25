package view.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import functional.StringTest;

public class Ex02SingleObjectType {
	
	public static void main(String[] args) {
		// initial, add, set, remove, removeIf, get, iterate, forEAch, forIndex ...
		
		// List --> size
		// Array --> length
		// Sức chức hiện tại tối đa của array trong ArayList trước khi tạp array mới --> capacity
		List<String> elements = new ArrayList<>(); //Dynamic size
		elements.add("a1"); elements.add("a6");
		elements.add("a2"); elements.add("a5");
		elements.add("a3"); elements.add("a4");
		elements.add("A7"); elements.add("A8");
		
		System.out.println("Size: " + elements.size());
		
		elements.set(1, "A3");
		elements.set(5, "A6");
		
		elements.remove(0); // by index
		elements.remove("A6"); // by object
		
		// xóa các phần tử có ký tự bắt đầu là 'A'
		// Kết quả là: a2 a5 a3
		
		elements.removeIf(e -> e.startsWith("A")); 
		
		
		forEachList(elements);
		forIndexList(elements);
		iterateList(elements);
		
		
	}
	
//	private static void removeIf(List<String> elements, StringTest testing ) {
//		Iterator<String> iterator = elements.iterator();
//		while(iterator.hasNext()) {
//			String element = iterator.next();
//			if(testing.check(element)) {
//				iterator.remove();
//			}
//		}
//	}
	
	// duyệt [bất] động bộ
	// với duyệt bất đồng bộ: có thể  lúc duyệt hiện tại phần tử đang ở vị trí thứ i nhưng cũng có thể truy cập phần tử ở vị trí k
	private static void forEachList(List<String> elements) {
		System.out.println("\nforEach --> List");
		for(String element: elements) {
			System.out.print(element + " ");
		}
	}

	private static void forIndexList(List<String> elements) {
		System.out.println("\n\nforIndex --> List");
		for(int i = 0; i < elements.size(); i++) {
			System.out.print(elements.get(i) + " ");
		}
	}

	// duyệt đồng bộ, tuần tự
	private static void iterateList(List<String> elements) {
		System.out.println("\n\nIterate --> List");
		Iterator<String> iterator = elements.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.print(element + " ");
		}
	}

}
