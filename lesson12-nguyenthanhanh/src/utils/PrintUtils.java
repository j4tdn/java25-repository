package utils;

import java.util.Collection;
import java.util.Map;
public class PrintUtils {

	private PrintUtils() {
		
	}
	
	public static <E> void generate(String prefix, E[] elements) {
		System.out.println(prefix + "{");
		for(E element : elements) {
			System.out.println("	- " + element);
		}
		System.out.println("}\n");
	}
	
	public static <K, V> void generate(String prefix, Map<K, V> map) {
		generate(prefix, map.entrySet());
	}
	
	public static <E> void generate(String prefix, Collection<E> elements) {
		System.out.println(prefix + "{");
		for(E element : elements) {
			System.out.println("	- " + element);
		}
		System.out.println("}\n");
	}
	
}