package LocalDateTime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import static utils.DateTimeUtils.*;

public class Ex03LocalDateTime {
	public static void main(String[] args) {

		LocalDateTime datetime1 = LocalDateTime.of(2020, 4, 20, 10, 20, 30);

		LocalDateTime datetime2 = LocalDateTime.now();
		System.out.println("datetime1: " + datetime1);
		System.out.println("datetime2: " + datetime2);

		System.out.println("\n========== DateTime Query ============\n");

	    //	LocalDate date2 = datetime2.toLocalDate();
		//  LocalTime time2 = datetime2.toLocalTime();

		// System.out.println("date2: " + date2);
		// System.out.println("time: " + time2);

		// LocalDate : period
		// LocalTime: Duration
		// LocalDateTime:

		System.out.println("\n============== DateTime Deviation ====================/n");
		
		if (datetime1.isAfter(datetime2)) {
			throw new IllegalArgumentException("datetime1 must be less datetime2");
		}

		Period period = Period.between(datetime1.toLocalDate(), datetime2.toLocalDate());
		Duration duration = Duration.between(datetime1.toLocalTime(), datetime2.toLocalTime());
		
		if (duration.isNegative()) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}
		
		System.out.println(period + " " + duration);
		System.out.println("deviation: " 
				+ getUnitValue(period.getYears(), "year")
				+ getUnitValue(period.getMonths(), "month")
				+ getUnitValue(period.getDays(), "day")
				+ getUnitValue(duration.toHoursPart(), "hour")
				+ getUnitValue(duration.toMinutesPart(), "minute")
				+ getUnitValue(duration.toSecondsPart(), "second"));
		

	}

}
