package view.l8;

import java.util.Arrays;

public class Ex07TrueSubSequence {
	
	public static void main(String[] args) {
		
		// Tìm chuỗi con đúng dài nhất trong chuỗi s
		// Nếu tồn tại nhiều chuỗi con dài nhất có số lượng kí tự giống nhau --> in ra tất cả
		// Thông tin: Chuỗi, Vị trí bắt đầu, Độ dài của chuỗi
		
		String s = "zzddddddbaaaiiiiiiiiiiiiiaaacddddddbaaa ";
		Pair[] pairs = new Pair[s.length()];
		int count = 0;
		
 		String longestSubString = ""; // maxLength
		
		StringBuilder subString = new StringBuilder(); 
		int startIndex = 0; // vị trí bắt đầu của chuỗi con đúng dài nhất
		
		for (int i = 0; i < s.length() - 1; i++) {
			char ci1 = s.charAt(i);
			char ci2 = s.charAt(i+1);
			subString.append(ci1);
			
			if (ci1 != ci2) {
				if (subString.length() > longestSubString.length()) {
					longestSubString = subString.toString();
					startIndex = i - subString.length() + 1;
					pairs = new Pair[s.length()];
					count = 0;
					pairs[count++] = new Pair(longestSubString, startIndex);
				} else if (subString.length() == longestSubString.length()) {
					longestSubString = subString.toString();
					startIndex = i - subString.length() + 1;
					pairs[count++] = new Pair(longestSubString, startIndex);
				}
				subString.delete(0, subString.length());
			}
		}
		
		System.out.println("Chuỗi con đúng dài nhất và vị trí là: " + Arrays.toString(Arrays.copyOfRange(pairs, 0, count)));
		
	}
	
	static class Pair {
		private String subString;
		private int startIndex;
		
		public Pair(String subString, int startIndex) {
			this.subString = subString;
			this.startIndex = startIndex;
		}
		
		@Override
		public String toString() {
			return subString.length() + " " + subString + " " + "[" + startIndex + "]";
		}
		
	}
	
}