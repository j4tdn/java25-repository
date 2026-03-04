package sorting.quick;

import java.util.Arrays;
import java.util.Comparator;

import static utils.PrintUtils.*;

public class Ex03SortString {
	public static void main(String[] args) {
		String[] sequences = {"a1", "z2", "k8", "c5"};
		
//		Arrays.sort(sequences); comparable, mặc định kh hỗ trợ xử lý NULL elements
		
		//comparator
		Arrays.sort(sequences, (s1, s2) ->{
			if(s1 == null) {
				return -1;
			}
			if(s2 == null) {
				return 1;
			}
			return s1.compareTo(s2);
		});
		
		generate("1. Sắp xếp tăng dần, null first", sequences);
		
		//comparator
		Arrays.sort(sequences, (s1, s2) ->{
			
			if(s1 == null) {
				return -1;
			}
			if(s2 == null) {
				return 1;
			}
			return s2.compareTo(s1);
		
		});
		generate("2. Sắp xếp giảm dần, null first", sequences);
	}
	
}
