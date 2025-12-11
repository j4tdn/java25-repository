package datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex04DateTimeExercises {

	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		System.out.println("1. DateTimeFormatter --> " + format.format(now.getTime()));
		
		System.out.println("2. Số ngày của tháng hiện tại --> " + 
				now.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("2. Số ngày của năm hiện tại --> " + 
				now.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		System.out.println("3. Năm hiện tại " + (now.getActualMaximum(Calendar.DAY_OF_YEAR) > 365 ?
				" không phải": "") + "là năm nhuận");
		
		// Dương lịch
		System.out.println("Kiểm tra năm nhuận --> " + isLeapYear(now.get(Calendar.YEAR)));
		
		System.out.println("4. Ngày thứ --> " +  
				getDayOfWeeksInVietnamese(now.get(Calendar.DAY_OF_WEEK)));
		
		System.out.println("5. Các ngày trong tháng(dd/MM/yyyy week_day)");
		printDaysInMonth(now);
		
		int firstDayOfWeek = now.getFirstDayOfWeek();
		System.out.println("Ngày đầu tuần: " + firstDayOfWeek);
		
	}
	
	private static Calendar cloneAndSet(Calendar source, int field, int value) {
		Calendar target = clone(source);
		
		target.setTimeInMillis(source.getTimeInMillis());
		target.set(field, value);
		
		return target;
	}
	
	private static Calendar clone(Calendar source) {
		Calendar target = Calendar.getInstance();
		target.setTimeInMillis(source.getTimeInMillis());
		return target;
	}
	
	// 19/08/2025 -> 01/08/2025 : 31/08/2025
	private static void printDaysInMonth(Calendar c) {
		Calendar startDayOfMonth = Calendar.getInstance();
		startDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar endDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, 
				c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);
		
		for(Calendar cal = startDayOfMonth; cal.before(endDayOfMonth); cal.add(Calendar.DAY_OF_MONTH, 01)) {
			System.out.println(df.format(cal.getTime()) + "		");
			if(cal.get(Calendar.DAY_OF_MONTH) % 5 == 0) {
				System.out.println();
			}
		}
	}
	
	private static String getDayOfWeeksInVietnamese(int dayOfWeek) {
		String[] dayOfWeeks = {
			"Chủ Nhật", "Thứ Hai", "Thứ Ba", 
			"Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"
		};
		return dayOfWeeks[dayOfWeek - 1];
	}
	
	private static boolean isLeapYear(int year) {
		GregorianCalendar gc = new GregorianCalendar();
		return gc.isLeapYear(year);
	}
	
}
