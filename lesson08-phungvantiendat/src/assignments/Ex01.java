package assignments;

import java.util.Scanner;
import java.util.regex.Pattern;

import static utils.StringUtils.*;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("---- Xin moi nhap tu -----");
			String word = sc.nextLine();
			if(isValidString(word)) {
				printCharacter(word);
				printWords(word);
				printReverseCharacter(word);
				printReverseWord(word);
				break;
			}else {
				System.out.println("Yeu cau chuoi chua tieng Viet co dau va space");
			}
		} while (true);
		
	}
	
	
}
