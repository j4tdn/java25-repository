package view.datetime8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class Ex02Weekday {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Nhập ngày: ");
			int day = sc.nextInt();

			System.out.print("Nhập tháng: ");
			int month = sc.nextInt();

			System.out.print("Nhập năm: ");
			int year = sc.nextInt();

			LocalDate date = LocalDate.of(year, month, day);

			String weekday = date.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, Locale.ENGLISH);

			int dayOfYear = date.getDayOfYear();

			int daysInYear = date.lengthOfYear();

			int daysLeft = daysInYear - dayOfYear;

			WeekFields weekFields = WeekFields.of(Locale.getDefault());
			int weekOfYear = date.get(weekFields.weekOfYear());

			int daysInMonth = date.lengthOfMonth();

			System.out.println("\n========== RESULT ==========");
			System.out.println(day + "/" + month + "/" + year + " is a " + weekday);
			System.out.println("It is day number " + dayOfYear + " of the year, " + daysLeft + " days left");
			System.out.println("It is week number " + weekOfYear + " of the year");
			System.out.println("Month " + month + " has " + daysInMonth + " days");
			System.out.println("Year " + year + " has " + daysInYear + " days");

		} catch (Exception e) {
			System.out.println("Ngày tháng năm không hợp lệ");
		}
	}
}
