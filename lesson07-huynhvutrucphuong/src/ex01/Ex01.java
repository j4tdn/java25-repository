package ex01;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dmt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Nhập thời gian bắt đầu hẹn hò ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(),dmt);
		
		System.out.println("Đã chia tay chưa (y/n)");
		String a = sc.nextLine();
		
		LocalDateTime end;
		
        if (a.equalsIgnoreCase("y")) {
            System.out.print("Nhập thời gian chia tay (dd/MM/yyyy HH:mm:ss): ");
            
            end = LocalDateTime.parse(sc.nextLine(), dmt);
        } else {
            end = LocalDateTime.now();
        }
        System.out.println("Ngày bắt đầu: " + start.getDayOfWeek());

        Period p = Period.between(start.toLocalDate(), end.toLocalDate());
        System.out.println("Thời gian yêu: "
                + p.getYears() + " năm, "
                + p.getMonths() + " tháng, "
                + p.getDays() + " ngày");

        System.out.println("Giờ: " + ChronoUnit.HOURS.between(start, end));
        System.out.println("Phút: " + ChronoUnit.MINUTES.between(start, end));
        System.out.println("Giây: " + ChronoUnit.SECONDS.between(start, end));
		
	}
}
