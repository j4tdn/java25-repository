package datetime8;

import static utils.DateTimeUtils.getUnitValue;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ex01CalcDatingTime {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {

		getDate(ip);

	}

	private static void getDate(Scanner ip) {
		
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy H:m:s");

		    System.out.print("Nhập ngày bắt đầu hẹn hò (d/M/yyyy H:m:s): ");
		    LocalDateTime start = LocalDateTime.parse(ip.nextLine(), dtf);

		    System.out.print("Đã chia tay chưa? (y/n): ");
		    String choice = ip.nextLine();

		    LocalDateTime end;
		    if (choice.equalsIgnoreCase("y")) {
		        System.out.print("Nhập ngày chia tay (d/M/yyyy H:m:s): ");
		        end = LocalDateTime.parse(ip.nextLine(), dtf);
		    } else {
		        end = LocalDateTime.now();
		    }
		    
		    if (start.isAfter(end)) {
		    	System.out.println("ngày bắt đầu phải nhỏ hơn ngày kết thúc: ");
		    }
		    
		    Period period = Period.between(start.toLocalDate(), end.toLocalDate());
		    Duration duration = Duration.between(start.toLocalTime(), end.toLocalTime());
			
		    if (duration.isNegative()) {
				duration = duration.plusDays(1);
				period = period.minusDays(1);
			}
		    
			System.out.println("\nMối tình đã bắt đầu được: " 
					+ getUnitValue(period.getYears(), "year")
					+ getUnitValue(period.getMonths(), "month")
					+ getUnitValue(period.getDays(), "day")
					+ getUnitValue(duration.toHoursPart(), "hour")
					+ getUnitValue(duration.toMinutesPart(), "minute")
					+ getUnitValue(duration.toSecondsPart(), "second"));
		    
		} catch (DateTimeParseException e) {
			System.out.println("Lỗi nhập ngày!");
		}
		
		 

	    

	    

	    
	}

}
