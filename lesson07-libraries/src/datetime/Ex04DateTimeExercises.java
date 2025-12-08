package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex04DateTimeExercises {

	/*
	 1. In thông tin ngày tháng năm với DateFormatter
	 2. Tháng, năm hiện tại có bao nhiêu ngày
	 3. Kiểm tra năm hiện tại có phải là năm nhuận k
	 4. Ngày hiện tại là ngày thứ mấy, in ra theo tiếng việt
	 5. In thông tin các ngày trog tháng, tuần hiện tại đ/MM/yyyy week_day
	 6. Đếm xem trong tháng có bao nhiêu ngày chủ nhật và in ra
	 */
	 
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance(); // 6/12/2025
		//c.set(Calendar.MONTH, Calendar.JUNE);
		//c.set(Calendar.YEAR,2020);
		
		Date date = c.getTime();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dateAsString = df.format(date);
		
		System.out.println("1. Thông tin ngày tháng năm với DateFormat: " + df.format(date));
		
		System.out.println("2. Số ngày trong tháng: " + c.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("2. Số ngày trong năm: " + c.getActualMaximum(Calendar.DAY_OF_YEAR));

		// Lịch dương
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println("3. Kiếm tra năm nhuận: " + gc.isLeapYear(c.get(Calendar.YEAR)));
		
		// DayOfWeek: Sun(1), Mon(2),...Sat(7)
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ hai",  "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy"};
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("4. Ngày thứ mấy: " + dayOfWeeks[dayOfWeek-1]);
		
		System.out.println("5. Các ngày trong tháng");
		Calendar startDayOfMonth = Calendar.getInstance();
		startDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar endDayOfMonth = Calendar.getInstance();
		endDayOfMonth.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);
		
		df = new SimpleDateFormat("dd/MM/yyyy EEEE");
		for(Calendar cal = startDayOfMonth; cal.before(endDayOfMonth); cal.add(Calendar.DAY_OF_MONTH, 1)) {
			System.out.println(df.format(cal.getTime()));
		}
	}
}
