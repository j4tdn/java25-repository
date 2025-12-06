package datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex04DateTimeExercises {

	
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		System.out.println("1. DateTimeFormatter --> " + format.format(now.getTime()));
		
		System.out.println("2. Số ngày của tháng hiện tại --> " + 
				now.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("2. Số ngày của năm hiện tại --> " + 
				now.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		System.out.println("3. Năm hiện tại " + (now.getActualMaximum(Calendar.DAY_OF_YEAR) > 365 ?
				" không phải": "") + "là năm nhuận");
		
		// Dương lịch
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println("Kiểm tra năm nhuận --> " + gc.isLeapYear(now.get(Calendar.YEAR)));
		
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", 
				"Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
		System.out.println("4. Ngày thứ --> " +  
				dayOfWeeks[now.get(Calendar.DAY_OF_WEEK) - 1]);
		
		System.out.println("5. Các ngày trong tháng(dd/MM/yyyy week_day)");
		Calendar startDayOfMonth = Calendar.getInstance();
		startDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar endDayOfMonth = Calendar.getInstance();
		endDayOfMonth.set(Calendar.DAY_OF_MONTH, now.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		format = new SimpleDateFormat("dd/MM/yyyy EEEE");
		for(Calendar cal = startDayOfMonth; cal.before(endDayOfMonth); cal.add(Calendar.DAY_OF_MONTH, 01)) {
			System.out.println(format.format(cal.getTime()));
		}
		
	}
	
}
