package datetime;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex02CalendarInitial {
	public static void main(String[] args) {
		// factory pattern
		
		
		System.out.println("default locale: " + Locale.getDefault());
		System.out.println("defaul timezone: " );
		
		Calendar c = Calendar.getInstance();
		System.out.println("Calender c --> " + c);
		
		String[] timezones = TimeZone.getAvailableIDs();
		for (String tz: timezones) {
			System.out.println("tz: " + tz);
		}
		
		Calendar ldTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
		System.out.println("ldTime: " + ldTime);
	}

}
