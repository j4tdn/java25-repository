package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Ex05TimeZone {
	
	// Timezone(UTC) --> tác động đến kết quả khi get la Date, Calendar
	//                -> lay tu configured timezone của hệ điều hành  
	
	// Locale -> tác động đến ngày đầu tuần là chủ nhật , thứ hai
	//        -> mặc định en_US
	public static void main(String[] args) {
		
		System.out.println("Default Timezone: " + TimeZone.getDefault());
		
		int count = 0;
		String[] timezoneIds = TimeZone.getAvailableIDs();
		for (String timezoneId : timezoneIds) {
			System.out.printf("%-30s", timezoneId);
			if (count++ % 10 == 0) {
				System.out.println();
			}
		}
		
		System.out.println("\n=========================\n");
		
		// Calendar và DateFormat sử dụng Timezone độc lập
		// Muốn Format cùng thời gian với Calendar thì phải sử dụng chung Timezone bằng cách:
		//   1. set lại default timezone
		//   2. truyền timezone vào cho calendar và DateFormat
		
		TimeZone tz1 = TimeZone.getTimeZone("Europe/Berlin");
		TimeZone.setDefault(tz1);
		
		Calendar c1 = Calendar.getInstance(tz1);
		System.out.println("c1: " + c1);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		df.setTimeZone(tz1);
		System.out.println("format: " + df.format(c1.getTime()));
		
		
		
	}

}
