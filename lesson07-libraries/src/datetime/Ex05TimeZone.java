package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Ex05TimeZone {
	
	public static void main(String[] args) {
		System.out.println("Dèault timezone:  " + TimeZone.getDefault());
		int count = 0;
		String[] timezoneIds = TimeZone.getAvailableIDs();
		
		for(String timezoneId: timezoneIds) {
			System.out.printf("%-30s", timezoneId);
			if(count++ % 10 == 0) {
				System.out.println(timezoneId);
			}
		}
		
		System.out.println("\n====================");
		
		TimeZone tz1 = TimeZone.getTimeZone("Indian/Mahe ");
		TimeZone.setDefault(tz1);
		
		Calendar c1 = Calendar.getInstance();
		System.out.println("C1: " + c1);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss ");
		df.setTimeZone(tz1);
		System.out.println("format: " + df.format(c1.getTime()));
	}

}
