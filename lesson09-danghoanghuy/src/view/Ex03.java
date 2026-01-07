package view;

/*
 Bài 3(20đ): Cho dãy kí tự chứa các kí tự thường và khoảng trắng.
Viết chương trình loại bỏ khoảng trắng thừa và đảo chuỗi như sau:
Example: input: Welcome to JAVA10 class
output: emocleW ot 01AVAJ ssalc
Method signature: revert(String s) >> String
 */

public class Ex03 {

	public static void main(String[] args) {
		
		String ip = "Welcome  to  JAVA10  class";
		
		revert(ip);
		
	}
	
	
	private static void revert(String s) {
		
		String[] words = s.trim().split("\\s+");
		StringBuilder rs = new StringBuilder();
		
		for(int i = 0; i < words.length; i++) {
		
			StringBuilder sb = new StringBuilder(words[i]);
			
			rs.append(sb.reverse());
			if(i <= words.length - 1) {
				rs.append(" ");
			}
		}
		
		System.out.println(rs);
	}
}
