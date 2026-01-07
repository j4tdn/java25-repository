/*
 * Bài 3(20đ): Cho dãy kí tự chứa các kí tự thường và khoảng trắng.
Viết chương trình loại bỏ khoảng trắng thừa và đảo chuỗi như sau:
Example: input: Welcome to JAVA10 class
output: emocleW ot 01AVAJ ssalc
Method signature: revert(String s) >> String
 */

package view;

public class Ex03 {
	public static void main(String[] args) {
		String input = "Welcome to JAVA10 class";
		String result = revert(input);
		System.out.println(result);
	}
	
	static String revert(String s) {
		s = s.trim().replaceAll("s+"," ");
		String[] words = s.split("");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--){
			sb.append(new StringBuilder(words[i]).reverse()).append(" ");
		}
		return sb.toString().trim();
	}
	

}
