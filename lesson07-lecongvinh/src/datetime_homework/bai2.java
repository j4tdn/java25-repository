package datetime_homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.YearMonth;
import java.util.Scanner;

public class bai2 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            System.out.print("Enter date (dd/MM/yyyy): ");
            LocalDate date = LocalDate.parse(sc.nextLine(), dtf);

            String[] days = {
                "Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"
            };

            System.out.println("========== Result ==========");
            System.out.println("Day: " + days[date.getDayOfWeek().getValue() % 7]);
            System.out.println("Date Of Year: " + date.getDayOfYear());
            System.out.println("Days Of Month: " + YearMonth.from(date).lengthOfMonth() + " days");
            System.out.println("Days Of year: " + date.lengthOfYear() + " days");

        } catch (Exception e) {
            System.out.println("Error: Wrong format, Please enter again dd/MM/yyyy.");
        }
        sc.close();
    }

}
