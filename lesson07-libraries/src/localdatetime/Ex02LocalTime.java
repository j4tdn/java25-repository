package localdatetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static localdatetime.DateTimeUtils.*;
public class Ex02LocalTime {
	
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		LocalTime time1 = LocalTime.now();
		LocalTime time2 = LocalTime.now(ZoneId.of("Europe/Berlin"));
		
		System.out.println("time1: " + time1);
		System.out.println("time2: " + time2);
		
		System.out.println("\n================== Time query===========");
		
		System.out.println("time2 hour: " + time2.getHour());
		System.out.println("time2 fornat: " + dtf.format(time2));
		
		System.out.println("\n================== LocalTime(deviation) duration=============\n");
		
		Duration duration = Duration.between(time2, time1);
		System.out.println("Duration: " + duration);
		
		System.out.println("Duration diff: "
				+ getUnitValue(duration.toHoursPart(), "year ")
				+ getUnitValue(duration.toMinutesPart(), "month ")
				+ getUnitValue(duration.toSecondsPart(), "day")
				
				);
		long minutesDev = ChronoUnit.MINUTES.between(time2, time1);
		System.out.println(minutesDev);
	}

}
