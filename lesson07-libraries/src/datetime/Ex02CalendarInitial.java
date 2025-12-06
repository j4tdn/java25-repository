package datetime;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex02CalendarInitial {

	public static void main(String[] args) {
		
		// factory/singleton pattern
		
		// locale(language, location)
		
		System.out.println("default locale: " + Locale.getDefault());
		System.out.println("default timezone: " + TimeZone.getDefault());
		
		Calendar c = Calendar.getInstance();
		System.out.println("calendar c --> " + c);
		
		String[] timezones = TimeZone.getAvailableIDs();
		for(String tz: timezones) {
			System.out.println("tz: " + tz);
		}
		
		Calendar ldTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
		System.out.println("ldTime: " + ldTime);
		
	}
	
}
