package datetime;

import java.util.Calendar;

public class Ex03CalendarBasicOperations {

	public static void main(String[] args) {
		
		//Timezone: quyết định thời gian trong calendar 
		
		Calendar c = Calendar.getInstance();
		
		System.out.println("Thời gian hiện tại: " + c); //GregorianCalendar
		
		int dayOfmonth = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR);
		
		int hour = c.get(Calendar.HOUR); // clock 12; am/pm
		int apm = c.get(Calendar.AM_PM);
		
		int houofday = c.get(Calendar.HOUR_OF_DAY); // clock 24
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		String time = dayOfmonth + "/" + month + "/" + year + "  " + houofday + ":" + minute + ":" + second;
		System.out.println("dd/MM/yyyy HH:mm:ss --> " + time);
		System.out.printf("hour(%s), apm(%s)", hour, apm == 0 ? "am" : "pm");
	
	}
	
}
