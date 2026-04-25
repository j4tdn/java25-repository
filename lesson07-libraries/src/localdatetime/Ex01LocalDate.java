package localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;
import static localdatetime.DateTimeUtils.*;
public class Ex01LocalDate {
	
	//new date
	// Calendar.getInstance
	public static void main(String[] args) {
		
		LocalDate date1 = LocalDate.now();
		
		LocalDate date2 = LocalDate.of(2025, 11, 18);
		
		LocalDate date3 = LocalDate.ofYearDay(2025, 264);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy E");
		
		LocalDate date4 = LocalDate.parse("13/12/2025 Sat",dtf); //only support d/m/y
		
		System.out.printf("date1: %s\n\n", date1);
		
		System.out.printf("date2: %s\n\n", dtf.format(date2));
		
		System.out.printf("date3: %s\n\n", date3);
		
		System.out.printf("date4: %s\n\n", date4);
		
		System.out.println("\n====== Query data ============");
		
		
		System.out.println( "Day of year: "+ date4.getDayOfYear());
		System.out.println("Day of week: " + date4.get(ChronoField.DAY_OF_WEEK));
		
		DayOfWeek firstDayOfWeekRule = WeekFields.of(Locale.GERMANY).getFirstDayOfWeek();
		System.out.println("1st day of week rule: " + firstDayOfWeekRule);
		
		LocalDate firstDayOfWeek = date4.with(TemporalAdjusters.previousOrSame(firstDayOfWeekRule));
		System.out.println("1st day of thís week: " + firstDayOfWeek);
		System.out.println("\n====== Period: suport to find the deviation between 2 generation time ============");
	
		System.out.println("date3: "+ date3);
		System.out.println("date4: "+ date4);
		
		Period period = Period.between(date3, date4);
		System.out.println("date3&4 diff: " + period);
		System.out.println("date3&4 diff: "
				+ getUnitValue(period.getYears(), "year")
				+ getUnitValue(period.getMonths(), "month")
				+ getUnitValue(period.getDays(), "day")
				
				);
		//P7M13D
		//P: period
		//7m: month
		//13d: day
	
	}
	
	

}
