package controlling;

import java.util.Random;

public class Ex03SwitchCase {
	public static void main(String[] args) {
		Random rd = new Random();
		int wordAsInt = 2; // rd.nextInt(1, 6);
		System.out.println("wordAsInt: " + wordAsInt);

		switch (wordAsInt) {
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
		case 3:
			System.out.println("three");
			break;
		case 4:
			System.out.println("four");
			break;
		case 5:
			System.out.println("five");
			break;
		default:
			break;
		}

		System.out.println("=== ket thuc ===");

		// cau 2:
		int ngay = rd.nextInt(1, 11);
		System.out.println(getDayofWeek(ngay));
		
	}

	private static String getDayofWeek(int dayOfWeek) {
		return switch (dayOfWeek) {
		case 2, 3, 4, 5, 6 -> "weekday";
		case 7, 8 -> "weekend day";
		default -> "invalid day";
		};
	}
}
