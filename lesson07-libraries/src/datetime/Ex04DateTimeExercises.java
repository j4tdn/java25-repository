package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.text.DateFormatter;

public class Ex04DateTimeExercises {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance(new Locale("vi", "VN"));
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(df.format(date));
//
//		Calendar calendar = Calendar.getInstance();
//
//		System.out.println(getVietnameseDayOfWeek(calendar));

		System.out.println(getDaysOfYear(calendar));

		// 2. Kiem tra nam nhuan
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.isLeapYear(gc.get(gc.YEAR)));

		// 5. Ngay trong thang
		printDaysInMonth(calendar);

		// Ngày đầu tuần: Chủ Nhật(1) || Thứ Hai(2) phụ thuộc vào giá trị của default
		// setting locale(country, language) || locale từ calendar
		// Có 2 cách để thay đổi/tác động đến ngày đầu tuần
		// 1. Set lại default locale(trước khi Calendar.getInstance())
		// 2. Truyền locale vào trong Calendar.getInstance(locale)

		System.out.println("Locale mặc định: " + Locale.getDefault());

		int firstDayOfWeek = calendar.getFirstDayOfWeek();
		System.out.println("Ngày đầu tuần: " + firstDayOfWeek);
		
		printSundaysInMonth(calendar, Calendar.SUNDAY);
	}

	private static Calendar cloneAndSet(Calendar source, int field, int value) {
		Calendar target = Calendar.getInstance();
		target.setTimeInMillis(source.getTimeInMillis());
		target.set(field, value);
		return target;
	}

	private static Calendar clone(Calendar source) {
		Calendar target = Calendar.getInstance();
		target.setTimeInMillis(source.getTimeInMillis());
		return target;
	}

	private static void printSundaysInMonth(Calendar c, int weekDay) {
		Calendar startDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, 1);

		Calendar endDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 7);

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		Calendar sunday = null;
		
		boolean foundAny = true;

		for (Calendar cal = startDayOfMonth; cal.before(endDayOfMonth); cal.add(Calendar.DAY_OF_MONTH, 1)) {
			if (!foundAny &&cal.get(Calendar.DAY_OF_WEEK) == weekDay) {
				foundAny = true;
			}

			if (foundAny) {
				System.out.println(df.format(cal.getTime()) + "      ");
				cal.add(Calendar.DAY_OF_MONTH, 7);
				continue;
			}

			cal.add(Calendar.DAY_OF_MONTH, 1);
		}

	}

	private static void printDaysInWeek(Calendar calendar) {
		Calendar startDayOfWeek = cloneAndSet(calendar, Calendar.DAY_OF_MONTH, 1);
		startDayOfWeek.add(Calendar.DAY_OF_MONTH,
				startDayOfWeek.getFirstDayOfWeek() - startDayOfWeek.get(Calendar.DAY_OF_WEEK));

		Calendar endDayOfWeek = clone(startDayOfWeek);
		endDayOfWeek.add(Calendar.DAY_OF_MONTH, 7);

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy EEEE");
		for (Calendar cal = startDayOfWeek; cal.before(endDayOfWeek); cal.add(Calendar.DAY_OF_MONTH, 1)) {
			System.out.printf("%-25s", df.format(cal.getTime()));
		}
		System.out.println();
	}

	private static void printDaysInMonth(Calendar calendar) {
		Calendar startDayOfMonth = cloneAndSet(calendar, Calendar.DAY_OF_MONTH, 1);

		Calendar endDayOfMonth = cloneAndSet(calendar, Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy EEEE");
		for (Calendar cal = startDayOfMonth; cal.before(endDayOfMonth); cal.add(Calendar.DAY_OF_MONTH, 1)) {
			System.out.printf("%-25s", df.format(cal.getTime()));
			if (cal.get(Calendar.DAY_OF_MONTH) % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static String getVietnameseDayOfWeek(Calendar calendar) {
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case 2:
			return "Thứ hai";
		case 3:
			return "Thứ ba";
		case 4:
			return "Thứ tư";
		case 5:
			return "Thứ năm";
		case 6:
			return "Thứ sáu";
		case 7:
			return "Thứ bảy";
		case 1:
			return "Chủ nhật";
		default:
			return "";
		}
	}

	private static int getDaysOfMonth(Calendar calendar) {
		int daysQty = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return daysQty;
	}

	private static int getDaysOfYear(Calendar calendar) {
		return calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
	}

	private static boolean isLeapYear(int year) {
		GregorianCalendar gc = new GregorianCalendar();
		return gc.isLeapYear(year);
	}

}
