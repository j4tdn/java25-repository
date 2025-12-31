package assignments;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("--- Nhap xau s1 ---");
		String s1 = sc.next();
		System.out.println("--- Nhap xau s2 ---");
		String s2 = sc.next();

		int max = 0;
		String res = "";
		String ans = "";
		for (int i = 0; i < s1.length(); ++i) {
			if (s1.charAt(i) == s2.charAt(i)) {
				res += s1.charAt(i);
			} else {
				if (res.length() >= max) {
					max = res.length();
					ans = res;
				}
				res = "";
			}
		}
		System.out.println(ans);
	}

}
