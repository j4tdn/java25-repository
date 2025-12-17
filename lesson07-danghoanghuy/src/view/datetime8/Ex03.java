package view.datetime8;

import static utils.DateTimeUtils.getUnitValue;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		DateTimeFormatter fDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		DateTimeFormatter fDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.now();
		Calendar cal = Calendar.getInstance();
		
		LocalDateTime berlinTime = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
		System.out.println("Hien gio o Duc la: " + fDateTime.format(berlinTime));
		
		LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("\nNgay cuoi cung thang hien tai la: " + fDate.format(lastDayOfMonth));
		
		// First Day Of Week rule --> Sunday/Monday
        DayOfWeek firstDayOfWeekRule = WeekFields.of(Locale.GERMANY).getFirstDayOfWeek();
        LocalDate firstDayOfWeek = date.with(TemporalAdjusters.previousOrSame(firstDayOfWeekRule));
        System.out.println("\nNgay dau cua tuan: " + fDate.format(firstDayOfWeek));
		
        LocalDate lastDayOfWeek = firstDayOfWeek.plusDays(6);
        System.out.println("\nNgay cuoi cua tuan: " + fDate.format(lastDayOfWeek));
        
        System.out.println("\nTuan hien tai: " + cal.get(Calendar.WEEK_OF_YEAR));
        
        LocalDate futureDay = date.plusDays(20);
        System.out.println("\n20 ngay sau la: " + fDate.format(futureDay));
        
        System.out.println("\nNhap ngay sinh(dd/MM/yyyy): ");

        try {
			
        	String birthDayStr = ip.nextLine();
        	LocalDate birthDay = LocalDate.parse(birthDayStr, fDate);
        	
        	Period period = Period.between(birthDay, date);
        	System.out.println("Song duoc: " 
	        		+ getUnitValue(period.getYears(), "nam")
	        		+ getUnitValue(period.getMonths(), "thang")
	        		+ getUnitValue(period.getDays(), "ngay")
	        		);
        	
		} catch (DateTimeException e) {
			System.out.println("Loi dinh dang");
		}
        
        ip.close();
	}
	
}
