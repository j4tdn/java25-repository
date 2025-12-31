package assignments;

import java.util.Scanner;

public class Ex07 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		s+=' ';
		int max = 0;
		int min = Integer.MAX_VALUE;
		String res = "" ;
		for(int i = 1;i<s.length() ;++i) {
			if(s.charAt(i) == s.charAt(i-1)) {
				res+=s.charAt(i);
			}else {
				if(res.length() > max) {
					max = res.length();
				}
				if(res.length() < min) {
					min = res.length();
				}
				res= "" + s.charAt(i);
			}
		}
		System.out.println("Độ dài lớn nhất của dãy con đúng: "+max);
		System.out.println("Độ dài nhỏ nhất của dãy con đúng: "+min);
	}

}
