package view;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap chuoi: ");
		String ip = sc.nextLine();
		
		String[] words = ip.split("[ \\.]+");
		
		StringBuilder rs = new StringBuilder();
		
		for(String word:words) {
			if(!word.isEmpty()) {
				String firstChar = word.substring(0, 1).toUpperCase();
				
				String remainingChars = word.substring(1).toLowerCase();
				
				rs.append(firstChar).append(remainingChars).append(" ");
			}
		}
		
		System.out.println(rs);
		sc.close();
	}
	
}
