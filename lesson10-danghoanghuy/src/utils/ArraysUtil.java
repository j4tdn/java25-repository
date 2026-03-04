package utils;

public class ArraysUtil {
	public ArraysUtil() {
	}
	
	public static void generate(String s, String[] es) {
		System.out.println(s + "\n");
		for(String e: es) {
			System.out.print(e + " ");
		}
	}
	
	public static void reverse(String[] es) {
		for(int i = 0; i < es.length/2; i++) {
			swap(es, i, es.length - i - 1);
		}
	}
	
	public static void swap(String[] elements, int i, int j) {
		String temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
}
