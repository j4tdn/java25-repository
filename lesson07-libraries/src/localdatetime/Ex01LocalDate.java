package localdatetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import static utils.DateTimeUtils.*;

public class Ex01LocalDate {
	
	// Calendar
	// SimpleDateFormat
	// #parse --> String - Date(Calendar)
	// format --> Date(Calendar) - String

	// new Date				--> initial with normal way
	// Calender.getInstance	--> factory pattern
	
	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate ldate1 = LocalDate.now();
		
		LocalDate ldate2 = LocalDate.of(2025, 11, 18);
		
		LocalDate ldate3 = LocalDate.ofYearDay(2025, 120);
		
		LocalDate ldate4 = LocalDate.parse("12/12/2025", dtf); // only support d/m/y
	
		System.out.printf("date1: %s\n\n", ldate1);
		
		System.out.printf("date2: %s\n\n", dtf.format(ldate2));
		
		System.out.printf("date3: %s\n\n", ldate3);
		
		System.out.printf("date4: %s\n\n", ldate4);
		
		System.out.println("\n======== Query Data =======\n");
		
		System.out.println("DayOfYear: " + ldate4.getDayOfYear());
		
		System.out.println("DayOfYear: " + ldate4.get(ChronoField.DAY_OF_WEEK));
		
		System.out.println("\n======== Period: supports to find the deviation between 2 generation time =======\n");
		
		System.out.println("date3: " + ldate3);
		System.out.println("date4: " + ldate4);
		
		Period period = Period.between(ldate3, ldate4);
		System.out.println("date3&4 diff: " + period);
		System.out.println("date3&4 diff: " 
		+ getUnitValue(period.getYears(), "year")
		+ getUnitValue(period.getMonths(), "month")
		+ getUnitValue(period.getDays(), "day"));
		// P7M12D
		// P: period
		// 7M: month
		// 12D: day
	}
	
}
