package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex04DateTimeExercises {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();

		LocalDateTime today = LocalDateTime.now();
		YearMonth yearMonth = YearMonth.from(today);

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("1. Thoi gian hien tai: " + df.format(c.getTime()));

		// 2. Thang, nam hien tai co bao nhieu ngay
//		int month = c.get(Calendar.MONTH) + 1;  
//        int year  = c.get(Calendar.YEAR);
//		int dayInMonth = c.getActualMaximum(c.DAY_OF_MONTH);
//		int dayInYear = c.getActualMaximum(c.DAY_OF_YEAR);
//		System.out.println("2. Thang " + month + " co " + dayInMonth + " ngay");
//		System.out.println("2. Nam " + year + " co " + dayInYear + " ngay");

		System.out.println("2. So ngay trong thang " + c.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("2. So ngay trong nam " + c.getActualMaximum(Calendar.DAY_OF_YEAR));

		GregorianCalendar gc = new GregorianCalendar();
		System.out.println("3. kiem tra nam nhuan: " + gc.isLeapYear(c.get(Calendar.YEAR)));

		String[] dayOfWeeks = { "Chu Nhat", "Thu Hai", "Thu Ba", "Thu Tu", "Thu Nam", "Thu Sau", "Thu Bay",
				"Chu Nhat" };

		// DayOfWeek: Sunday(1)
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("N4.gay thu may: " + dayOfWeeks[dayOfWeek - 1]);

		System.out.println("5. Cac ngay trong thang(dd/MM/yyyy week_day)");
		Calendar startDayOfMonth = Calendar.getInstance();
		startDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);

		Calendar endDayOfMonth = Calendar.getInstance();
		endDayOfMonth.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);

		df = new SimpleDateFormat("dd/MM/yyy EEEE");
		for (Calendar cal = startDayOfMonth; cal.before(endDayOfMonth); cal.add(Calendar.DAY_OF_MONTH, 1)) {
			System.out.println(df.format(cal.getTime()));
		}

	}

	private static boolean isLeapYear (int year) {
			GregorianCalendar gc = new GregorianCalendar ();
			return gc.isLeapYear(year);
			}
}
