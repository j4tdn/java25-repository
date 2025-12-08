package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex04DateTimeExercises {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String result = df.format(c.getTime());
		System.out.println("Hôm nay là: " + result);
	
		System.out.println("===============================");
		
		int dayInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayInYear = c.getActualMaximum(Calendar.DAY_OF_YEAR);
		
		System.out.println("Số ngày trong tháng hiện tại: " + dayInMonth);
		System.out.println("Số ngày trong năm hiện tại: " + dayInYear);
	
		System.out.println("===============================");
		
		int year = c.get(Calendar.YEAR);
		boolean y = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
	
		System.out.println("Năm " + year + (y ? " là năm nhuận" : " không phải năm nhuận"));
	}
	

}
