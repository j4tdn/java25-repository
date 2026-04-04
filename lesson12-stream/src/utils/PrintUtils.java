package utils;

import java.util.Collection;

public class PrintUtils {

	private PrintUtils() {
		
	}
	
	public static <E> void generate(String prefix, Collection<E> elements) {
		System.out.println(prefix + "{");
		for(E element : elements) {
			System.out.println("	- " + element);
		}
		System.out.println("}\n");
	}
	
}
