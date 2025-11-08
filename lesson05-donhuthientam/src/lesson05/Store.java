package lesson05;

import java.util.ArrayList;
import java.util.List;

public class Store {
	public static void main(String[] args) {

	}

	private static List<TextBook> book() {
		List<TextBook> list1 = new ArrayList<>();
		list1.add(new TextBook("SGK1", 100, "NHI DONG", "NEW"));
		list1.add(new TextBook("SGK2", 200, "NHU HAI", "OLD"));
		list1.add(new TextBook("SGK3", 300, "NGUYEN VAN A", "NEW"));

		return list1;
	}

	private static List<ReferenceBook> books() {
		List<ReferenceBook> list2 = new ArrayList<ReferenceBook>();

		list2.add(new ReferenceBook("STK1", 40, "NHI DONG", 3));
		list2.add(new ReferenceBook("STK2", 40, "NHI DONG", 3));
		list2.add(new ReferenceBook("STK3", 40, "NHI DONG", 3));
		return list2;
	}

}
