package datetime;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex02CalendarInitial {
	public static void main(String[] args) {
		//factory/singleton patten
		
		//locale(language, lacation)
		
		System.out.println("defalt locale: " + Locale.getDefault());
		System.out.println("defalt time zone:  " + TimeZone.getDefault());
		
		Calendar c = Calendar.getInstance(); 
		System.out.println("Caledar c --> " + c);
		
		String[] timezone = TimeZone.getAvailableIDs();
		
		for(String tz:timezone) {
			System.out.println("tz: " + tz);
		}
		
		System.out.println("\n=================\n");
		
		Calendar ldTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
		System.out.println("ldTime: " + ldTime);
		
	}
}
