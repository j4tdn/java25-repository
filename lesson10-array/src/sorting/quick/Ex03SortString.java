package sorting.quick;

import java.util.Arrays;

import static util.PrintUtils.*;

public class Ex03SortString {

	public static void main(String[] args) {
		
		String[] sequences = {"a1", "z2", null, "k8", null, "c5"};
		
		// Arrays.sort(sequences); // comparable, mac dinh k ho tro xu ly null
		
		Arrays.sort(sequences, (s1, s2) -> {
			if(s1 == null)
				return -1;
			if(s2 == null)
				return 1;
			return s2.compareTo(s1);
		});
		
		generate("1. SX tang dan, null first", sequences);
		
		Arrays.sort(sequences, (s1, s2) -> {
			return nullFirst(s1, s2) * s2.compareTo(s1);
		});
		
		generate("2. SX giam dan", sequences);
	}
	
	private static int nullFirst(String s1, String s2) {
		if(s1 == null) {
			return -1;
		}
		return 1;
			
	}
}
