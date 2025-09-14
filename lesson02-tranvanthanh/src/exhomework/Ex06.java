package exhomework;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
			System.out.print("Nhập Số nguyên a "); 
			int a = Input(); 
			System.out.print("Nhập Số nguyên b "); 
			int b = Input();
			System.out.print("Nhập Số nguyên c "); 
			int c = Input();
			System.out.println("a= "+a);
			System.out.println("b= "+b);
			System.out.println("b= "+c);
			int max = (a > b ? a : b) > c  ? (a > b ? a : b) : c;
			System.out.println("Số lớn nhất trong 3 số "+ a +" "+ b +" "+ c +" là: "+ max);
			int min = (a < b ? a : b ) < c ? (a < b ? a : b ) : c;
			System.out.println("Số bé nhất trong 3 số "+ a +" "+ b +" "+ c +" là: "+ min);
	}

	 public static int Input() {
	        Scanner ip = new Scanner(System.in);
	        String text;

	        while (true) {
	          //  System.out.print("Nhập 1 số nguyên dương: ");
	            text = ip.nextLine();

	            if (check(text)) {
	                int number = Integer.parseInt(text);
	                if (number >=0 && number <=20) {
	                    return number;
	                }
	            }	
	            System.out.println("Chưa phải là số nguyên dương hợp lệ. Mời nhập lại.");
	            System.out.println("Nhập 1 số nguyên: ");
	        }
	    }

	    private static boolean check(String text) {
	        for (int i = 0; i < text.length(); i++) {
	            if (!Character.isDigit(text.charAt(i))) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
