package utils;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public class PrintUtils {
	
	private PrintUtils() {
	}
	
	public static <Element> void generate(String prefix, Element[] elements) {
		System.out.println(prefix + "{");
		for (Element element: elements) {
			System.out.println("   - " + element);
		}
		System.out.println("}\n");
	}
	
	public static <K, V> void generate(String prefix, Map<K, V> map) {
		System.out.println(prefix + "{");
		for (Entry<K, V> entry: map.entrySet()) {
			System.out.println("   - " + entry);
		}
		System.out.println("}\n");
	}
	
	public static <Element> void generate(String prefix, Collection<Element> elements) {
		System.out.println(prefix + "{");
		for (Element element: elements) {
			System.out.println("   - " + element);
		}
		System.out.println("}\n");
	}
	
}
