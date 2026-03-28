package utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	
	public static <T> void generate(String prefix, Set<T> set) {
		System.out.println(prefix + " {");
		for (T element : set) {
			System.out.println("   - " + element);
		}
		System.out.println("}\n");
	}
	public static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}

	public static LocalDate toDate(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(dateStr, formatter);
	}
}