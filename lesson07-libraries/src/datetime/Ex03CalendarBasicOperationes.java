package datetime;

import java.util.Calendar;

public class Ex03CalendarBasicOperationes {
	public static void main(String[] args) {
		// TimeZone: quyết định thời gian trong calendar

		Calendar c = Calendar.getInstance();
		System.out.println("Thời gian hiện tại:" + c);
		
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		int hour = c.get(Calendar.HOUR);
		int apm = c.get(Calendar.AM_PM);
		
		int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		String time = dayOfMonth + "/" + month + "/" + year + " " + hourOfDay + ":" + minute + ":" + second;
 		System.out.println("dd/MM/yyyy HH:mm:ss --> " + time);
 		System.out.printf("hour(%s), apm(%s)", hour, apm == 0 ? "am" : "pm");
	}

	

}
