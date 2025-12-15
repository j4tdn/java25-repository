package view.datetime8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Ex01UltimateRelationshipCalculator {
	
	private static Scanner ip = new Scanner(System.in);
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {
		try {
			Locale.setDefault(new Locale("vi", "VN"));
			
			System.out.println("=== The Ultimate Relationship Calculator ===");
			LocalDateTime start = readDateTime("Nhập thời gian bắt đầu hẹn hò (dd/MM/yyyy HH:mm:ss): ");
			LocalDateTime end = readDateTime("Nhập thời gian chia tay (dd/MM/yyyy HH:mm:ss): ");
			
			if(end.isBefore(start)) {
				throw new IllegalArgumentException("Thời điểm chia tay phải sau ngày hẹn hò");
			}
			
			LocalDateTime cursor = start;
			int years = 0, months = 0, days = 0, hours = 0, minutes = 0, seconds = 0;
			
			while(true) {
				if(cursor.plusYears(1).isAfter(end)) {
					break;
				}
				years++;
				cursor = cursor.plusYears(1);
			}
			
			while(true) {
				if(cursor.plusMonths(1).isAfter(end)) {
					break;
				}
				months++;
				cursor = cursor.plusMonths(1);
			}
			
			while(true) {
				if(cursor.plusDays(1).isAfter(end)) {
					break;
				}
				days++;
				cursor = cursor.plusDays(1);
			}
			
			while(true) {
				if(cursor.plusHours(1).isAfter(end)) {
					break;
				}
				hours++;
				cursor = cursor.plusHours(1);
			}
			
			while(true) {
				if(cursor.plusMinutes(1).isAfter(end)) {
					break;
				}
				minutes++;
				cursor = cursor.plusMinutes(1);
			}
			
			while(true) {
				if(cursor.plusSeconds(1).isAfter(end)) {
					break;
				}
				seconds++;
				cursor = cursor.plusSeconds(1);
			}
			
			
			
			System.out.println("\nKết quả:");
	        System.out.println("- Ngày bắt đầu hẹn hò: " + dtf.format(start));
	        System.out.println("- Nếu đã chia tay/ngày kết thúc: " + dtf.format(end));
	        System.out.println("- Thời gian mối tình: "
	                + years + " năm, "
	                + months + " tháng, "
	                + days + " ngày, "
	                + hours + " giờ, "
	                + minutes + " phút, "
	                + seconds + " giây");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ip.close();
		}
	}
	
	private static LocalDateTime readDateTime(String message) {
		System.out.print(message);
		String text = ip.nextLine();
		try {
			return LocalDateTime.parse(text, dtf);
		} catch (DateTimeParseException ex) {
			throw new IllegalArgumentException("Dữ liệu không đúng định dạng");
		}
		
	}
	
}
