package localdate;

import static utils.DateTimeUtils.getUnitValue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Ex03LocalDateTime {

	public static void main(String[] args) {
		
		// LocalDateTime: LocalDate, LocalTime
		// default pattern: "yyyy/MM/dd'T'HH:mm:ss"
		LocalDateTime dateTime1 = LocalDateTime.of(2025, 4, 20, 10, 20, 30);
		LocalDateTime dateTime2 = LocalDateTime.now();
		
		System.out.println("datetime1 --> " + dateTime1);
		System.out.println("datetime2 --> " + dateTime2);
		
		LocalDate date1 = dateTime1.toLocalDate();
		LocalTime time1 = dateTime1.toLocalTime();
		
		LocalDateTime dt1 = date1.atTime(time1);
		
		// Yêu cầu: Tìm hiệu giữa 2 mốc time trên
		
		System.out.println("=== DateTime Deviation ===");
		
		if(dateTime1.isAfter(dateTime2)) {
			throw new IllegalArgumentException("dateTime1 must be before dateTime2");
		}
		
		Period period = Period.between(dateTime1.toLocalDate(), dateTime1.toLocalDate());
		Duration duration = Duration.between(dateTime1.toLocalTime(), dateTime2.toLocalTime());
		
		if(duration.isNegative()) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}
		
		System.out.println("deviation diff --> "
				+ getUnitValue(period.getYears(), "year")
				+ getUnitValue(period.getMonths(), "month")
				+ getUnitValue(period.getDays(), "day")
				+ getUnitValue(duration.toHoursPart(), "hours")
				+ getUnitValue(duration.toMillisPart(), "minute")
				+ getUnitValue(duration.toSecondsPart(), "second")); 
		
	}
	
}
