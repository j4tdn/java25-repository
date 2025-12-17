package localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Ex03LocalDateTime {
	public static void main(String[] args) throws IllegalAccessException {
		//LocalDateTime : localdate, localtime 
		LocalDateTime dt1 = LocalDateTime.of(2020,4,20,10,20,30);
		LocalDateTime dt2 = LocalDateTime.now();
		
		System.out.println("datetime1: "+dt1);
		System.out.println("datetime2: "+dt2);
		
		System.out.println("\n============== Datetim Query ============\n");
		
		LocalDate date2 = dt2.toLocalDate();
		LocalTime time2 = dt2.toLocalTime();
		
		
		// Yêu cầu : Tìm hiệu iuwax 2 mốc thời gian tên 
		// Ngày tháng năm giờ phút giây
		//LocalDate r period 
		//LocalTime : Duration 
		// LocalDateTime: x
		
		System.out.println("\n================== DateTime Deviation ================\n");
		
		if(dt1.isAfter(dt2)) {
			throw new IllegalAccessException("datetime musst be less than dt2.....");
			
		}
		Period period = Period.between(dt1.toLocalDate(), dt2.toLocalDate());
		Duration duration = Duration.between(dt1.toLocalTime(), dt2. toLocalTime());
		if (duration. isNegative()) {
		duration = duration.plusDays (1);
		period = period.minusDays (1);
		System.out.println(period + " " + duration);
		System.out.println("deviation: "
		+ getUnitValue (period.getYears(), "year")
		+ getUnitValue (period.getMonths (), "month" )
		+ getUnitValue(period.getDays(), "day")
		+ getUnitValue(duration. toHoursPart(), "hour")
		+ getUnitValue(duration.toMinutesPart(), "minute")
		+ getUnitValue(duration.toSecondsPart(), "second")
		);
		}
	}

	private static String getUnitValue(int years, String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
