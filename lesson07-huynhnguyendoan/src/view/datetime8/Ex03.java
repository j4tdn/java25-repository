package view.datetime8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Ex03 {

	static DateTimeFormatter fdf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	static DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void showCurrentTime(String zoneId) {
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of(zoneId));
		System.out.println("Current time (" + zoneId + "): " + now.format(fdf));
	}

	public static void showLastDayOfCurrentMonth() {
		LocalDate today = LocalDate.now();
		LocalDate lastDay = today.withDayOfMonth(today.lengthOfMonth());
		System.out.println("Last day of current month: " + lastDay.format(sdf));
	}

	public static void showFirstAndLastDayOfWeek() {
		LocalDate today = LocalDate.now();
		WeekFields weekFields = WeekFields.of(Locale.getDefault());

		LocalDate firstDay = today.with(weekFields.dayOfWeek(), 1);
		LocalDate lastDay = today.with(weekFields.dayOfWeek(), 7);

		System.out.println("First day of week: " + firstDay.format(sdf));
		System.out.println("Last day of week : " + lastDay.format(sdf));
	}

	public static void showWeekOfYear() {
		LocalDate today = LocalDate.now();
		int week = today.get(WeekFields.of(Locale.getDefault()).weekOfYear());
		System.out.println("Current week of year: " + week);
	}

	public static void showDateAfter20Days() {
		LocalDate future = LocalDate.now().plusDays(20);
		System.out.println("After 20 days: " + future.format(sdf) + " (" + future.getDayOfWeek() + ")");
	}

	public static void calculateDaysLived(String birthday) {
		LocalDate birthDate = LocalDate.parse(birthday, sdf);
		LocalDate today = LocalDate.now();

		long days = ChronoUnit.DAYS.between(birthDate, today);
		System.out.println("You have lived: " + days + " days");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		showCurrentTime("Asia/Ho_Chi_Minh");
		showLastDayOfCurrentMonth();
		showFirstAndLastDayOfWeek();
		showWeekOfYear();
		showDateAfter20Days();

		System.out.print("\nEnter your birthday (dd/MM/yyyy): ");
		String birthday = sc.nextLine();
		calculateDaysLived(birthday);

		sc.close();
	}
}
