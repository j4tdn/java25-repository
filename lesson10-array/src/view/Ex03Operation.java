package view;

import java.util.Arrays;

public class Ex03Operation {

	public static void main(String[] args) {
		
		// length: 5
		String[] seqs = {"K1", "T9", "Z5", "X2", "D7"};
		
		/*
		 Viet ham 
		 - them phan tu vao vi tri bat ki trong mang seqs
		 - xoa phan tu tai vi tri bat ki trong mang seqs
		 */
		
		System.out.println("Ham add: " + Arrays.toString(add(seqs, 2, "E")));
		
		System.out.println("Ham insert: " + Arrays.toString(insert(seqs, 2, "E")));
		
		System.out.println("Ham remove: " + Arrays.toString(remove(seqs, 2)));
		
		System.out.println("Ham delete: " + Arrays.toString(delete(seqs, 2)));
	}
	
	// Cach 1: copy tung phan
	private static String[] remove(String[] source, int pos) {
		
		String[] target = new String[source.length - 1];
		
		for(int i = 0, k = 0; i < source.length; i++) {
			if(i == pos) continue;
			target[k++] = source[i];
		}
		
		return target;
	}
	
	private static String[] delete(String[] source, int pos) {
		
		String[] target = Arrays.copyOfRange(source, 0, source.length);
		
		for(int i = pos; i < target.length - 1; i++) {
			target[i] = target[i + 1];
		}
		
		return Arrays.copyOfRange(target, 0, target.length - 1);
		
	}
	
	// Cach 1: copy tung phan
	private static String[] add(String[] source, int pos, String newVal) {
		
		String[] target = new String[source.length + 1];
		
		for(int i = 0; i < target.length; i++) {
			target[i] = (i < pos) ? source[i] : (i == pos) ? newVal : source[i-1];
		}
		
		return target;
	}
	
	// Cach 2: dich phai
	private static String[] insert(String[] source, int pos, String newVal) {
			
			String[] target = new String[source.length + 1];
			for(int i = 0; i < source.length; i++) {
				target[i] = source[i];
			}
			
			for(int i = target.length - 1; i > pos; i--) {
				target[i] = target[i - 1];
			}
			
			target[pos] = newVal;
			
			return target;
	}
}
