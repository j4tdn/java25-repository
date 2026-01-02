package assignments;

import java.util.Scanner;

public class Ex05 {
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Nhập s1: ");
	        String s1 = scanner.nextLine();

	        System.out.print("Nhập s2: ");
	        String s2 = scanner.nextLine();

	        String result = Utils.longestCommonSubstring(s1, s2);

	        System.out.println("Xâu con chung dài nhất:");
	        System.out.println(result);

	        scanner.close();
	    }
}
