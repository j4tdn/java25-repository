package datetime;

import java.util.Calendar;

public class Ex03CalendarBasicOperations {
	public static void main(String[] args) {
		//Time zone quyết định thời gian trong calendar
		Calendar c = Calendar.getInstance();
		System.out.println("Thời gian hiện tại: "+ c);
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		
		int month = c.get(Calendar.MONTH)+ 1;//(0-11)
		int year = c.get(Calendar.YEAR);
		int hour = c.get(Calendar.HOUR);// clock 12, am /pm
		int apm = c.get(Calendar.AM_PM);
		int hourOfday = c.get(Calendar.HOUR_OF_DAY);// hour of day 24h
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		String time = dayOfMonth + "/" + month + "/" + year + "  " + hourOfday + ":" +minute +":" + second ;
		System.out.println("dd/mm/yyyy HH:mm:ss " + time);
		System.out.printf ("hour(%s) apm(%s)",hour,apm == 0 ? "am":"pm");
		
	}

}
