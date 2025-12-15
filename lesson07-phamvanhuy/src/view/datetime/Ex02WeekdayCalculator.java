package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Ex02WeekdayCalculator {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			 System.out.print("Nhập ngày: ");
	            int day = sc.nextInt();

	            System.out.print("Nhập tháng: ");
	            int month = sc.nextInt();

	            System.out.print("Nhập năm: ");
	            int year = sc.nextInt();
	            
	            Calendar cal = Calendar.getInstance();
	            cal.setLenient(false); 
	            cal.set(year, month - 1, day);

	            Date date = cal.getTime(); 
	            
	            SimpleDateFormat sdfDay =
	                    new SimpleDateFormat("EEEE", new Locale("en", "US"));
	            String weekday = sdfDay.format(date);
	            
	            int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
	            int daysInYear = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
	            int daysLeft = daysInYear - dayOfYear;
	            int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
	            int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	            System.out.println("\n========== RESULT ==========");
	            System.out.println(day + "/" + month + "/" + year + " is a " + weekday);
	            System.out.println("It is day number " + dayOfYear +
	                               " of the year, " + daysLeft + " days left");
	            System.out.println("It is week number " + weekOfYear + " of the year");
	            System.out.println("Month " + month + " has " + daysInMonth + " days");
	            System.out.println("Year " + year + " has " + daysInYear + " days");

		} catch (Exception e) {
			 System.out.println("Ngày tháng năm không hợp lệ");
		}
	}
}
