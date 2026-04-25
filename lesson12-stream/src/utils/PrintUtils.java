package utils;

import java.util.Collection;
import java.util.Map;

public class PrintUtils {

	private PrintUtils() {
		
	}
	
	public static <K,V> void generate(String prefix, Map<K,V> map) {
		generate(prefix, map.entrySet());
	}
	
	
	public static <Element> void generate(String prefix, Element[] elements) {
		System.out.println(prefix + " {");
		for(Element element: elements) {
			System.out.println("    - " + element);
		}
		System.out.println("}\n");
	}
	
	public static <Element> void generate(String prefix, Collection<Element> elements) {
		System.out.println(prefix + " {");
		for(Element element: elements) {
			System.out.println("    - " + element);
		}
		System.out.println("}\n");
	}
}
