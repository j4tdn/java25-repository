package view.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Ex02WeekdayCalculator {
	
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		Locale.setDefault(new Locale("vi", "VN"));
		try {
			int day = readTime("Nhập ngày (1-31): ");
			if(day < 1 || day > 31) {
            	throw new IllegalArgumentException("Ngày phải từ 1 đến 31");
            }
            int month = readTime("Nhập tháng (1-12): ");
            if(month < 1 || month > 12) {
            	throw new IllegalArgumentException("Tháng phải từ 1 đến 12");
            }
            int year = readTime("Nhập năm (>0): ");
            
            if(year < 0) {
            	throw new IllegalArgumentException("Năm phải > 0");
            }
            
            GregorianCalendar gc = new GregorianCalendar();
            gc.set(Calendar.YEAR, year);
            gc.set(Calendar.MONTH, month);
            gc.set(Calendar.DAY_OF_MONTH, day);
            
            String weekdayName = getDayOfWeeksInVnmese(gc.get(Calendar.DAY_OF_WEEK));
            System.out.println(day + "/" + month + "/" + year + " là " + weekdayName);
            
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			ip.close();
		}
		
	}
	
	private static int readTime(String message) {
		System.out.print(message);
		String text = ip.nextLine();
		if(isNumber(text)) {
			return Integer.parseInt(text);
		} else {
			throw new IllegalArgumentException("Dữ liệu nhập vào phải là số");
		}
	}
	
	private static boolean isNumber(String text) {
		if(text == null || text.length() == 0) {
			return false;
		}
		
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if(c < '0' || c > '9') {
				return false;
			}
		}
		
		return true;
	}
	
	private static String getDayOfWeeksInVnmese(int dayOfWeek) {
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
		return  dayOfWeeks[dayOfWeek-1];
		
	}
	
	
}
