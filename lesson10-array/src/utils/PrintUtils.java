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
	
	public static void generate(String s, float[] elements) {
		System.out.println(s + " --> {");
		for (float element: elements) {
			System.out.println("  - " + element);
		}
		System.out.println("}\n");
	}
	
	public static void generate(String s, Object[] elements) {
		System.out.println(s + " --> {");
		for (Object element: elements) {
			System.out.println("  - " + element);
		}
		System.out.println("}\n");
	}
}
