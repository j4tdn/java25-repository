package view.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02SingleObjectType {

	public static void main(String[] args) {

		// create-add read-get update-set delete-remove
		// initial, add, set, remove, removeif, get, iterate, forEach,...

		// List --> size
		// Array --> length
		// Suc chua hien tai toi da cua Array trong ArrayList truoc khi tao Array moi
		// --> capacity

		List<String> elements = new ArrayList<>(); // java.util.ArrayList --> Dynamic size

		elements.add("a1");
		elements.add("a2");
		elements.add("a3");
		elements.add("a4");
		elements.add("a5");
		elements.add("a6");
		elements.add("A7");
		elements.add("A8");

		System.out.println("size: " + elements.size());
		
		elements.set(1,  "A3");
		elements.set(5, "A6");
		
		elements.remove(0); // By index
		elements.remove("A6"); // By object
		
		// Xoa cac phan tu co ki tu bat dau la 'A'
		// Ket qua: a2 a5 a3
		
		// removeIf(elements, e -> e.startsWith("A"));
		
		elements.removeIf(e -> e.startsWith("A"));
		
		forEachList(elements);
		forIndexList(elements);
		iterateList(elements);
		
	}
	
//	private static void removeIf(List<String> elements, StringTest testing) {
//		Iterator<String> iterator = elements.iterator();
//		while(iterator.hasNext()) {
//			String e = iterator.next();
//			if(testing.check(e))
//				iterator.remove(); // remove phan tu tai vi tri iterator dang dung
//		}
//	}

	// Duyet [bat] dong bo
	// voi duyet bat dong bo: co the luc dduyet hien tai phan tu dang o vi tri thu i nhung cung co the truy cap phan tu o vi tri k
	private static void forEachList(List<String> elements) {
		System.out.println("\nForEach --> List");
		for(String e: elements) {
			System.out.println(e + " ");
		}
	}

	
	private static void forIndexList(List<String> elements) {
		System.out.println("\nForIndex --> List");
		for(int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i) + " ");
		}
	}

	// duyet dong bo, tuan tu
	private static void iterateList(List<String> elements) {
		System.out.println("\nIterate --> List");
		Iterator<String> iterator = elements.iterator();
		while(iterator.hasNext()) {
			String e = iterator.next();
			System.out.println(e + " ");
		}
	}
}
