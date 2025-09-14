package exhomework;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		
		
		int	number = CheckInput.getInput();
		System.out.println("Giá trị hợp lệ: "+ number);
		
		int temp= 1;
			for(int i = 1 ; i <= number ; i++) {
				temp = temp*i;
			}
			System.out.println("Giai thừa của "+number+" là: "+temp);
	}
	
	
}
