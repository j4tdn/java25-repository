package localdatetime;

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
		LocalDateTime datetime1 = LocalDateTime.of(2020, 4, 20, 23, 20, 30);
		LocalDateTime datetime2 = LocalDateTime.now();
		
		System.out.println("datetime1: " + datetime1);
		System.out.println("datetime2: " + datetime2);
		
		System.out.println("\n================ DateTime Query =================\n");
		
		// LocalDate date2 = datetime2.toLocalDate();
		// LocalTime time2 = datetime2.toLocalTime();
		// LocalDateTime dt2 = date2.atTime(time2); // time2.atDate(date1)
		
		// Yêu cầu: Tìm hiệu giữa 2 mốc thời gian trên
		// ? Ngày ? Tháng ? Năm ? Giờ ? Phút ? Giây
		// LocalDate    : Period
		// LocalTime    : Duration
		// LocalDateTime: x
		
		// 2,5
		// 2,8
		
		System.out.println("\n================ DateTime Deviation =================\n");
		
		if (datetime1.isAfter(datetime2)) {
			throw new IllegalArgumentException("datetime1 must be less than datetime2 ...");
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
        		+ getUnitValue(duration.toSecondsPart(), "second")
        );
				
		
	}
	
	
}
