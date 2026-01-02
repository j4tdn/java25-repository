package view;

import java.util.Scanner;

public class Ex02PrintName {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String name;
		
		while(true) {
			
			System.out.println("Nhập Tên: ");
			name = ip.nextLine();
			if (name.matches("[A-Za-z ]+")) {
				break;
				
			} else {
				System.out.println("Tên không hợp lệ");
			}
		}
		
		String result = isName(name);
		
		System.out.println("Name: " + result);
		
		ip.close();
		
	}
	
	private static String isName(String name) {
        name = name.trim().toLowerCase();
        String[] words = name.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }

        return sb.toString().trim();
    }

}
