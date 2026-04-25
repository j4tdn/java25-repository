package datetime;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex02CalendarInitial {

	public static void main(String[] args) {
		
		System.out.println("Dèault lecale: " + Locale.getDefault());
		
		Calendar c = Calendar.getInstance();
		System.out.println("calender c ->> " + c);
		
		String[] timezones = TimeZone.getAvailableIDs();
		
		for(String tz : timezones) {
			System.out.println("TZ: " + tz);
		}
		
		Calendar ldTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
		System.out.println("LDtime: " + ldTime);
	}
	
}
