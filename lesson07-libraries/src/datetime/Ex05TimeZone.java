package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Ex05TimeZone {
	// Timezone(UTC) --> tác động đến kết quả khi get ra date, calendar
	//				--> lấy từ configured timezone của hệ điều hành
	
	// Locale: --> tác động đến ngày đầu tuần là chủ nhật, thứ hai
	//			--> mặc định en_Us
	
	public static void main(String[] args) {
		
		// ZoneInfo[id="A
		System.out.println("Default timezone: " + TimeZone.getDefault());
		
		int count = 0;
		String[] timezoneIds = TimeZone.getAvailableIDs();
		for (String timezoneId: timezoneIds) {
			System.out.printf("%-30s", timezoneId);
			if (count++ % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n============================\n");
		
		TimeZone tz1 = TimeZone.getTimeZone("Europe/Berlin");
		
		Calendar c1 = Calendar.getInstance(tz1);
		System.out.println("c1: " +c1);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
	}

}
