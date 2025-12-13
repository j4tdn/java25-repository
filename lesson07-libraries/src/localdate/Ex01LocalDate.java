package localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static utils.DateTimeUtils.*;

public class Ex01LocalDate {

	// Date, Calendar
	// SimpleFormatDate(pattern)
	// #parse --> string -> Date(pattern)
	
	// new Date 			--> initial with normal way
	// Calendar.getInstance --> factory pattern
	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("en_US"));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy E");
		
		LocalDate date1 = LocalDate.now();
		
		LocalDate date2 = LocalDate.of(2025, 11, 18);
		
		LocalDate date3 = LocalDate.ofYearDay(2025, 120);
		
		LocalDate date4 = LocalDate.parse("13/12/2025 Sat", dtf);
		
		System.out.printf("date1: %s\n\n", date1);
		System.out.printf("date2: %s\n\n", dtf.format(date2));
		System.out.printf("date3: %s\n\n", date3);
		System.out.printf("date4: %s\n\n", date4);
		
		System.out.println("DayOfYear: " + date4.getDayOfYear());
		System.out.println("DayOfWeek: " + date4.get(ChronoField.DAY_OF_WEEK));
		
		DayOfWeek firstDayOfWeekRule = WeekFields.of(Locale.GERMANY).getFirstDayOfWeek();
		System.out.println("1st day of week rule: " + firstDayOfWeekRule);
		
		LocalDate firstDayOfWeek= date4.with(TemporalAdjusters.previousOrSame(firstDayOfWeekRule));
		System.out.println("1st day of this week: " + firstDayOfWeek);
		
		System.out.println("\n========= Period: Find the devidation beetween 2 generation time \\n=========");
		
		System.out.println("Start date: " + date3);
		System.out.println("End date: " + date4);
		
		// P: period
		// M: Months
		// D: Days
		Period period = Period.between(date3, date4);
		System.out.println("date3&4 diff: " + period); // P7M13D
		System.out.println("date3&4 diff: " 
				+ getUnitValue(period.getYears(), "year")
				+ getUnitValue(period.getMonths(), "month")
				+ getUnitValue(period.getDays(), "day"));
		
	}
	

	
}
