package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Ex04DateTimeExercises {
	
	/*
	 1. In thông tin ngày tháng năm với DateFormat
	 2. Tháng, năm hiện tại có bao nhiêu ngày
	 3. Kiểm tra năm hiện tại có phải là năm nhuận không
	 4. Ngày hiện tại là ngày thứ mấy, in ra ngày theo tiếng việt
	 5. In thông tin các ngày trong tháng, tuần hiện tại dd/MM/yyyy week_day
	 6. Đếm xem trong tháng có bao nhiêu ngày chủ nhật và in ra
	 */
	
	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("vi", "VN"));
		Calendar c = Calendar.getInstance();
		
		Date date = c.getTime();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		String dateAsString = df.format(date);
		
		System.out.println("1. In thông tin ngày tháng năm với DateFormat: " + dateAsString);
		
		System.out.println("\n==================\n");
		
		System.out.println("2. Đếm số ngày trong tháng: " + c.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("2. Đếm số ngày trong năm: " + c.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		System.out.println("\n==================\n");
		
		System.out.println("3. Kiểm tra năm nhuận: " + isLeapYear(c.get(Calendar.YEAR)));
		
		System.out.println("\n==================\n");
		
		System.out.println("4. Ngày thứ mấy: " + getDayOfWeeksInVnmese(c.get(Calendar.DAY_OF_WEEK)));
		
		System.out.println("\n==================\n");
		
		System.out.println("5. Các ngày trong tháng(dd/MM/yyyy week_day)");
		printDaysInMonth(c);
		
		System.out.println();
		
		// Ngày đầu tuần: Chủ Nhật(1) || Thứ Hai(2) phụ thuộc vào giá trị của default setting locale(language, country) || locale từ calendar
		// Có 2 cách để thay đổi/tác động đến ngày đầu tuần
		// 1. Set lại default locale(trước khi Calendar.getInstance())
		// 2. Truyền locale vào trong Calendar.getInstance(locale)
		
		System.out.println("Locale mặc định: " + Locale.getDefault());
		
		int firstDayOfWeek = c.getFirstDayOfWeek(); // Ngày trong tuần
		System.out.println("Ngày đầu tuần: " + firstDayOfWeek);
		
		System.out.println("5. Các ngày trong tuần(dd/MM/yyyy week_day)");
		printDaysInWeek(c);
		
		System.out.println("\n==================\n");
		System.out.println("6. Các ngày thứ hai trong tháng hiện tại");
		printWeekDayInMonth(c, Calendar.SUNDAY);
	}
	
	private static void printWeekDayInMonth(Calendar c, int weekday) {
		Calendar startDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, 1);
		
		Calendar endDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
		
		boolean foundAny = false;
		
		for(Calendar cal = startDayOfMonth; cal.before(endDayOfMonth);) {
			if (!foundAny && cal.get(Calendar.DAY_OF_WEEK) == weekday) {
				foundAny = true;
			}
			
			if (foundAny) {
				System.out.print(df.format(cal.getTime()) + "    ");
				cal.add(Calendar.DAY_OF_MONTH, 7);
				continue;
			}
			
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
	
	private static void printDaysInWeek(Calendar c) {
		Calendar startDayOfWeek = clone(c); // 10/12/2025
		startDayOfWeek.add(Calendar.DAY_OF_MONTH, startDayOfWeek.getFirstDayOfWeek() - startDayOfWeek.get(Calendar.DAY_OF_WEEK));
		
		Calendar endDayOfWeek = clone(startDayOfWeek);
		endDayOfWeek.add(Calendar.DAY_OF_MONTH, 7); 
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy EEEE");
		
		for(Calendar cal = startDayOfWeek; cal.before(endDayOfWeek); cal.add(Calendar.DAY_OF_MONTH, 1)) {
			System.out.printf("%-25s", df.format(cal.getTime()));
		}
	}
	
	private static void printDaysInMonth(Calendar c) {
		Calendar startDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, 1);
		
		Calendar endDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1); 
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy EEEE");
		
		for(Calendar cal = startDayOfMonth; cal.before(endDayOfMonth); cal.add(Calendar.DAY_OF_MONTH, 1)) {
			System.out.printf("%-25s", df.format(cal.getTime()));
			if (cal.get(Calendar.DAY_OF_MONTH) % 5 == 0) {
				System.out.println();
			}
		}
	}
	
	private static String getDayOfWeeksInVnmese(int dayOfWeek) {
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
		return  dayOfWeeks[dayOfWeek-1];
		
	}
	
	// Dương Lịch
	private static boolean isLeapYear(int year) {
		GregorianCalendar gc = new GregorianCalendar();
		return gc.isLeapYear(year);
	}
	
	private static Calendar cloneAndSet(Calendar source, int field, int value) {
		Calendar target = clone(source);
		target.set(field, value);
		return target;
	}
	
	private static Calendar clone(Calendar source) {
		Calendar target = Calendar.getInstance(); 
		target.setTimeInMillis(source.getTimeInMillis());
		return target;
	}
	
}