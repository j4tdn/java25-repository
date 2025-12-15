package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Bai3 {
	
	static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE");
	
	public static void showTimeNow() {
		System.out.println("Thời gian hiện tại: " + sdf1.format(new Date()));
	}
	
	public static void EndDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("Ngày cuối tháng: " + sdf2.format(cal.getTime()));
	}
	
	public static void startAndEndOfWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println("Đầu tuần là: "  + sdf2.format(cal.getTime()));
		
		cal.add(Calendar.DAY_OF_WEEK, 6);
		System.out.println("Cuối tuần: " + sdf2.format(cal.getTime()));
	}
	
	public static void WoY() {
		Calendar cal = Calendar.getInstance();
		System.out.println("Tuần thứ: " + cal.get(Calendar.WEEK_OF_YEAR) + " trong năm");
	}
	
	public static void daytwenty() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 20);
		System.out.println("Sau 20 là ngày: " + sdf2.format(cal.getTime()) + " ,Thứ: " + sdf3.format(cal.getTime()));
	}
	
	public static void live() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập ngày sinh: ");
		Date s = sdf2.parse(sc.nextLine());
		
		Date now = new Date();
		long d = now.getTime() - s.getTime();
		long day = d/(1000*60*60*24);
		
		System.out.println("bạn đã sống được : " +  day + " ngày");
	}
	
	public static void main(String[] args) throws Exception {
		showTimeNow();
		EndDayOfMonth();
		startAndEndOfWeek();
		WoY();
		daytwenty();
		live();
	}

}
