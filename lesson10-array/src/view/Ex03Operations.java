package view;

import java.util.Arrays;

public class Ex03Operations {

	public static void main(String[] args) {
		
		String[] seqs = { "K1", "T9", "N8", "Z6", "A7" };
		
		// Viết hàm xóa, thêm 1 phần tử tại vị trí bất kỳ
		System.out.println("Thêm mới E4 tại 2 --> " + Arrays.toString(add(seqs, 2, "E4")));
	}
	
	private static String[] add(String[] source, int pos, String value) {
		String[] result = new String[source.length + 1];
		for(int i = 0; i < result.length; i++) {
			result[i] = (i < pos) ? source[i] : (i == pos) ? value : source[i - 1];
		}
		return result;
	}
	
	private static String[] remove(String[] seqs, int index) {
		String[] result = new String[seqs.length - 1];
		for(int i = 0, k = 0 ; i < seqs.length; i++) {
			if(i == index) {
				continue;
			}
			result[k] = seqs[i];
			k++;
		}
		return result;
	}
	
}
