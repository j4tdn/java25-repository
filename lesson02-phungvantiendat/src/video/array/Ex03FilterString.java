package video.array;

import java.util.Arrays;

public class Ex03FilterString {

	public static void main(String[] args) {
		String[] students = {"Peter Croud", "Kaka", "Valdes", "Patrick Veira"};
		System.out.println(Arrays.toString(getStudents(students)));
	}

	private static String[] getStudents(String[] elements) {
		String[] result = new String[elements.length];
		int cnt = 0;
		for(String element: elements) {
			if(element.startsWith("P")) {
				result[cnt++] = element;
			}
		}
		return Arrays.copyOfRange(result, 0, cnt);
	}
}
