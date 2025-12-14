package localdatetime;

import static utils.DateTimeUtils.getUnitValue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Ex03LocalDateTime {

	public static void main(String[] args) {
		
		LocalDateTime datime1 = LocalDateTime.of(2020, 4, 20, 10, 20, 30);
		LocalDateTime datime2 = LocalDateTime.now();
		
		System.out.println("datetime1: " + datime1);
		System.out.println("datetime2: " + datime2);
		
		System.out.println("\n========= DataTime Query =======\n");
		
		
		//  Tim hieu 2 moc thoi gian
		
		System.out.println("\n============= DateTime Deviation ===========\n");
		
		if(datime1.isAfter(datime2)) {
			throw new IllegalArgumentException("datime1 must be less than datime2");
		}
		
		LocalDate date1 = datime1.toLocalDate();
		LocalDate date2 = datime2.toLocalDate();
		LocalTime time1 = datime1.toLocalTime();
		LocalTime time2 = datime2.toLocalTime();
		
		Period period = Period.between(date1, date2);
		
		Duration duration = Duration.between(time1, time2);
		
		if(duration.isNegative()) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}
		
		System.out.println("time: " 
				+ getUnitValue(period.getYears(), "year")
				+ getUnitValue(period.getMonths(), "month")
				+ getUnitValue(period.getDays(), "day")
				+ getUnitValue(duration.toHoursPart(), "hour")
				+ getUnitValue(duration.toMinutesPart(), "minute")
				+ getUnitValue(duration.toSecondsPart(), "second"));
		
	}
	
}
