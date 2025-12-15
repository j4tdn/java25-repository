package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Ex05TimeZone {
	public static void main(String[] args) {
		System.out.println("Default timezone:" + TimeZone.getDefault());

		int count = 0;

		String[] timezoneIds = TimeZone.getAvailableIDs();
		for (String timezoneId : timezoneIds) {
			System.out.printf("%-30s", timezoneId);
			if (count++ % 10 == 0) {
				System.out.println();
			}

		}

		System.out.println("\n=====... =======\n");

		// Calendar và DateFormat sử dụng TimeZone độc lập
		// Muốn format cùng thời gian với Calendar thì phải sử dụng chung TimeZone bằng cách	
		// 1. Set lai default timezone
		// 2. Truyền timezone vào cho Calendar và DateFormat

		TimeZone tz1 = TimeZone.getTimeZone("Europe/Berlin");
		// TimeZone.setDefault(tz1);

		Calendar c1 = Calendar.getInstance(tz1);
		System.out.println("c1: " + c1);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		df.setTimeZone(tz1);
		System.out.println("format: " + df.format(c1.getTime()));
	}
}
