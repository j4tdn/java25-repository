package localdatetime;

import static localdatetime.DateTimeUtils.getUnitValue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Ex03LocalDateTime {
	
	public static void main(String[] args) throws IllegalAccessException {
		
		LocalDateTime datetime1 = LocalDateTime.of(2020, 4, 20, 10, 20, 30);
		LocalDateTime datetime2 = LocalDateTime.now();
		
		System.out.println("datetime1: " + datetime1);
		System.out.println("datetime2: " + datetime2);
		
		System.out.println("\n=================DateTime Querry=============");
		
		LocalDate date2 = datetime2.toLocalDate();
		LocalTime time2 = datetime2.toLocalTime();
		
		// tìm hiệu cảu 2 môcs thời gian  
		
		System.out.println("\n=============== DateTime Deviation =============\n");
		
		if(datetime1.isAfter(datetime2)) {
			throw new IllegalAccessException("Date mus be less than dt2");
		}
		Period period = Period.between(datetime1.toLocalDate(), datetime2.toLocalDate());
		Duration duration = Duration.between(datetime1.toLocalTime(), datetime2.toLocalTime());
		
		if(duration.isNegative()) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}
		System.out.println(period + " " + duration);
		System.out.println("deviation: "
				+ getUnitValue(period.getYears(), "year")
				+ getUnitValue(period.getMonths(), "month")
				+ getUnitValue(period.getDays(), "day")
				+ getUnitValue(duration.toHoursPart(), "year ")
				+ getUnitValue(duration.toMinutesPart(), "month ")
				+ getUnitValue(duration.toSecondsPart(), "day")
				
				);
	}

}
