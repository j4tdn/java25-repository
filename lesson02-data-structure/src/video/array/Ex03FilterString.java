package video.array;

import java.util.Arrays;

public class Ex03FilterString {
	public static void main(String[] args) {
		
		int[] numbers = {15,16,17,18,19};
		int[] copies = Arrays.copyOfRange(numbers, 0, 3);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(copies));

		System.out.println("=================");
		String[] students = { "Peter", "Kaka", "Valdes", "Patrick" };
		
		System.out.println(Arrays.toString(getStudents(students)));

	}
	private static String[] getStudents(String[] elements) {
		String[] result = new String[elements.length];
		int count = 0;
		for (String element: elements) {
			if (element.startsWith("P")) {
				result[count] = element;
				count++;
				
			}
			
		}
		return Arrays.copyOfRange(result, 0, count);
				
	}
}
