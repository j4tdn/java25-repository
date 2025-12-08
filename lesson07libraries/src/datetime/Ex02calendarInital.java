package datetime;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex02calendarInital {

	public static void main(String[] args) {
		// factory pattern
		
		//locale(languege, location)
		
		System.out.println("default locale: " + Locale.getDefault());
		System.out.println("default timezone: " + TimeZone.getDefault());
		
		System.out.println("\n============================\n");
		
		Calendar c = Calendar.getInstance();
		System.out.println("calender c --> " + c);
		
		String[] timeZones = TimeZone.getAvailableIDs();
		for(String tz : timeZones) {
			System.out.println("tz: " + tz);
		}
		
		Calendar ldTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
		System.out.println("ldtime: " + ldTime);
	}
}
