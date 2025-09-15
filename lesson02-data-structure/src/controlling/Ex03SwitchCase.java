package controlling;

import java.util.Random;

public class Ex03SwitchCase {
	public static void main(String[] args) {
		Random rd = new Random();
		int wordAsInt = 2;
		switch (wordAsInt) {
		case 1:
			System.out.println("Ngày một");
		case 2:
			System.out.println("Ngày hai");
		case 3:
			System.out.println("Ngày ba");
		case 4:
			System.out.println("Ngày bốn");
		case 5:
			System.out.println("Ngày năm");
		}
		int day = rd.nextInt(1, 11);
		System.out.println(day);
		switch (day) {
		case 2, 3, 4, 5, 6:
			System.out.println("Weekday!!");
			break;
		case 7, 8:
			System.out.println("Weekend day!!");
			break;
		default:
			System.out.println("Ngày không hợp lệ");

		}
	}

}
