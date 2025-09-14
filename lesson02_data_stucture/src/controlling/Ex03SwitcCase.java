package controlling;

import java.util.Random;

public class Ex03SwitcCase {
	public static void main(String[] args) {
		
		Random rd = new Random();
		
		// cau1: random 1 so nguyen[1:6]
		// in ra tu tieng anh tuong ung cua so do
		
		int wordAsInt = rd.nextInt(1,6);
		System.out.println("wordAsInt :" + wordAsInt);
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
		}
		
		System.out.println("\nket thuc chuong trinh...");
		
		// cau2: random 1 s nguyen tu 1 ~ 10
		// in ra gia tri neu roi vao 2~8
		// neu gia tri 2,6 --> Weekday
		// neu ga tri 7,8 --> Weekendday
		//                   --> invalid day
		
		int day = rd.nextInt(1,11);
		System.out.println("day :" + day);
		switch (day) {
		case 2,3,4,5,6:
			System.out.println("Weekday");
		    break;
		case 7,8:
			System.out.println("Weekenday");
		    break;
		default:
			System.out.println("invalid day");
		}
		
		int number = rd.nextInt(1,11);
		System.out.println(getDayOfWeek(number));
		
	}
	
	private static String getDayOfWeek(int dayOfWeek) {
		return switch (dayOfWeek) {
		
		case 2,3,4,5,6 -> "weekday";
		case 7,8 -> "weekenday";
		default -> "invalidday";
		};
	}
		
	


}
