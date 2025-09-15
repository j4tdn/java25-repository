package controlling;

import java.time.YearMonth;
import java.util.Random;
import java.util.Scanner;

public class Ex01IfElse {
	// câu2
	public static void checkpasswword(String password) {
		int length = password.length();
		if(length >=6) {
			System.out.println("Matkhau hople");
		}else {
			System.out.println("Matkhau khonghople");
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap passwword");
		String password = sc.nextLine();
		checkpasswword(password);
	}
		
}

