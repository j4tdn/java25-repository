package view;

import java.util.Arrays;

public class Ex03operation {

	public static void main(String[] args) {
		
		// length: 5
		String[] seqs = {"A", "T", "Z", "X", "D"};
		
		/**
		 * 
		 Viết hàm:
		 -thêm phần tử vào vị trí bất kì trong mnagr seqs
		 - xóa phần tử tại vị tris bất kì trongmnagr seqs
		 * 
		 */
		System.out.println("Thêm mới phần tử 'e' vị trí 2 --> " + Arrays.toString(add(seqs, 1,"E")));
		System.out.println("Thêm mới phần tử 'W' vị trí 3 --> " + Arrays.toString(insert(seqs, 3,"W")));
		
		System.out.println("Xóa phần tử tại vị trí thứ 1 --> " + Arrays.toString(remove(seqs, 1)));
	}
	
	//xóa
	private static String[] remove(String[] source, int pos) {
		String[] tagert = Arrays.copyOfRange(source,0, source.length);
		
		for(int i = pos; i < tagert.length - 1; i++) {
			tagert[i] = tagert[i+1];
			
		}
		
		return Arrays.copyOfRange(tagert,0, tagert.length-1);
	}
	
	// cách 1 thêm với coppy toàn phần
	private static String[] add(String[] source, int pos, String newVal) {
		
		String[] target = new String[source.length + 1];
		
		for(int i = 0; i<target.length; i++) {
			
			target[i] = i < pos ? source[i] : (i == pos) ? newVal : source[i-1];
		
		}
		
		return target;
		
	}
	
	
	// cách 2: thêm với coppy toàn bộ dịch phải 
	private static String[] insert(String[] source, int pos, String newVal) {
		
		String[] target = new String[source.length + 1];
		
		for(int i = 0; i < source.length; i++) {
			target[i] = source[i];
		}
		
		for(int i = target.length - 1; i > pos; i--) {
			target[i] = target[i-1];
		}
		target[pos] = newVal;
		
		return target; 
	}
	
}
