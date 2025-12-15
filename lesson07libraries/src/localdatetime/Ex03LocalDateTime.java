package localdatetime;

import static utils.DateTimeUtils.getUnitValue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Ex03LocalDateTime {

	public static void main(String[] args) throws IllegalAccessException {
		
		//localDateTime: LocalDate, LocalTime
		//default pattern: "yyyy/MM/dd'T' HH:mm:ss"
		LocalDateTime datime1 = LocalDateTime.of(20, 4 , 20, 10, 20, 30);
		LocalDateTime datime2 = LocalDateTime.now();
		
		System.out.println("datime1: " + datime1);
		System.out.println("datime2: " + datime2);
		
		System.out.println("\n================ DateTime Query =================\n");
		
		//LocalDate date2 = datime2.toLocalDate();
		//LocalTime time2 = datime2.toLocalTime();
		//LocalDateTime dt2 = date2.atTime(time2);//time.atDate(date1)
		//yêu cầu: tìm hiệu giữa 2 mốc thời gian trên
		//? ngày ? tháng ? năm ? giờ ? phút ? giây
		
		System.out.println("\n================ DateTime Deviation =================\n");
		
		if(datime1.isAfter(datime2)) {
			throw new IllegalAccessException(" dateTime1 must be less than datetime2 ...");
		}
		
		Period period = Period.between(datime1.toLocalDate(), datime2.toLocalDate());
		Duration duration = Duration.between(datime1.toLocalTime(), datime2.toLocalTime());
		
		if(duration.isNegative()) {
			duration = duration.plusDays(1);
			period = period.minusDays(1);
		}
		System.out.println(period + " " + duration);
		System.out.println("deviation: "
			+ getUnitValue(period.getYears(), "year")
			+ getUnitValue(period.getMonths(), "month")
			+ getUnitValue(period.getDays(), "day")
			+ getUnitValue(duration.toHoursPart(), "hour")
			+ getUnitValue(duration.toMillisPart(), "minute")
			+ getUnitValue(duration.toSecondsPart(), "second")
			);
		
		
		
	}
	
}
