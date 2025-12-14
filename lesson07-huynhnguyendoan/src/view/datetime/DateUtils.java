package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateUtils {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
	private static final SimpleDateFormat fullFmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static String formatDate(Calendar c) {
		return sdf.format(c.getTime());
	}

	public static String getWeekday(Calendar c) {
		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		return days[c.get(Calendar.DAY_OF_WEEK) - 1];
	}

	public static int getDayOfYear(Calendar c) {
		return c.get(Calendar.DAY_OF_YEAR);
	}

	public static int getYearLength(Calendar c) {
		Calendar temp = Calendar.getInstance();
		temp.set(c.get(Calendar.YEAR), Calendar.DECEMBER, 31);
		return temp.get(Calendar.DAY_OF_YEAR);
	}

	public static int getDaysLeftInYear(Calendar c) {
		return getYearLength(c) - getDayOfYear(c);
	}

	public static int getDaysInMonth(Calendar c) {
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static int countTotalWeekdayInYear(Calendar c) {
		int target = c.get(Calendar.DAY_OF_WEEK);
		int year = c.get(Calendar.YEAR);

		Calendar temp = Calendar.getInstance();
		temp.set(year, Calendar.JANUARY, 1);

		int count = 0;
		while (temp.get(Calendar.YEAR) == year) {
			if (temp.get(Calendar.DAY_OF_WEEK) == target)
				count++;
			temp.add(Calendar.DATE, 1);
		}
		return count;
	}

	public static int countWeekdayOrderInYear(Calendar c) {
		int target = c.get(Calendar.DAY_OF_WEEK);

		Calendar temp = Calendar.getInstance();
		temp.set(c.get(Calendar.YEAR), Calendar.JANUARY, 1);

		int count = 0;
		while (true) {
			if (temp.get(Calendar.DAY_OF_WEEK) == target)
				count++;

			if (temp.get(Calendar.YEAR) == c.get(Calendar.YEAR)
					&& temp.get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR)) {
				break;
			}

			temp.add(Calendar.DATE, 1);
		}
		return count;
	}

	public static int countTotalWeekdayInMonth(Calendar c) {
		int target = c.get(Calendar.DAY_OF_WEEK);

		Calendar temp = Calendar.getInstance();
		temp.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);

		int count = 0;
		while (temp.get(Calendar.MONTH) == c.get(Calendar.MONTH)) {
			if (temp.get(Calendar.DAY_OF_WEEK) == target)
				count++;
			temp.add(Calendar.DATE, 1);
		}
		return count;
	}

	public static int countWeekdayOrderInMonth(Calendar c) {
		int target = c.get(Calendar.DAY_OF_WEEK);

		Calendar temp = Calendar.getInstance();
		temp.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);

		int count = 0;
		while (true) {
			if (temp.get(Calendar.DAY_OF_WEEK) == target)
				count++;

			if (temp.get(Calendar.YEAR) == c.get(Calendar.YEAR)
					&& temp.get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR)) {
				break;
			}

			temp.add(Calendar.DATE, 1);
		}
		return count;
	}

	public static void showCurrentTime(String timezone) {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone(timezone));
		System.out.println("Current time (" + timezone + "): " + fullFmt.format(c.getTime()));
	}

	public static void showLastDayOfCurrentMonth() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("Last day of current month: " + sdf.format(c.getTime()));
	}

	public static void showFirstAndLastDayOfWeek() {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println("First day of week: " + sdf.format(c.getTime()));

		c.add(Calendar.DATE, 6);
		System.out.println("Last day of week: " + sdf.format(c.getTime()));
	}

	public static void showWeekOfYear() {
		Calendar c = Calendar.getInstance();
		System.out.println("Current week of year: " + c.get(Calendar.WEEK_OF_YEAR));
	}

	public static void showDateAfter20Days() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 20);

		SimpleDateFormat weekdayFmt = new SimpleDateFormat("EEEE");
		System.out.println("After 20 days: " + sdf.format(c.getTime()) + " (" + weekdayFmt.format(c.getTime()) + ")");
	}

	public static void calculateDaysLived(String birthday) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		Calendar birth = Calendar.getInstance();
		birth.setTime(sdf.parse(birthday));

		Calendar now = Calendar.getInstance();

		long diffdays = now.getTimeInMillis() - birth.getTimeInMillis();
		long days = diffdays / (1000 * 60 * 60 * 24);

		System.out.println("You have lived: " + days + " days");
	}

}
