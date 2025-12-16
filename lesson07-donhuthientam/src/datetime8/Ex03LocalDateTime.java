package datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Scanner;

public class Ex03LocalDateTime {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {

		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("1. Xem thời gian hiện tại(dd/MM/yyy HH:mm:ss) ở khu vực bất kỳ: " + dtf1.format(ldt));
		
		System.out.println("\n===============================================\n");

		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate today = LocalDate.now();
		LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("2. In ngày cuối cùng của tháng hiện tại (dd/MM/yyyy): " + lastDay.format(dtf2));
		
		System.out.println("\n===============================================\n");

		LocalDate startDay = today.with(DayOfWeek.MONDAY);
		LocalDate endDay = today.with(DayOfWeek.SUNDAY);
		System.out.println("3. Xem ngày đầu tiên và cuối cùng của tuần hiện tại: " + startDay.format(dtf2));
		System.out.println("3. Xem ngày đầu tiên và cuối cùng của tuần hiện tại: " + endDay.format(dtf2));
		
		System.out.println("\n===============================================\n");

		int week = today.get(WeekFields.ISO.weekOfYear());
		System.out.println("4. Xem ngày hiện tại đang ở tuần thứ mấy trong năm: " + week);
		
		System.out.println("\n===============================================\n");

		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy EEEE");
		LocalDate after = LocalDate.now().plusDays(20);
		System.out.println("5. Kiểm tra sau 20 ngày nữa là ngày nào, thứ mấy: " + after.format(dtf3));
		
		System.out.println("\n===============================================\n");

		System.out.println("6. Nhập vào ngày tháng năm sinh. Kiểm tra xem bạn đã sống được bao nhiêu ngày: ");
		getBirthDay(ip);
	}

	private static void getBirthDay(Scanner ip) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate today = LocalDate.now();

		System.out.println("Nhập ngày sinh: ");
		LocalDate birthDay = LocalDate.parse(ip.nextLine(), dtf);

		long days = ChronoUnit.DAYS.between(birthDay, today);
		System.out.println("Bạn đã sống được: " + days + " day ");
	}

}
