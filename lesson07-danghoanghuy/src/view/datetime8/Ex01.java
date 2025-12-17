package view.datetime8;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static utils.DateTimeUtils.getUnitValue;

public class Ex01 {
	
	// 23/01/2005 12:23:21

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		
		try {
			
			System.out.println("Nhap ngay bat dau(dd/MM/yyyy HH:mm:ss): ");
			String startDayStr = ip.nextLine();
			LocalDateTime startDay = LocalDateTime.parse(startDayStr, dtf);
			
			System.out.println("Da chia tay chua y/n");
			String isBrokenup = ip.nextLine();
			
			if(isBrokenup.equalsIgnoreCase("y")) {
				
				System.out.println("Nhap ngay chia tay: ");
				String endDayStr = ip.nextLine();
				LocalDateTime endDay = LocalDateTime.parse(endDayStr, dtf);
				
				Period period = Period.between(startDay.toLocalDate(), endDay.toLocalDate());
				Duration duration = Duration.between(startDay.toLocalTime(), endDay.toLocalTime());
				
				if (duration.isNegative()) {
					duration = duration.plusDays(1);
					period = period.minusDays(1);
				}
				
				System.out.println("Moi tinh keo dai: " 
		        		+ getUnitValue(period.getYears(), "nam")
		        		+ getUnitValue(period.getMonths(), "thang")
		        		+ getUnitValue(period.getDays(), "ngay")
		        		+ getUnitValue(duration.toHoursPart(), "gio")
		        		+ getUnitValue(duration.toMinutesPart(), "phut")
		        		+ getUnitValue(duration.toSecondsPart(), "giay"));
				
				ip.close();
				
			}
			else {
				System.out.println("Thoi gian hien tai: " + dtf.format(date));
			}
			
		} catch (DateTimeException e) {
			System.out.println("Loi dinh dang");
		}
	}
	
}
