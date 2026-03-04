package view;

import java.util.Arrays;

import static utils.ArraysUtil.*;

public class Ex04 {

	// Mai e nghien cuu sau :v
	
	public static void main(String[] args) {
		
		String[] strings = {"-2", "-6", "10", null, "4", "8", null, "Special", 
				"a", "c", "b", "xx"};
		
		Arrays.sort(strings, (s1, s2) -> {
			if(s1 == null)
				return 1;
			if(s2 == null)
				return -1;
			return s1.compareTo(s2);
		});
		
		generate("Tang dan", strings);
		
		reverse(strings);
		generate("Giam dan", strings);
	}
}
