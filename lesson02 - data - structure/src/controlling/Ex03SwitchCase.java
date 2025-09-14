package controlling;

import java.util.Random;

public class Ex03SwitchCase {

	public static void main(String[] args) {
		
		Random rd = new Random();
		int n = rd.nextInt(1,6);
		System.out.println("n la: "+n);
		switch (n) {
		case 1: {
			System.out.println("One");
			break;
		}
		case 2: {
			System.out.println("Two");
			break;
		}
		case 3: {
			System.out.println("Three");
			break;
		}
		case 4: {
			System.out.println("Four");
			break;
		}
		case 5: {
			System.out.println("Five");
			
			}
		
		}
		int day = rd.nextInt(1,11);
		System.out.println("n la: "+day);
	switch(day) {	
		case 2,3,4,5,6:
			System.out.println("Weekday");
			break;
		case 7,8: 
			System.out.println("Weekend day");
			break;
		default:
			System.out.println("Invalid day");
		}
	}
}
