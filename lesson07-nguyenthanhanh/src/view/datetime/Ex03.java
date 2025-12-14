package view.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Ex03 {

	public static void main(String[] args) {
		printCurrentDay("Europe/Berlin", "dd/MM/yyyy HH:mm:ss");
//		String[] timezoneIds = TimeZone.getAvailableIDs();
//		for(String tz : timezoneIds) {
//			printCurrentDay(tz, "dd/MM/yyyy HH:mm:ss");
//		}
		
		System.out.println("Ngày cuối cùng của tháng hiện tại (dd/MM/yyyy) --> " 
				+ lastDayOfCurrentMonth());

		printFirstAndLastDayOfCurrentWeek();
		
		System.out.println("Hiện tại đang ở tuần thứ " + weekOfYear() + " trong năm.");
		
		printDayafterNDays(5);
		
		System.out.println("Số ngày kể từ ngày sinh --> " + calcNumOfDaysSinceBirthday());
	}
	
	private static void printCurrentDay(String timezone, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		df.setTimeZone(TimeZone.getTimeZone(timezone));
		String formatted = df.format(new Date());
		System.out.println("Thời gian hiện tại (" + timezone + ", " + pattern + ") --> " 
				+ formatted);	
	}
	
	private static String lastDayOfCurrentMonth() {
		Calendar c = Calendar.getInstance();
		int lastDayOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);
		return new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
	}
	
	private static void printFirstAndLastDayOfCurrentWeek() {
		Calendar c = Calendar.getInstance();
		
		Calendar first = clone(c);
		first.set(Calendar.DAY_OF_WEEK, first.getFirstDayOfWeek());
		
		Calendar last = clone(first);
		last.add(Calendar.DAY_OF_WEEK, 6);

		
		System.out.println("Ngày đầu trong tuần --> " + first.get(Calendar.DAY_OF_MONTH));
		System.out.println("Ngày cuối trong tuần --> " + last.get(Calendar.DAY_OF_MONTH));
	}
	
	private static int weekOfYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.WEEK_OF_YEAR);
	}
	
	private static void printDayafterNDays(int days) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, days);
		
		int day = c.get(Calendar.DAY_OF_MONTH);
		String weekDay = getDayOfWeeksInVnmese(c.get(Calendar.DAY_OF_WEEK));
		System.out.println("Sau " + days + " ngày, là ngày " + day + " thứ " + weekDay);
	}
	
	private static Calendar clone(Calendar source) {
		Calendar target = Calendar.getInstance();
		target.setTimeInMillis(source.getTimeInMillis());
		return target;
	}
	
	private static String getDayOfWeeksInVnmese(int dayOfWeek) {
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
		return  dayOfWeeks[dayOfWeek-1];	
	}
	
	private static int calcNumOfDaysSinceBirthday() {
		try {
			Date birthdate = new SimpleDateFormat("dd-MM-yyyy").parse("18-07-2002");
			Date now = new Date();
			
			long duration = now.getTime() - birthdate.getTime();
		
			int days = (int)TimeUnit.MILLISECONDS.toDays(duration);
			
			return days;
		} catch(ParseException e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
}
