package utils;

import java.util.List;

import bean.Item;

public class PrintUtils {
	
	private PrintUtils() {
	}
	
	
	public static void generate(String s, List<Item> items) {
		System.out.println(s + " --> {");
		for (Item item: items) {
			System.out.println("  - " + item);
		}
		System.out.println("}\n");
	}
	
	public static void generateString(String s, List<String> items) {
		System.out.println(s + " --> {");
		for (String item: items) {
			System.out.println("  - " + item);
		}
		System.out.println("}\n");
	}
	
}