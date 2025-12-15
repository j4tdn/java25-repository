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

import static utils.DateTimeUtils.*;


public class Ex01LocalDate {

	//Calendar
	//SimplDateFormaat
	//#parse --> String - Date(calendar)
	//format --> Date(Calendar) - String
	
	
	// new Date				--> initial with normay way
	// Calendar.getInstance --> factory pattern
	// LocalDate.nơ  		--> factor, builder pattern
	
	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy E");
		
		LocalDate date1 = LocalDate.now();
		
		LocalDate date2 = LocalDate.of(2025, 11, 18);
		
		LocalDate date3 = LocalDate.ofYearDay(2025, 120);
		
		LocalDate date4 = LocalDate.parse("13/12/2025 Sat", dtf); // only supports d/m/y
		
		System.out.printf("date1: %s\n\n", date1);
		
		System.out.printf("date2: %s\n\n", dtf.format(date2));
		 
		System.out.printf("date3: %s\n\n", date3);
		
		System.out.printf("date4: %s\n\n", date4);
		
		System.out.println("\n=========== Query Date ============\n");
		
		System.out.println("DayOfYear: " + date4.getDayOfYear());
		System.out.println("DayOfWeek: " + date4.get(ChronoField.DAY_OF_WEEK));
		
		//First day of week rule --> Sunday/Monday
		DayOfWeek firtDayOfWeekRule = WeekFields.of(Locale.GERMANY).getFirstDayOfWeek();
		System.out.println("1 st day of this rule: " + firtDayOfWeekRule);
		
		//First Day Of Week
		LocalDate firtDayOfWeek = date4.with(TemporalAdjusters.previousOrSame(firtDayOfWeekRule));
		System.out.println("1 st day of this week: " + firtDayOfWeek);
		
		System.out.println("\n======= Period: supports to find the deviation betwween 2 generation tine ============\n");
		
		System.out.println("date3: " + date3);
		System.out.println("date4: " + date4);
		
		// valildate startDate <= endate
		Period period = Period.between(date3, date4);
		System.out.println("date3&4 diff: " + period);
		System.out.println("date3&4 diff: " 
				+ getUnitValue(period.getYears(), "year")
				+ getUnitValue(period.getMonths(), "month")
				+ getUnitValue(period.getDays(), "day")
				);
		//P7M13D
		//P:period
		//7M: month
		//13D:day
	}
}
