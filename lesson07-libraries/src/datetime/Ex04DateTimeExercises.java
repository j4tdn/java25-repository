package datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Ex04DateTimeExercises {
		/*
		 *  1.In thông tin ngày tháng năm với DateFormatter
			2.Tháng, năm hiện tại có bao nhiêu ngày
			3.Kiểm tra năm hiện tại có phải là năm nhuận không
			4.Ngày hiện tại là ngày thứ mấy, in ra ngày theo tiếng việt
			5.In thông tin các ngày trong tháng, tuần hiện tại dd/MM/yyyy week_day
			6. Đếm xem trong tháng có bao nhiêu ngày chủ nhật và in ra
	
		 * */
	
	public static void main(String[] args) {
		Locale.setDefault(new Locale("vi", "VN"));
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();		

		
		//1.
		DateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
		String dateAsString = ft.format(date);
		System.out.println("1. Hôm nay: " +dateAsString);
		
		//2.
		System.out.println("2. So ngay trong thang: " + c.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("2. so ngay trong nam: " + c.getActualMaximum(Calendar.DAY_OF_YEAR));
		
		//3. 
		System.out.println("3. kiem tra nam nhuan: " + isLeapYear(c.get(Calendar.YEAR)));
		
		//4.
		System.out.println("4. Hôm nay là : " + getDayOfWeeksInVnmese(c.get(Calendar.DAY_OF_WEEK)));
	
		//5. 
		System.out.println("5. Cac ngay trong thang (dd/MM/yyyy week_day)");
		printDaysInMonth(c);
		
		System.out.println();
		
		System.out.println("Local mặc định: " + Locale.getDefault());
		
		int firstDayOfWeek = c.getFirstDayOfWeek();
		System.out.println("Ngay dau tuan: " + firstDayOfWeek);
		System.out.println("5. Cac ngay trong Tuan (dd/MM/yyyy week_day)");
		printDaysInWeek(c);
		
		System.out.println("6. Cac ngay chu cn trong thang: ");
		printWeeksInMonth(c, Calendar.SUNDAY);
		
		
				
	}
	
	private static void printWeeksInMonth(Calendar c, int weekday) {
	    Calendar startDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, 1);
	    Calendar endDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	    endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);

	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy EEEE");
	    int count = 0;

	    for (Calendar cal = (Calendar) startDayOfMonth.clone(); cal.before(endDayOfMonth); cal.add(Calendar.DAY_OF_MONTH, 1)) {
	        if (cal.get(Calendar.DAY_OF_WEEK) == weekday) {
	            System.out.println(df.format(cal.getTime()));
	            count++;
	        }
	    }
	    System.out.println("=> Trong tháng có " + count + " ngày " + getDayOfWeeksInVnmese(weekday));
	}

	
	
	private static void printDaysInWeek(Calendar c) {
		Calendar startDayOfWeek= clone(c);
		startDayOfWeek.add(Calendar.DAY_OF_MONTH, startDayOfWeek.getFirstDayOfWeek() - startDayOfWeek.get(Calendar.DAY_OF_WEEK));

		Calendar endDayOfWeek= clone(startDayOfWeek);
		endDayOfWeek.add(Calendar.DAY_OF_MONTH, 7);

		SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy EEEE");

		for(Calendar cal = startDayOfWeek; cal.before(endDayOfWeek); cal.add(Calendar.DAY_OF_MONTH, 1)) {
			System.out.printf("%-25s", df.format(cal.getTime()));
		}

	}
	
	private static void printDaysInMonth(Calendar c) {
		Calendar starDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, 1);
		
		Calendar endDayOfMonth = cloneAndSet(c, Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDayOfMonth.add(Calendar.DAY_OF_MONTH, 1);

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy EEEE");

		for (Calendar cal = (Calendar) starDayOfMonth.clone(); 
		     cal.before(endDayOfMonth); 
		     cal.add(Calendar.DAY_OF_MONTH, 1)) {
		    System.out.printf("%-25s", df.format(cal.getTime()));
		    if(cal.get(Calendar.DAY_OF_MONTH) % 5 ==0) {
		    	System.out.println();
		    }
		}
	}
	
	private static String getDayOfWeeksInVnmese(int dayOfWeek) {
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ tư", "Thứ Năm", "Thứ Sau", "Thứ Bảy"};
		return dayOfWeeks[dayOfWeek-1];
	}
	
	private static boolean isLeapYear(int year) {
			GregorianCalendar gc = new GregorianCalendar();
			return gc.isLeapYear(year);
		}
	private static Calendar cloneAndSet(Calendar source, int field, int value) {
		Calendar target = Calendar.getInstance();
		target.setTimeInMillis(source.getTimeInMillis());
		target.set(field, value);
		return target;
	}
	
	private static Calendar clone(Calendar source) {
		Calendar target = Calendar.getInstance();
		target.setTimeInMillis(source.getTimeInMillis());
		return target;
	}
}
