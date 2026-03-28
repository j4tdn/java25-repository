package util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import bean.Item;

public class PrintUtils {

	public PrintUtils() {
	}
	
	public static <K, V> void generate(String s, Map<K, V> map) {
		System.out.println(s + "\n");
		Set<Entry<K, V>> entries = map.entrySet();
		for(Entry<K, V> entry: entries) {
			System.out.println("  - " + entry.getKey() + ": " + entry.getValue());
		}
		System.out.println("\n");
	}
	
	public static <E> void generate(String s, Collection<E> es) {
		System.out.println(s + "\n");
		for(E e: es) {
			System.out.println("  - " + e);
		}
		System.out.println("\n");
	}
	
	public static void generateItems(String s, List<Item> items) {
		System.out.println(s + "\n");
		for(Item item: items) {
			System.out.println("  - " + item);
		}
		System.out.println("\n");
	}
	
	public static void generateStrings(String s, List<String> elements) {
		System.out.println(s + "\n");
		for(String e: elements) {
			System.out.println("  - " + e);
		}
		System.out.println("\n");
	}
}

