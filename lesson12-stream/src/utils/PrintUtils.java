package utils;

import java.util.Collection;

public class PrintUtils {
	
	private PrintUtils() {
	}
	
	public static <Element> void generate(String prefix, Collection<Element> elements) {
		System.out.println(prefix + "{");
		for (Element element: elements) {
			System.out.println("   - " + element);
		}
		System.out.println("}\n");
	}
	
}
