package view;

import java.util.Scanner;

public class MaxValidNumber {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Nhap chuoi can tim : ");
		String textString= sc.nextLine();
		int max = getMaxValidNumber(textString);
		System.out.printf(" so tu nhien lon nhat tim duoc trong chuoi %s la : %s", textString, getMaxValidNumber(textString));
		
	}
	
	private static int getMaxValidNumber(String text) {
		int max = 0;
		String getNumber = "";
		for(char c : text.toCharArray()) {
			if(Character.isDigit(c)) {
				getNumber += c;
			}
			else if(!getNumber.isEmpty()){
				int num = Integer.parseInt(getNumber);
				if(num > max) {
					max = num;
				}
				getNumber ="";
			}
			
		}

		return max;
	}

}
