package utils;

import java.util.List;

import bean.Item;

public class PrintUtils {
	
	private PrintUtils() {
	}
	
	public static void generateStrings(String s, List<String> elements) {
		System.out.println(s + " --> {");
		for (String element: elements) {
			System.out.println("  - " + element);
		}
		System.out.println("}\n");
	}
	
	public static void generateItems(String s, List<Item> items) {
		System.out.println(s + " --> {");
		for (Item item: items) {
			System.out.println("  - " + item);
		}
		System.out.println("}\n");
	}
}
