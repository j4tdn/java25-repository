package lesson05.exam;

import java.util.Scanner;

public class Ex03 {
	private static int getMaxValidNumber(String s) {
		int lengthOfS = s.length();
		for(int i = 0; i<lengthOfS;++i) {
			if(Character.isAlphabetic(s.charAt(i))) {
				s = s.replace(s.charAt(i), ' ');
			}
		}
		String[] arr = s.split("\\s+");
		int maxVal = Integer.MIN_VALUE;
		for(String item : arr) {
			if(!item.isEmpty()) {
				int value = Integer.parseInt(item.trim());
				if(value>maxVal) {
					maxVal = value;
				}
			}
		}
		return maxVal;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(getMaxValidNumber(s));
	}
}
