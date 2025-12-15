package localdatetime;

import static utils.DateTimeUtils.getUnitValue;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ex02LocalTime {
	
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		LocalTime time1 = LocalTime.now();
		LocalTime time2 = LocalTime.now(ZoneId.of("Europe/Berlin"));
		
		System.out.println("time1: " + time1);
		System.out.println("time2: " + time2);
		
		System.out.println("\n============ Time Query ===============\n");
		
		System.out.println("time2 hour(c24): " + time2.getHour());
		System.out.println("time2 format: " + dtf.format(time2));
		
		System.out.println("\n============ LocalTime(deviation) Duration ===============\n");
		
		Duration duration = Duration.between(time2, time1);
		
		System.out.println("duration: " + duration);
		System.out.println("duration diff: " 
        		+ getUnitValue(duration.toHoursPart(), "hour")
        		+ getUnitValue(duration.toMinutesPart(), "minute")
        		+ getUnitValue(duration.toSecondsPart(), "second"));
		
		// Calendar#add
		// DateTime#plus&minus
		long minutesDev = ChronoUnit.MINUTES.between(time2, time1);
		System.out.println("minutesDev: " + minutesDev);
	}
	
}