package localdatetime;

import static utils.DateTimeUtils.getUnitValue;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Ex03LocalDateTime {
	public static void main(String[] args) {
		// LocalDateTime: LocalDate, LocalTime
		// default pattern: "yyyy/MM/dd'T'HH: mm: ss"
		LocalDateTime datetime1 = LocalDateTime.of(2020, 4, 20, 10, 20, 30);
		LocalDateTime datetime2 = LocalDateTime.now();
		System.out.println("datetime1: " + datetime1);
		System.out.println("datetime2: " + datetime2);

		System.out.println("\n==== DateTime Query ====\n");

		// LocalDate date2 = datetime2.toLocalDate();
		// LocalTime time2 = datetime2.toLocalTime();
		// LocalDateTime dt2 = date2.atTime(time2); // time2.atDate(date1)

		// Yêu cầu: Tìm hiêu giữa 2 mốc thời gian trên

		// ? Ngày ? Tháng ? Năm ? Giờ ? Phút ? Giây
		// LocalDate: Period
		// LocalDate LocalTime
		// LocalDate Duration

		// LocalDateTime: x

		System.out.println("\n========= DateTime Devation ===========\n");

		if (datetime1.isAfter(datetime2)) {
			throw new IllegalArgumentException("datetimel must be less than datetimed ...");
		}

		Period period = Period.between(datetime1.toLocalDate(), datetime2.toLocalDate());
		Duration duration = Duration.between(datetime1.toLocalTime(), datetime2.toLocalTime());
		if (duration.isNegative()) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
			System.out.println(period + " " + duration);
			System.out.println("deviation: " + getUnitValue(period.getYears(), "year")
					+ getUnitValue(period.getMonths(), "month") 
					+ getUnitValue(period.getDays(), "day")
					+ getUnitValue(duration.toHoursPart(), "hour") 
					+ getUnitValue(duration.toMinutesPart(), "minute")
					+ getUnitValue(duration.toSecondsPart(), "second"));
		}
	}

}
