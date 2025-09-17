package structure.array;

import java.util.Arrays;

public class Ex03FilterString {
	public static void main(String[] args) {
		String[] students = {"Peter Croud" , "Kaka", "Valdes", "Patrick Veira"};
		System.out.println("Hoc sinh co chu P: " );
		
		System.out.print(Arrays.toString(getStudents(students)));
	}
	private static String[] getStudents(String[] elements) {
		String[] oddElements = new String[elements.length];
		int count =0;
		for(String element : elements) {
			if(element.startsWith("P")) {
				oddElements[count] = element;
				count++;
			}
		}
		//cach1
//		String[] result = new String[count];
//		for(int i =0 ; i<count; i++) {
//			result[i] = oddElements[i];
//		}
//		return result;
		
		//cach2 
		return Arrays.copyOfRange(oddElements, 0, count);
		
		
	}
}
