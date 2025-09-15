package controlling;

import java.util.Random;

public class Ex03SwichCase {
	public static void main(String[] args) {
		Random rd = new Random();
		
		//câu 1: Random 1 số nguyên [1,5]
		//in ra từ tiếng anh tương ứng
		
		int wordAsInt = 2;//rd.nextInt(1,6);
		System.out.println("wordAsInt: " + wordAsInt);
		
		switch(wordAsInt) {
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
		}
		System.out.println("\nkết thúc chương trình ...");
		//câu 2 random 1 số nguyên [1,10]
		//in ra giá trị nếu rơi vào [2,8]
		//nếu giá trị 2,6 --->"wekday"
		//			  7,8 --->"wekend day"		
		//khác			  --->"invalid day"
		
		int number = rd.nextInt(1,11);
		System.out.printf("number = %s , dayOfWeek = %s  " , number , getDayOfWeek(number));
		
	}

	private static String getDayOfWeek(int dayOfWeek) {
		return switch (dayOfWeek) {
		case 2, 3, 4, 5, 6 -> "Weekday";
		case 7, 8 -> "wekend day";
		default -> "invalid day";
		};
	}
}
