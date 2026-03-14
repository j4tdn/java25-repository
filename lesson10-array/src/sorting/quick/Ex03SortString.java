package sorting.quick;

import java.util.Arrays;
import java.util.Comparator;

import static utils.PrintUtils.*;

public class Ex03SortString {

	public static void main(String[] args) {
		String[] sequences = {"a1", "Z2", null, "k8", null, "c5"};
		
		Arrays.sort(sequences, (s1,s2) -> {
			if(s1 == null) {
				return -1;
			}
			if(s2 == null) {
				return 1;
			}
			return s1.compareTo(s2);
		}); // comparable, mặc định không hỗ trợ xử lý NULL elements
		
		generate("1. Sắp xếp tăng dần null first", sequences);
		
		Arrays.sort(sequences, (s1, s2) -> {
			if(s1 == null) {
				return -1;
			}
			if(s2 == null) {
				return 1;
			}
			return s2.compareTo(s1);
		});

		generate("2. Sắp xếp giảm dần null first", sequences);
	}

	private static int nullFirst(String s1, String s2, Comparator<String> comp) {
		if(s1 == null) {
			return -1;
		}
		if(s2 == null) {
			return 1;
		}
		return comp.compare(s1, s2);
	}
}
