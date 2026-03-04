package util;

import bean.Item;

public class PrintUtils {

	public PrintUtils() {
	}
	
	public static void generate(String s, int[] es) {
		System.out.println(s + "\n");
		for(int e: es) {
			System.out.println("  - " + e);
		}
		System.out.println("\n");
	}
	
	public static void generate(String s, float[] es) {
		System.out.println(s + "\n");
		for(float e: es) {
			System.out.println("  - " + e);
		}
		System.out.println("\n");
	}
	
	public static void generate(String s, String[] es) {
		System.out.println(s + "\n");
		for(String e: es) {
			System.out.println("  - " + e);
		}
		System.out.println("\n");
	}
	
	public static void generate(String s, Item[] es) {
		System.out.println(s + "\n");
		for(Item e: es) {
			System.out.println("  - " + e);
		}
		System.out.println("\n");
	}
}

