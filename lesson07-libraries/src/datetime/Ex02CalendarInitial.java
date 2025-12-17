package datetime;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex02CalendarInitial {
	public static void main(String[] args) {
		
		
		//factory/singleton pattern 
		Calendar c = Calendar.getInstance();
		System.out.println("calendar c : "+c);
		
		//locate(location,language) 
		System.out.println("default locate: "+ Locale.getDefault());
		
		String[] timeZones = TimeZone.getAvailableIDs();
		for(String tz: timeZones) {
			System.out.println("tz : "+timeZones);
		}
		
		Calendar ldTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
		System.out.println("ldTime: "+ ldTime);
		
		}

}
