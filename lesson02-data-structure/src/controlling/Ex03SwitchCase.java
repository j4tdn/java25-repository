package controlling;

import java.util.Random;

public class Ex03SwitchCase {
	public static void main(String[] args) {
		Random rd = new Random();

		
//		switch (wordAsInt) {
//		case 1:
//			System.out.println("One");
//			break;
//		case 2:
//			System.out.println("Two");
//			break;
//		case 3:
//			System.out.println("Three");
//			break;
//		case 4:
//			System.out.println("Four");
//			break;
//		case 5:
//			System.out.println("Five");
//			break;
//		case 6:
//			System.out.println("One");
//			break;
//		default:
//			break;
//		}
		int weekDay = rd.nextInt(1, 11);
		
		if(weekDay > 10) {
			weekDay = 10;
		}
		
		switch (weekDay) {
		case 2,3,4,5,6:
			System.out.println("weedday");
			break;
		case 7,8:
			System.out.println("weekend day");
			break;
		default:
			System.out.println("Invalid day");
			break;
		}
	}
}
