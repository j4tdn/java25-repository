package utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import bean.Item;

public class PrintUtils {
	
	private PrintUtils() {
	}
	
	public static <K, V> void generate(String prefix, Map<K, V> map) {
		System.out.println(prefix + " --> {");
		Set<Entry<K,V>> entries = map.entrySet();
		for(var entry: entries) {
			System.out.println("    - "+entry.getKey()+" " +entry.getValue() );
		}
		System.out.println("}\n");
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