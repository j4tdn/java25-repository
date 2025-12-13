package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import bean.DurationParts;

public class DateTimeUtils {

	private final static SimpleDateFormat SDF_DETAILS = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private final static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

	public static Calendar clone(Calendar source) {
		Calendar result = Calendar.getInstance();
		result.setTime(source.getTime());
		return result;
	}

	public static Calendar clone(Date source) {
		Calendar result = Calendar.getInstance();
		result.setTime(source);
		return result;
	}

	public static String getVietnameseDayOfWeek(Calendar cal) {
		String[] vn = { "Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy" };
		return vn[cal.get(Calendar.DAY_OF_WEEK) - 1];
	}

	public static String getEngMonth(Calendar cal) {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		return months[cal.get(Calendar.MONTH)];
	}

	public static String getEngDayOfWeek(Calendar cal) {
		String[] vn = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		return vn[cal.get(Calendar.DAY_OF_WEEK) - 1];
	}

	public static DurationParts diffCalendarParts(Calendar start, Calendar end) {
		Calendar tmp = clone(start);

		int years = end.get(Calendar.YEAR) - tmp.get(Calendar.YEAR);
		tmp.add(Calendar.YEAR, years);

		if (tmp.after(end)) {
			--years;
			tmp.add(Calendar.YEAR, -1);
		}

		int months = end.get(Calendar.MONTH) - tmp.get(Calendar.MONTH);
		if (months < 0) {
			months += 12;
		}

		if (tmp.after(end)) {
			--months;
			tmp.add(Calendar.MONTH, -1);
		}

		int days = 0;

		while (true) {
			Calendar next = clone(tmp);
			next.add(Calendar.DAY_OF_MONTH, 1);
			if (next.after(tmp)) {
				break;
			}
			tmp = next;
			days++;
		}

		long remainMillis = end.getTimeInMillis() - tmp.getTimeInMillis();
		long totalSeconds = remainMillis / 1000L;
		int hours = (int) (totalSeconds / 3600L);
		totalSeconds %= 3600L;
		int minutes = (int) (totalSeconds / 60L);
		int seconds = (int) (totalSeconds % 60L);
		return new DurationParts(years, months, days, hours, minutes, seconds);
	}

	public static String getCurrentTimeInArea(String area) {
		String[] timeZoneIds = TimeZone.getAvailableIDs();
		for (String timeZone : timeZoneIds) {
			if (timeZone.contains(area)) {
				SDF_DETAILS.setTimeZone(TimeZone.getTimeZone(timeZone));
				break;
			}
		}
		return SDF_DETAILS.format(new Date());
	}

	public static String getLastDayOfMonth(Calendar cal) {
		Calendar c = clone(cal);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return SDF.format(c.getTime());
	}

	public static String getFirstDayAndLastDayOfCurrentWeek(Calendar cal) {
		Locale.setDefault(new Locale("vi", "VN"));
		Calendar firstDayOfWeek = clone(cal);
		firstDayOfWeek.add(Calendar.DAY_OF_MONTH,
				firstDayOfWeek.getFirstDayOfWeek() - firstDayOfWeek.get(Calendar.DAY_OF_WEEK));
		Calendar lastDayOfWeek = clone(firstDayOfWeek);
		lastDayOfWeek.add(Calendar.DAY_OF_MONTH, 6);
		return String.format("First Day: %s, Last Day: %s", SDF.format(firstDayOfWeek.getTime()),
				SDF.format(lastDayOfWeek.getTime()));
	}

	public static String getCurrentWeekOfYear(Calendar cal) {
		Calendar cur = clone(cal);
		return String.format("Tuần hiện tại: %d", cur.get(Calendar.WEEK_OF_YEAR));
	}

	public static String getTime20DaysAfter(Calendar cal) {
		Calendar dayAfter = clone(cal);
		dayAfter.add(Calendar.DAY_OF_MONTH, 20);
		return String.format("20 days after: %s, %s", SDF.format(dayAfter.getTime()), getVietnameseDayOfWeek(dayAfter));
	}

	public static String getDaysLived(Calendar cal, Calendar birthCal) {
		Calendar cur = clone(cal);
		Calendar birthCalendar = clone(birthCal);

		Long diffTime = cur.getTimeInMillis() - birthCalendar.getTimeInMillis();
		birthCalendar.setLenient(false);
		long days = diffTime / (24L * 60 * 60 * 1000);
		return String.format("Bạn đã sống %d ngày", days);
	}

}
