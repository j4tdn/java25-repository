package controlling;

import java.util.Random;

public class Ex03SwitchCase {
	
	public static void main(String[] args) {
		
		Random rd = new Random();
		
		// Cau 1: Ramdom so nguyen [1, 5]
		// In ra tu tieng anh tuong ung so do	
		int wordAsInt = 2; //rd.nextInt(1, 5);
		System.out.println("wordAtInt: " + wordAsInt);
		switch(wordAsInt) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		}
		System.out.println("\nKet thuc");
		
		// Cau 2: Random so nguyen [1, 10] 
		// In ra gt neu roi vao gia tri [2, 8]
		// Neu gt 2, 6 --> weekday
		//				--> weekend day
		int day = rd.nextInt(1, 10);
		System.out.printf("day = %s, dayOfWeek = %s", day, getDayOfWeek(day));
		
	}
	
	private static String getDayOfWeek(int dayOfWeek) {
		return switch (dayOfWeek) {
			case 2, 3, 4, 5, 6 -> "week day";
			case 7, 8 -> "weekend day";
			default -> "invalid day";
		};
	};

}
