package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

public class Ex02 {
	public static void main(String[] args) throws Exception {	
		    TimeZone.setDefault(TimeZone.getTimeZone("GMT+7"));
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhập ngày (dd/MM/yyyy): ");
		String input = sc.nextLine();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(input));

		System.out.println("\n===== Result =====");
		System.out.println(DateUtils.formatDate(c) + " is a " + DateUtils.getWeekday(c));

		System.out.println("\nAdditional facts\n");

		System.out.println("It is day number " + DateUtils.getDayOfYear(c) + " of the year, "
				+ DateUtils.getDaysLeftInYear(c) + " days left.");

		System.out.println("Total days in month: " + DateUtils.getDaysInMonth(c));

		System.out.println("Year " + c.get(Calendar.YEAR) + " has " + DateUtils.getYearLength(c) + " days/n");

		System.out.println("It is " + DateUtils.getWeekday(c) + " number " + DateUtils.countWeekdayOrderInYear(c) + " out of " + DateUtils.countTotalWeekdayInYear(c) + " in the year.");

		System.out.println("It is " + DateUtils.getWeekday(c) + " number " + DateUtils.countWeekdayOrderInMonth(c)+ " out of " + DateUtils.countTotalWeekdayInMonth(c) + " in the month.");
System.out.println("asdsd");
		sc.close();
	}
}
