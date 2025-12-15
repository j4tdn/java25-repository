package datetime;

import java.util.Calendar;

public class Ex03CalenderBasicOperation {
	public static void main(String[] args) {
		// Timzone: quyet dinh thoi gian trong calendar
		
		Calendar c = Calendar.getInstance();
		
		System.out.println("Thoi gian hien tai: " + c); // GregorianCalendar
		
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		int hour = c.get(Calendar.HOUR);
		int apm = c.get(Calendar.AM_PM);
		
		int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		String time = dayOfMonth + "/" + month + '/' + year + " " + hourOfDay + ":" + minute + ":" + second;
		System.out.println("dd/mm/yyyy HH:mm:ss -->" + time);
		
		System.out.printf("hour(%s), apm(%s)", hour, apm == 0 ? "am" : "pm");
		
	}
}
