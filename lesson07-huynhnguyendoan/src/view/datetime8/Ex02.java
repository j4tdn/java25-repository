package view.datetime8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate date;

		while (true) {
			try {
				System.out.print("Nhập ngày (dd/MM/yyyy): ");
				date = LocalDate.parse(sc.nextLine(), inputFormat);
				break;
			} catch (DateTimeParseException e) {
				System.out.println("❌ Ngày không hợp lệ, nhập lại!");
			}
		}

		System.out.println("\n===== Result =====");
		System.out.println(DateUtils.format(date) + " is a " + DateUtils.getWeekday(date));

		System.out.println("\nAdditional facts");
		System.out.println("- It is day number " + DateUtils.getDayOfYear(date) + " of the year, "
				+ DateUtils.getDaysLeftInYear(date) + " days left.");

		System.out.println("- It is " + DateUtils.getWeekday(date) + " number " + DateUtils.weekdayOrderInYear(date)
				+ " out of " + DateUtils.totalWeekdayInYear(date) + " in " + date.getYear() + ".");

		System.out.println("- It is " + DateUtils.getWeekday(date) + " number " + DateUtils.weekdayOrderInMonth(date)
				+ " out of " + DateUtils.totalWeekdayInMonth(date) + " in " + date.getMonth() + ".");

		System.out.println("- Year " + date.getYear() + " has " + DateUtils.getYearLength(date) + " days.");

		System.out.println("- " + date.getMonth() + " has " + DateUtils.getMonthLength(date) + " days.");

		sc.close();
	}
}
