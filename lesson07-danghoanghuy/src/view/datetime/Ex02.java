package view.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex02 {
	
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			System.out.println("Nhap ngay, thang, nam(dd/MM/yyyy): ");
			String dateStr = ip.nextLine();
			Date date = df.parse(dateStr);
			
			Calendar c = Calendar.getInstance();
			
			c.setTime(date);
			
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			System.out.println(dateStr + " la thu " + getDayOfWeeksInVnmese(dayOfWeek));
			
			int dayOfYear = c.get(Calendar.DAY_OF_YEAR);
			int totalDaysInYear = c.getActualMaximum(Calendar.DAY_OF_YEAR);
			int totalDaysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println("La ngay so " + dayOfYear + ", " + (totalDaysInYear - dayOfYear) + " ngay nua het nam");
			
			System.out.println("Nam " + c.get(Calendar.YEAR) + " co " + totalDaysInYear + " ngay");
			
			System.out.println("Thang " + (c.get(Calendar.MONTH) + 1) + " nam " + c.get(Calendar.YEAR) + " co " + totalDaysInMonth + " ngay");
			
		} catch (ParseException e) {
			System.out.println("Loi dinh dang");
			// 25/9/1995
		}
		
		ip.close();
		
	}
	
	private static String getDayOfWeeksInVnmese(int dayOfWeek) {
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
		return  dayOfWeeks[dayOfWeek-1];
	}
	
}
