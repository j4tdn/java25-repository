//package view;
//
//import java.util.Arrays;
//
//import static utils.ArraysUtil.*;
//
//public class Ex04 {
//	
//	public static void main(String[] args) {
//		
//		String[] strings = {"-2", "-6", "10", null, "4", "8", null, "Special", 
//				"a", "c", "b", "xx"};
//		
//		sort(strings);
//		
//		generate("Tang dan", strings);
//		
//		System.out.println("\n");
//		
//		reverse(strings);
//		generate("Giam dan", strings);
//	}
//	
//	private static void sort(String[] str) {
//		Arrays.sort(str, (s1, s2) -> {
//			if(s1 == null)
//				return 1;
//			if(s2 == null)
//				return -1;
//			
//			return s1.compareTo(s2);
//		});
//	}
//	
//}
