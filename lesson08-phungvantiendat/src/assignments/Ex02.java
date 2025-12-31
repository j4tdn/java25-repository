package assignments;

import java.util.Scanner;

import static utils.StringUtils.normalizeCaptitalCase;;
public class Ex02 {
	
	private static final String PATTERN = "^[A-Za-z]+$";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("--- Xin nhap chuoi ---");
			String word = sc.nextLine();
			if(isValidWord(word)) {
				System.out.println(normalizeCaptitalCase(word));
				break;
			}else {
				System.out.println("Chi duoc nhap ki tu");
			}
		} while (true);
	}

	private static boolean isValidWord(String s) {
		return s.matches(s);
	}
}
