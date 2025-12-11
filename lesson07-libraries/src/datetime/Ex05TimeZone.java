package datetime;

import java.util.TimeZone;

public class Ex05TimeZone {

	// Timezone(UTC): --> tác động đến result khi get Date, Calendar
	//				  --> lấy từ configured timezone của hđh
	// Locale: --> tác động đến ngày đầu tuần là chủ nhật, thứ hai
	//		   --> mặc định en_US
	public static void main(String[] args) {
		
		System.out.println("Default timezone: " + TimeZone.getDefault());
		
		int count = 0;
		String[] timezoneIds = TimeZone.getAvailableIDs();
		for(String timezoneId : timezoneIds) {
			System.out.printf("%-30s", timezoneId);
			if(count++ % 10 == 0) {
				System.out.println();
			}
		}
		
	}
	
}
