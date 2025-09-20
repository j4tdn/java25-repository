package controlling;

import java.util.Random;

public class Ex03SwitchCase {
	public static void main(String[] args) {
		
		Random rd = new Random();
		
		// Câu 1: Random 1 số nguyên [1, 5]
		// In  ra từ tiếng anh tương ứng của số đó
		
		int wordAsInt = rd.nextInt(1, 6);
		System.out.println("wordAsInt: " + wordAsInt);

		switch (wordAsInt) {
		case 1:
			System.out.println("One");
			// break;
		case 2:
			System.out.println("Two");
			// break;
		case 3:
			System.out.println("Three");
			// break;
		case 4:
			System.out.println("Four");
			// break;
		case 5:
			System.out.println("Five");
			break;
		}

		System.out.println("\nKết thúc chương trình ...");
		
		
		//Câu 2: Random 1 số nguyên [1, 10]
		// In ra giá trị rơi vào [2, 8]
		// Nếu giá trị 2,6 -- weekday
		//..............7, 8 -- weekend day
		//Khác --- invalid day
		
		int days = rd.nextInt(1, 11);
		System.out.println("days: " + days);

		switch (days) {
		case 2, 3, 4, 5, 6:
			System.out.println("Weekday");
			break;
		case 7, 8:
			System.out.println("Weekend day");
			break;
		default:
			System.out.println("Invalid day");
			break;

		}
		
		// bên dưới là cách ngắn gọn hơn nữa
		int days = rd.nextInt(1, 11);
		System.out.println("number : " + days);
		
		private static String getDayOfWeek (int dayOfWeek) {
			return switch (dayOfWeek) {
			case 2, 3, 4, 5, 6 -> "Weekday";
			case 7, 8 -> "Weekend day";
			default -> "Invalid day";
			};
		}

	}
}
