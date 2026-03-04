//package utils;
//
//import java.util.Arrays;
//
//import bean.SortOrder;
//
//public class ArrayUtils {
//	public static void swap(int[] elements, int i, int j) {
//		int tmp = elements[i];
//		elements[i] = elements[j];
//		elements[j] = tmp;
//	}
//	
//	public static void sort(int[] elements, SortOrder sortOrder) {
//		Arrays.sort(elements);
//		if(sortOrder == SortOrder.DESC) {
//			reverse(elements);
//		}
//	}
//	
//	public static void reverse(int[] elements) {
//		int length = elements.length;
//		for(int i = 0;i<length/2;++i) {
//			swap(elements,i,length - i -1);
//		}
//	}
//	
//}
