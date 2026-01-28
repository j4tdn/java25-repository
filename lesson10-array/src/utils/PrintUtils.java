package utils;

public class PrintUtils {
	
	private PrintUtils() {
	}
	
	public static void generate(String s, int[] elements) {
		System.out.println(s + " --> {");
		for (int element: elements) {
			System.out.println("  - " + element);
		}
		System.out.println("}\n");
	}
	
}
