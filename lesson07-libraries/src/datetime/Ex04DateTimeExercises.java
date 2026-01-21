package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Ex04DateTimeExercises {
	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();

		Date date = c.getTime();

		System.out.println(date);

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String dateAsString = df.format(date);
		System.out.println("1. In thông tin ngày tháng năm với Dateformat: " + dateAsString);

		System.out.println("\n======================================\n");

		System.out.println("2. Số ngày trong tháng: " + c.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("2. Số ngày trong năm: " + c.getActualMaximum(Calendar.DAY_OF_YEAR));
		System.out.println("2. số ngày trong tuần:" + c.getActualMaximum(Calendar.DAY_OF_WEEK));

		System.out.println("\n======================================\n");

		// duong lich
		System.out.println("3. kiểm tra Năm nhuận: " + isLeapYear(c.get(Calendar.YEAR)));

		System.out.println("\n======================================\n");

		System.out.println("4. Ngày thứ mấy: " + getDayOfWeeksInVnmese(c.get(Calendar.DAY_OF_WEEK)));

		System.out.println("\n======================================\n");

		System.out.println("5. Các ngày trong tháng(dd/MM/yyyy week_day: ");
		printDaysInMonth(c);

		System.out.println("\n======================================\n");

		// ngày đầu tuần: chủ nhật(1) || thứ hai(2) phụ thuộc vào giá trị của default
		// setting locale(country, language) || locale từ clendar
		// có 2 cách để thay đổi/tác động đến ngày đầu tiên
		// 1. set lại default locale(trước khi calendar.getInstance())
		// 2. truyền locale vào trong Calender.getInstance(locale)

		System.out.println("5. Các ngày trong tháng(dd/MM/yyyy week_day: ");
		System.out.println("Locale mac dinh: " + Locale.getDefault());

		int FirstDayOfWeek = c.getFirstDayOfWeek();
		System.out.println("Ngày đầu tuần: " + FirstDayOfWeek);

		System.out.println("\n======================================\n");

		System.out.println("5. Các ngày trong tuan(dd/MM/yyyy week_day: ");
		printDaysInWeek(c);

		System.out.println("\n======================================\n");

		System.out.println("6. NGAY CHU NHAT TRONG THANG: ");
		printSundayInMonth(c, Calendar.SUNDAY);

	}

	private static void printSundayInMonth(Calendar c, int weekday) {
		Calendar startDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, 1);

		Calendar endDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");

		boolean foundAny = false;
		for (Calendar ca1 = startDayOfMonth; ca1.before(endDayOfMonth);) {
			if (!foundAny && ca1.get(Calendar.DAY_OF_WEEK) == weekday) {
				foundAny = true;
			}
			if (foundAny) {
				System.out.print(df.format(ca1.getTime()) + "   ");
				ca1.add(Calendar.DAY_OF_MONTH, 7);
				continue;
			}
			ca1.add(Calendar.DAY_OF_MONTH, 1);

		}
	}

	private static void printDaysInWeek(Calendar c) {
		Calendar startDayOfWeek = clone(c);
		startDayOfWeek.add(Calendar.DAY_OF_MONTH,
				startDayOfWeek.getFirstDayOfWeek() - startDayOfWeek.get(Calendar.DAY_OF_WEEK));

		Calendar endDayOfWeek = clone(startDayOfWeek);
		endDayOfWeek.add(Calendar.DAY_OF_MONTH, 7);
		// endDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy EEEE");

		for (Calendar ca1 = startDayOfWeek; ca1.before(endDayOfWeek); ca1.add(Calendar.DAY_OF_MONTH, 1)) {
			System.out.printf("%-20s", df.format(ca1.getTime()));
		}

	}

	// 18/08/2018
	private static void printDaysInMonth(Calendar c) {
		Calendar startDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, 1);

		Calendar endDayOfMonth = cloneAndSet(startDayOfMonth, Calendar.DAY_OF_MONTH,
				c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);
		// endDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy EEEE");

		for (Calendar ca1 = startDayOfMonth; ca1.before(endDayOfMonth); ca1.add(Calendar.DAY_OF_MONTH, 1)) {
			System.out.printf("%-25s", df.format(ca1.getTime()));
			if (ca1.get(Calendar.DAY_OF_MONTH) % 5 == 0) {
				System.out.println();
			}
		}

	}

	private static String getDayOfWeeksInVnmese(int dayOfWeek) {
		String[] dayofweeks = { "Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy" };
		return dayofweeks[dayOfWeek - 1];

	}

	// duong lich
	private static boolean isLeapYear(int year) {
		GregorianCalendar gc = new GregorianCalendar();
		return gc.isLeapYear(year);

	}

	private static Calendar cloneAndSet(Calendar soure, int field, int value) {
		Calendar target = Calendar.getInstance();
		target.setTimeInMillis(soure.getTimeInMillis());
		target.set(field, value);
		return target;
	}

	private static Calendar clone(Calendar soure) {
		Calendar target = Calendar.getInstance();
		target.setTimeInMillis(soure.getTimeInMillis());
		return target;
	}

}
