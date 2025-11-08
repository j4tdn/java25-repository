package ex03;

import java.util.Scanner;

public class TimSoTuNhienLon {
	public static void main(String[] args) {
		String s1 = "12abu02muzk586cyx";
		String s2 = "Uyk892nn1234uxo2";
		
		System.out.println(getMaxValidNumber(s1));
		System.out.println(getMaxValidNumber(s2));
	}
	
	public static int getMaxValidNumber(String s) {
		int max = 0;
		
		String temp = "";
		for(int i = 0; i< s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				temp += c;
			}else {
				if(!temp.isEmpty()) {
					int num = Integer.parseInt(temp);
					if(num>max ) max = num;
					temp = " ";
				}
			}
		}
		if(!temp.isEmpty()) {
			int num = Integer.parseInt(temp);
			if(num > max) max = num;
		}
		 return max;
	}
}
