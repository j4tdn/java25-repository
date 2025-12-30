package localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import static utils.DateTimeUtils.*;

public class Ex01LocalDate {

	// Calendar
	// SimpleDateFormat
	// #parse --> String - Date(Calendar)
	// format --> Date(Calendar) - String

	// new Date --> initial with normal way
	// Calendar.getInstance --> Factory Pattern
	// LocalDate.now --> factory, Builder Pattern

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();

		LocalDate date2 = LocalDate.of(2025, Month.NOVEMBER, 18);

		LocalDate date3 = LocalDate.ofYearDay(2025, 364);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate date4 = LocalDate.parse("13/12/2023", dtf);

		System.out.printf("date1: %s\n\n", date1);

		System.out.printf("date2: %s\n\n", dtf.format(date2));

		System.out.printf("date3: %s\n\n", date3);

		System.out.printf("date4: %s\n\n", date4);

		System.out.println("\n============= Query Data =============\n");

		System.out.println("DayOfYear: " + date4.getDayOfYear());
		System.out.println("DayOfWeek: " + date4.get(ChronoField.DAY_OF_WEEK));

		// First Day Of Week rule --> Sunday/Monday
		DayOfWeek firstDayOfWeekRule = WeekFields.of(Locale.GERMANY).getFirstDayOfWeek();
		System.out.println("1st day of week rule: " + firstDayOfWeekRule);

		// First Day Of Week --> search xong thi hoc lien
		LocalDate firstDayOfWeek = date4.with(TemporalAdjusters.previousOrSame(firstDayOfWeekRule));
		System.out.println("1st day of this week: " + firstDayOfWeek);

		System.out.println("\n======= Period: supports to find the deviation between 2 generation time ==========\n");

		System.out.println("date3: " + date3);
		System.out.println("date4: " + date4);

		// validate startDate <= endDate
		Period period = Period.between(date4, date3);
		System.out.println("date3&4 diff: " + period);
		System.out.println("date3&4 diff: " + getUnitValue(period.getYears(), "year")
				+ getUnitValue(period.getMonths(), "month") + getUnitValue(period.getDays(), "day"));
		// P7M13D
		// P: period
		// 7M: month
		// 13D: day

	}

	
}
