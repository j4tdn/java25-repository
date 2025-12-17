package view.datetime8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class Ex03DateTime {

	static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void showCurrentTime() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Thời gian hiện tại: " + dateTimeFormat.format(now));
	}

	public static void showLastDayOfMonth() {
		LocalDate today = LocalDate.now();
		LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());

		System.out.println("Ngày cuối cùng của tháng: " + dateFormat.format(lastDay));
	}

	public static void showFirstAndLastDayOfWeek() {
		LocalDate today = LocalDate.now();

		LocalDate firstDay = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		LocalDate lastDay = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

		System.out.println("Ngày đầu tuần: " + dateFormat.format(firstDay));
		System.out.println("Ngày cuối tuần: " + dateFormat.format(lastDay));
	}

	public static void showWeekOfYear() {
		LocalDate today = LocalDate.now();
		int week = today.get(WeekFields.of(Locale.getDefault()).weekOfYear());

		System.out.println("Tuần hiện tại là tuần thứ: " + week);
	}

	public static void showDateAfter20Days() {
		LocalDate future = LocalDate.now().plusDays(20);

		String weekday = future.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, new Locale("vi", "VN"));

		System.out.println("Sau 20 ngày nữa là: " + dateFormat.format(future) + " (" + weekday + ")");
	}

	public static void calculateDaysLived() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
			String input = sc.nextLine();

			LocalDate birthDate = LocalDate.parse(input, dateFormat);

			long days = java.time.temporal.ChronoUnit.DAYS.between(birthDate, LocalDate.now());

			System.out.println("Bạn đã sống được: " + days + " ngày.");

		} catch (Exception e) {
			System.out.println("Ngày sinh không hợp lệ");
		}
	}

	public static void main(String[] args) {
		System.out.println("=== BÀI 3 - DATE TIME (JDK 1.8) ===");

		showCurrentTime();
		showLastDayOfMonth();
		showFirstAndLastDayOfWeek();
		showWeekOfYear();
		showDateAfter20Days();
		calculateDaysLived();
	}
}
