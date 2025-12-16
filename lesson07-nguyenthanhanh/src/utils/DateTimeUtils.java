package utils;

import java.time.DayOfWeek;

public class DateTimeUtils {

	private DateTimeUtils() {
		
	}
	
	public static int convertDayOfWeekToInt(DayOfWeek dow) {
		if(dow == DayOfWeek.SUNDAY) {
			return 1;
		}
		return dow.getValue() + 1;
	}
	
	public static String getDayOfWeeksInVietnamese(int dayOfWeek) {
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
		return  dayOfWeeks[dayOfWeek-1];	
	}
	
}
