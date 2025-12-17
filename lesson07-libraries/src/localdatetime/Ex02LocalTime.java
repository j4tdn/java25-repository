package localdatetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Ex02LocalTime {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy E");
		LocalTime time1 = LocalTime.now();
		LocalTime time2 = LocalTime.now(ZoneId.of("Europe/Berlin"));
		System.out.println("time 1: "+ time1);
		System.out.println("time 2: "+ time2);
		System.out.println("\n============= Time Query =============\n");
		
		System.out.println("time2 hour(c24"+ time2.getHour());
		System.out.println("time2 format: " + dtf.format(time2));
		
		System.out.println("\n============== LocalTime(deviation) Duration ==================");
		Duration duration = Duration.between(time2, time1);
		System.out.println("duration "+ duration);
		System.out.println("duration diff: "
				+ getUnitValue(duration.toHoursPart(),"hour")
				+ getUnitValue(duration.toHoursPart(),"minute")
				+ getUnitValue(duration.toHoursPart(),"second")
				
				);
		
		
	}

	private static String getUnitValue(int hoursPart, String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
