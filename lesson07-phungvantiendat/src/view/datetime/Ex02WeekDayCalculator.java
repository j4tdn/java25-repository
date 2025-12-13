package view.datetime;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import exception.InValidInputException;
import static utils.DateTimeUtils.*;
import static utils.ScannerUtils.*;

public class Ex02WeekDayCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day = 0, month = 0, year = 0;
		Locale.setDefault(new Locale("vi", "VN"));
		Calendar c = Calendar.getInstance();
		c.setLenient(false);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		do {
			try {

				System.out.println("===== Weekday Calculator =====");

				System.out.println("Xin mời nhập ngày sinh: ");
				String dayString = sc.nextLine();

				System.out.println("Xin mời nhập tháng sinh: ");
				String monthString = sc.nextLine();

				System.out.println("Xin mời năm sinh: ");
				String yearString = sc.nextLine();

				if (isValidInputEx02(dayString, monthString, yearString)) {
					day = Integer.parseInt(dayString);
					month = Integer.parseInt(monthString);
					year = Integer.parseInt(yearString);
				}
				c.set(year, month - 1, day);

				int maxDaysOfYear = c.getActualMaximum(Calendar.DAY_OF_YEAR);
				int maxDaysOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);

				int currentDay = c.get(Calendar.DAY_OF_YEAR);

				int dayLeft = maxDaysOfYear - currentDay;

				int currentWeek = c.get(Calendar.WEEK_OF_MONTH);
				int maxWeekOfMonth = c.getActualMaximum(Calendar.WEEK_OF_MONTH);
				int weekLeft = maxWeekOfMonth - currentWeek;

				int currentWeekOfYear = c.get(Calendar.WEEK_OF_YEAR);
				int maxWeekOfYear = c.getActualMaximum(Calendar.WEEK_OF_YEAR);

				System.out.println("It is day number " + currentDay + " of the year " + dayLeft + " days left");
				System.out.printf("It is %s number %d out of %d in %d\n", getEngDayOfWeek(c), currentWeekOfYear,
						maxWeekOfYear, year);
				System.out.printf("It is %s number %d out of %d in %s %d\n", getEngDayOfWeek(c), currentWeek,
						maxWeekOfMonth, getEngMonth(c), year);

				System.out.println("Year " + year + " has " + maxDaysOfYear + " days");
				System.out.println(getEngMonth(c) + " " + year + " has " + maxDaysOfMonth + " days");
			} catch (InValidInputException ex) {
				System.out.println(ex.getMessages());
			}
		} while (true);
	}

}
