package view;

import java.util.Arrays;

public class Ex03Operation {
	
	public static void main(String[] args) {
		String[] seqs = {"K1", "T9", "Z5", "X2", "D7"};
		
		/*
		 * Viết hàm
		 * - Thêm 1 phần tử vào vị trí bất kì trong mảng seqs
		 * - Xóa 1 phần tử ở vị trí bất kì trong mảng
		 * */
		
		
		System.out.println(Arrays.toString(insert(seqs, 2, "E")));
		
		System.out.println("Xoa phan tu tai vi tri thu 2 --> " + Arrays.toString(remove(seqs,2)));
	}
	
//	private static void add(String[] seqs, int pos,String element) {
//		String[] results = new String[seqs.length + 1];
//		for(int i = 0; i < pos ; ++i) {
//			results[i] = seqs[i];
//		}
//		results[pos] = element;
//
//	    for (int i = pos; i < seqs.length; ++i) {
//	        results[i + 1] = seqs[i];
//	    }
//	}
	
//	private static String[] add(String[] source, int pos, String newVal) {
//		String[] target = new String[source.length + 1];
//		
//		for(int i = 0;i < source.length ; ++i) {
//			if( i < pos) {
//				target[i] = source[i];
//			}else {
//				target[i + 1] = source[i];
//			}
//		}
//		
//		target[pos] = newVal;
//		return target;
//	}
	
	private static String[] insert(String[] source, int pos, String newVal) {
		String[] target = new String[source.length + 1];
		for(int i = 0;i < source.length; ++i) {
			target[i] = source[i];
		}
		
		for(int i = target.length - 1;i>pos;--i) {
			target[i] = target[i-1]; 
		}
		target[pos] = newVal;
		return target;
	}
	
	private static String[] remove(String[] source, int pos) {
		String[] target = Arrays.copyOfRange(source, 0, source.length);
		
		for(int i = pos; i < target.length - 1 ;++i) {
			target[i] = target[i + 1];
		}
		return Arrays.copyOfRange(target, 0, target.length - 1);
	}
}
