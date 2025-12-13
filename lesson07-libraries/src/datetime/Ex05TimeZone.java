package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Ex05TimeZone {

	// Timezone(UTC) --> tác động đến kết quả khi get ra Date, Calendar
	// --> lấy từ config timezone của hệ điều hành

	// Locale: --> tác động đến ngày đầu tuần là chủ nhật, thứ hai
	// --> mặc định en_US

	public static void main(String[] args) {
		// sun.util.calendar.ZoneInfo[id="Asia/Bangkok",offset=25200000,dstSavings=0,useDaylight=false,transitions=3,lastRule=null]

		System.out.println("Default timezone: " + TimeZone.getDefault());
		int count = 0;
		String[] timeZoneIds = TimeZone.getAvailableIDs();
		for(String timeZoneId : timeZoneIds) {
			System.out.printf("%-30s",timeZoneId);
			if(++count%10==0) {
				System.out.println();
			}
		}
		
		System.out.println("\n===================\n");
		
		// Calendar và DateFormat sử dụng TimeZone độc lập
		// Muốn format cùng thời gian với Calendar thì phải sử dụng chung TimeZone bằng cách
		// 1. Set lại default TimeZone
		// 2. Truyền timezone vào cho Calendar và DateFormat
		
		TimeZone tz1 = TimeZone.getTimeZone("Europe/Berlin");
//		TimeZone.setDefault(tz1);
		
		Calendar c1 = Calendar.getInstance(tz1);
		
		System.out.println("c1: "+c1);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		df.setTimeZone(tz1);
		System.out.println("format: "+ df.format(c1.getTime()));
	}

}
