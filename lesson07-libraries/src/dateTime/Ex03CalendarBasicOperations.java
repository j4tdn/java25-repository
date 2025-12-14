package dateTime;

import java.util.Calendar;

public class Ex03CalendarBasicOperations {

	public static void main(String[] args) {
		
		// Timezone: quyet dinh thoi gian trong calendar
		
		Calendar c = Calendar.getInstance();
		
		System.out.println("Thoi gian hien tai" + c);
		
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH) + 1;
		int year = c.get(Calendar.YEAR);
		
		int hour = c.get(Calendar.HOUR); // clock 12, am/pm
		int apm = c.get(Calendar.AM_PM);
		
		int hourOfDay = c.get(Calendar.HOUR_OF_DAY); // clock 24
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		String time = dayOfMonth + "/" + month + "/" + year + " " + hourOfDay + ":" + minute + ":" + second;
		System.out.println("dd/MM/yyyy HH:mm:ss --> " + time);
		System.out.printf("hour(%s), apm(%s)", hour, apm == 0 ? "am" : "pm");
	}
	
}
