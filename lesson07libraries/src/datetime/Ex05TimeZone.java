package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Ex05TimeZone {
	//TimeZone(UTC) --> tác động đến kết quả khi get ra Date, Calender
	//				--> lấy từ cinfigured timezone của hệ điều hành
	
	//Locale: --> tác động đến ngày đầu tiên của tuần là chủ nhật, thứ hai
	//        --> mặc định en_US	
	
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
		System.out.println("\n=============================");
		
		//Calender và Datefomat sử dụng timezone độc lập
		//Muốn format cùng thời gian với Canlendar thì phải sử dụng chung timezone bằng cách
		//1.set lại defaut timezone
		//2.Truyền timezone vào cho Calendar và DateFormat
		
		TimeZone tz1 = TimeZone.getTimeZone("Europe/Berlin");
		//TimeZone.setDefault(tz1);
		
		Calendar c1 = Calendar.getInstance();
		System.out.println("c1: " + c1);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss ");
		df.setTimeZone(tz1);
		System.out.println("fomat " + df.format(c1.getTime()));
	}
}
