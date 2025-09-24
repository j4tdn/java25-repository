package controlling;

import java.util.Random;

public class Ex03SwitchCase {

	public static void main(String[] args) {

		Random rd = new Random();

		// Câu 1: Random 1 số nguyên [1, 6)
		// In ra từ tiếng anh tương ưng của số đó

		int wordAsInt = 2; // rd.nextInt(1, 6);
		System.out.println("wordAsInt: " + wordAsInt);
		
		switch (wordAsInt) {
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
		}

		System.out.println("\nKết thúc chương trình...");
		
		// Câu 2: Random 1 số nguyên [1, 10]
		// In ra giá trị nếu rơi vào [2, 8]
		// Nếu giá trị 2, 6 --> "weekday"
		//             7, 8 --> "weekend day"
		// Khác             --> "invalid day"
		
		int number = rd.nextInt(1, 11);
		System.out.printf("number = %s, dayOfWeek = %s ", number, getDayOfWeek(number));
	}
	
	private static String getDayOfWeek(int dayOfWeek) {
		return switch (dayOfWeek) {
			case 2, 3, 4, 5, 6 -> "weekday";
			case 7, 8 -> "weekend day";
			default -> "invalid day";
		};
	}

}