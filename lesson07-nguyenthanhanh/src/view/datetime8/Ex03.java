package view.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Ex03 {

	public static void main(String[] args) {
		printCurrentDay("Europe/Berlin", "dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Ngày cuối cùng của tháng hiện tại (dd/MM/yyyy) --> " 
				+ lastDayOfCurrentMonth(12,2025));
		
		printFirstAndLastDayOfCurrentWeek();
		
		System.out.println("Hiện tại đang ở tuần thứ " + weekOfYear() + " trong năm.");
	}
	
	private static void printCurrentDay(String timezone, String pattern) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of(timezone));
		System.out.println("Thời gian hiện tại (" + timezone + ", " + pattern + ") --> " 
				+ now.format(dtf));	
	}
	
	private static String lastDayOfCurrentMonth(int month, int year) {
		Month monthObj = Month.of(month);
		LocalDate date = LocalDate.of(year, month, monthObj.maxLength());
		return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	private static void printFirstAndLastDayOfCurrentWeek() {
		LocalDate today = LocalDate.now();
		
		LocalDate monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		
		System.out.println("Ngày đầu trong tuần --> " + monday.format(dtf));
		System.out.println("Ngày cuối trong tuần --> " + sunday.format(dtf));
	}
	
	private static int weekOfYear() {
		LocalDate now = LocalDate.now();
		return now.get(WeekFields.of(Locale.GERMAN).weekOfYear());
	}
	
}
