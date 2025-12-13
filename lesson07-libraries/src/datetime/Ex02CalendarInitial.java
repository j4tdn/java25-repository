package datetime;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex02CalendarInitial {

	public static void main(String[] args) {
		// factory/singleton pattern
		
		// locale(language, location)
		
		System.out.println("default lacale: "+ Locale.getDefault());
		System.out.println("default timezones: "+ TimeZone.getDefault());
	
		System.out.println("\n ============================");
		
		Calendar c = Calendar.getInstance(); 
		System.out.println("calendaer c --> "+c);
		
		String[] timezones= TimeZone.getAvailableIDs();
		for(String tz: timezones) {
			System.out.println("tz: "+tz);
		}
		

		
		System.out.println("\n ============================");
		
		Calendar ldTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
		System.out.println("ldTime: "+ ldTime);
	}
	
}
