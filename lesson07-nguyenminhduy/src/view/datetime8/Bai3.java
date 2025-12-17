package view.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class Bai3 {
	
	static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	static DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void timeNow(){
		System.out.println("Thời gian hiện tại: " + LocalDateTime.now().format(dtf1));
	}
	
	public static void dayEndOfMonth() {
		LocalDate now = LocalDate.now();
		System.out.println("Ngày cuối tháng: " + now.withDayOfMonth(now.lengthOfMonth()).format(dtf2));
	}
	
	public static void SAEOW() {
		LocalDate now = LocalDate.now();
		LocalDate start = now.with(DayOfWeek.MONDAY);
		LocalDate end = start.plusDays(6);
		
		 System.out.println("Đầu tuần: " + start.format(dtf2));
	     System.out.println("Cuối tuần: " + end.format(dtf2));
	}
	
	public static void week() {
		LocalDate now = LocalDate.now();
		int week = now.get(WeekFields.of(Locale.getDefault()).weekOfYear());
		System.out.println("Tuần thứ: " + week);
	}
	
	public static void twentyDay() {
		LocalDate d = LocalDate.now().plusDays(20);
		System.out.println("Sau 20 ngày là: " + d.format(dtf2) + " (" + d.getDayOfWeek() + ")");
	}
	
	public static void dayLive() {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Nhập ngày sinh của bạn: ");
		LocalDate n = LocalDate.parse(sc.nextLine().trim(),dtf);
		
		long day = ChronoUnit.DAYS.between(n, LocalDate.now());
		
		System.out.println("Bạn đã sống được: " + day + " ngày");
	}
	public static void main(String[] args) {
		timeNow();
		dayEndOfMonth();
		SAEOW();
		week();
		twentyDay();
		dayLive();
	}

}
