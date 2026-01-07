package bai2;

//Ví dụ: với n = 1 : xâu 01a2b3456cde478 : Kết quả: 3456
//với n = 2 : xâu aa6b546c6e22h, aa6b326c6e22h: Kết quả: 326, 546
public class Main {
	public static void main(String[] args) {
		String[] r1 = LargestNumbers.getLargestNumbers("aa6b546c6e22h", "aa6b326c6e22h");
		for (String s : r1) {
			System.out.println(s + "");
		}
	}
}
