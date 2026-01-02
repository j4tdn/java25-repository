package view;

import java.util.Scanner;

public class Ex05StringLongest {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("S1: ");
		String s1 = ip.nextLine();
		
		System.out.println("S2: ");
		String s2 = ip.nextLine();
		
		System.out.println("Output: " + longest(s1, s2));
		
		ip.close();
		
	}
	
	private static String longest(String s1, String s2) {
		
		String[] s = new String[s1.length() * s2.length()];
		int count = 0;
		
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				
				if (s1.charAt(i) == s2.charAt(j)) {
					String temp = "";
					int k = 0;
					
					while (true) {
						if (i + k >= s1.length())  {
							break;
						}
						if (j + k >= s2.length()) {
							break;
						}
						if (s1.charAt(i + k) != s2.charAt(j + k)) {
							break;
						}
						
						temp += s1.charAt(i + k);
						k++;
					}
					s[count++] = temp;
					
					
				}
				
			}
		}
		
		String text = "";
		for (int i = 0; i < count; i++) {
			if (s[i].length() > text.length()) {
				text = s[i];
			}
		}
		
		return text;
		
		
	}

}
