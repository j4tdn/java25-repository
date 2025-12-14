package dateTime;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex02CalendarInitial {

	public static void main(String[] args) {
		
		// factory pattern
		
		// locate(language, location)
		
		System.out.println("dafault locale: " + Locale.getDefault());
		System.out.println("dafault timezone: " + TimeZone.getDefault());
		
		System.out.println("\n==============================\n");
		
		Calendar c = Calendar.getInstance();
		System.out.println("Calendadr c --> " + c);
		
		String[] timezones = TimeZone.getAvailableIDs();
		for(String tz: timezones) {
			System.out.println("tz: " + tz);
		}
		
		System.out.println("\n==============================\n");
		
		Calendar lTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
		System.out.println("LD Time: " + lTime);
	}
	
	
}
