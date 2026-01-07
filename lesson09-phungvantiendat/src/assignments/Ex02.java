package assignments;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		String s = "aa6b546c6e22h, aa6b326c6e22h";
		getLargestNumber(s, 2);
	}

	public static void getLargestNumber(String s, int n) {
		long[] ans = new long[n];
		String []arrCommon = s.split(", ");
		int index = 0;
		for(int i = 0;i<arrCommon.length;++i) {
			ans[index++] = getMaxNumber(arrCommon[i]);
		}
		
		Arrays.sort(ans);
		
		for(int i = 0;i<ans.length;++i) {
			System.out.print(ans[i]+", ");
		}
	}

	public static boolean isValidString(String s) {
		if (s.isEmpty() || s == null) {
			return false;
		}

		int ok = 0;

		for (int i = 0; i < s.length(); ++i) {
			if (!Character.isLetter(s.charAt(i))) {
				ok = 1;
			}
		}

		if (ok == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static long getMaxNumber(String s) {
		if(!isValidString(s)) {
			return 0;
		}
		
		for (int i = 0; i < s.length(); ++i) {
			if (Character.isLetter(s.charAt(i))) {
				s = s.replace(s.charAt(i), ' ');
			}
		}
		String []arr = s.trim().split("\\s+");
		long max = 0;
		for(String it : arr) {
			max = Math.max(Long.parseLong(it.trim()), max);
		}
		return max;
	}
}
