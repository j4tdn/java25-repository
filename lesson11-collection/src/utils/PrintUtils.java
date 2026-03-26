package utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import bean.Item;

public class PrintUtils {
	
	private PrintUtils() {
	}
	
	public static <K, V> void generate(String prefix, Map<K, V> map) {
		System.out.println(prefix + " {");
		Set<Entry<K, V>> entries = map.entrySet();
		for (Entry<K, V> entry: entries) {
			System.out.println("   - " + entry.getKey() + ": " + entry.getValue());
		}
		System.out.println("}\n");
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
