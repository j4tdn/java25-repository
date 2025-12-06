package datetime;

import java.util.Calendar;

public class Ex03CalendarBasicOperator {

	public static void main(String[] args) {
		
		// Timezone: quyết định thời gian trong Calendar
		
		Calendar c = Calendar.getInstance();
		
		System.out.println("Thời gian hiện tại: " + c); // GregorianCalendar
		
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH); // 0-11
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		int hour = c.get(Calendar.HOUR); // Clock 12, AM/PM
		int apm = c.get(Calendar.AM_PM);
		int hourOfDay = c.get(Calendar.HOUR_OF_DAY); // Clock 24
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		String time = dayOfMonth + "/" + month + 1 + "/" + year
				+ " " + hourOfDay + ":" + minute + ":" + second;
		System.out.println("dd/MM/yyyy HH:mm:ss --> " + time);
		System.out.printf("hour(%s), apm(%s)", hour, apm == 0 ? "am" : "pm");
		
	}
	
}
