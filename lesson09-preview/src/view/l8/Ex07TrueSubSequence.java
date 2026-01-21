package view.l8;


public class Ex07TrueSubSequence {
	public static void main(String[] args) {
		
		String s = "aaabaaabbaaaaa ";
		
		String longestSubString = "";  // length 
		
		// StringBuider: cong chuoi
		StringBuilder subString = new StringBuilder();  
		
		int startIndex = 0;  // vi tri bat dau cua chuoi con dung dai nhat
		for (int i = 0; i < s.length() - 1; i++) {
			char ci1 = s.charAt(i);
			char ci2 = s.charAt(i + 1);
			subString.append(ci1);
			
			if (ci1 != ci2) {
				System.out.println(subString);
			    if (subString.length() > longestSubString.length()) {
					longestSubString = subString.toString();
					startIndex = i - subString.length() + 1;
				} 
				subString.delete(0, subString.length());
			}
		}
		System.out.println("Chuoi con dung dai nhat la: " + longestSubString);
		System.out.println("vi tri bat dau: " + startIndex);
		
		
		
	}

}
