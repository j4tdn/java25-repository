package localdatetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

import static utils.DateTimeUtils.*;

public class Ex03LocalDateTime {

	public static void main(String[] args) {

		// LocalDateTime: LocalDate, LocalTime
		// defaultPattern: "yyyy/MM/dd'T'HH:mm:ss"
		LocalDateTime datetime1 = LocalDateTime.of(2020, 4, 20, 10, 20, 30);
		LocalDateTime datetime2 = LocalDateTime.of(2026, 1, 3, 10, 20, 30);

		LocalDate firstDayOfWeek = datetime2.toLocalDate().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

		System.out.println(firstDayOfWeek);
		
		System.out.println(datetime2.getDayOfWeek().getValue());

		System.out.println("datetime1: " + datetime1);
		System.out.println("datetime2: " + datetime2);

		System.out.println("\n================ DateTime Query =================\n");

		LocalDate date2 = datetime2.toLocalDate();
		LocalDate date1 = datetime1.toLocalDate();

		LocalTime time2 = datetime2.toLocalTime();
		LocalTime time1 = datetime1.toLocalTime();

		if (datetime1.isAfter(datetime2)) {
			throw new IllegalArgumentException("datetime1 must be less than time2 ");
		}

		Period period = Period.between(date1, date2);

		Duration duration = Duration.between(time1, time2);

		// LocalDate: Period
		// LocalTime: Duration
		// LocalDateTime: x

		if (duration.isNegative()) {
			duration = duration.plusDays(1);
			period = period.plusDays(1);
		}

		System.out.println("date1&2 diff: " + getUnitValue(period.getYears(), "year")
				+ getUnitValue(period.getMonths(), "month") + getUnitValue(period.getDays(), "day"));

		System.out.println("Duration diff: " + getUnitValue(duration.toHoursPart(), "hour")
				+ getUnitValue(duration.toMinutesPart(), "minute") + getUnitValue(duration.toSecondsPart(), "second"));
	}

}
