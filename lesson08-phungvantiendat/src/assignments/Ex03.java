package assignments;

import java.text.Normalizer;
import java.util.Scanner;

import static utils.StringUtils.*;

public class Ex03 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.println("--- Xin moi nhap tu ---");
			String word = sc.nextLine();
			if(isValidString(word)) {
				System.out.println(transformWithoutCombiningMark(word));
				break;
			}else {
				System.out.println("Ban phai nhap tieng Viet co dau");
			}
		} while (true);
		
	}

}
