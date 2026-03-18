package view;

import java.util.Arrays;

public class Ex03Operations {
	
	public static void main(String[] args) {
		
		// Length: 5
		String[] seqs = {"A", "T", "Z", "X", "D"};
		
		/*
		Viết hàm trả về mảng mới
		- thêm 1 phần tử vào vị trí bất kì trong mảng seqs
		- xóa 1 phần tử tại vị trí bất kì trong mảng seqs 
		*/
		
		System.out.println("Thêm mới [add] phần tử 'E' vị trí 1 --> " + Arrays.toString(add(seqs, 1, "E")));
		
		System.out.println("Thêm mới [insert] phần tử 'W' vị trí 3 --> " + Arrays.toString(insert(seqs, 3, "W")));
		
		System.out.println("Xóa phần tử tại vị trí thứ 1 --> " + Arrays.toString(remove(seqs, 1)));
	}
	
	private static String[] remove(String[] source, int pos) {
		String[] target = Arrays.copyOfRange(source, 0, source.length);
		
		// dịch trái 1 đơn vị
		for (int i = pos; i < target.length - 1; i++) {
			target[i] = target[i+1];
		}
		
		return Arrays.copyOfRange(target, 0, target.length - 1);
	}
	
	// cách 1: thêm với copy từng phần
	private static String[] add(String[] source, int pos, String newVal) {
		String[] target = new String[source.length + 1];
		for (int i = 0; i < target.length; i++) {
			target[i] = (i < pos) ? source[i] : (i == pos) ? newVal : source[i-1];
		}
		return target;
	}
	
	// cách 2: thêm với copy toàn bộ rồi dịch phải
	private static String[] insert(String[] source, int pos, String newVal) {
		String[] target = new String[source.length + 1];
		
		for (int i = 0; i < source.length; i++) {
			target[i] = source[i];
		}
		
		// dịch phải 1 đơn vị
		for (int i = target.length - 1; i > pos; i--) {
			target[i] = target[i-1];
		}
		
		target[pos] = newVal;
		
		return target;
	}
}
