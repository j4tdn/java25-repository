package exhomework;

import java.util.Scanner;

public class Ex01 {
		public static void main(String[] args) {
			
			int	number = CheckInput.getInput();
			
			System.out.println("Giá trị hợp lệ: "+ number);
			
			if(number % 2 ==0) {
				System.out.println(number +" là bội của 2.");
			}else 
				System.out.println(number +" không phải là bội của 2.");

	}
}