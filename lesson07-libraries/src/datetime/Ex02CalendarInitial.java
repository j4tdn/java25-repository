package datetime;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex02CalendarInitial {
	public static void main(String[] args) {

		// factory/singleton pattern

		// locale(language, location)
		System.out.println("default cocale: " + Locale.getDefault());
		System.out.println("default TimeZone: " + TimeZone.getDefault());

		System.out.println("\n==========================================\n");

		Calendar c = Calendar.getInstance();
		System.out.println("calender c: " + c);
		

		String[] timezone = TimeZone.getAvailableIDs();
		for (String tz : timezone) {
			System.out.println("Timezone: " + tz);

		}
		
		System.out.println("\n==========================================\n");

		Calendar ldTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
		System.out.println("LdTime: " + ldTime);
		
		

	}

}
