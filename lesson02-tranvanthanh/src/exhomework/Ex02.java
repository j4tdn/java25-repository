package exhomework;

import java.util.Scanner;

public class Ex02 {
		public static void main(String[] args) {
			
			int	number = CheckInput.getInput();
			
			System.out.println("Giá trị hợp lệ: "+ number);
			
			int temp= number;
				while(temp %2 ==0) {
					temp = temp / 2 ;
				}	
			
				if(temp == 1) {
					System.out.println(number +" là luỹ thừa của 2. ");
				}else System.out.println(number +" không phải là luỹ thừa của 2. ");
		}

}
