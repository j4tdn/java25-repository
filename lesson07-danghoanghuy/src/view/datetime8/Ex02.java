package view.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		// 25/09/1995
		
	Scanner ip = new Scanner(System.in);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			
			System.out.println("Nhap ngay(dd/MM/yyyy): ");
			String dateStr = ip.nextLine();
			LocalDate date = LocalDate.parse(dateStr, dtf);
			
			System.out.println("\n" + dateStr + " is a " + date.getDayOfWeek() + "\n");
			
			System.out.println("\nIt is day number " + date.getDayOfYear() + " of the year, " + (date.lengthOfYear() - date.getDayOfYear()) +" days left\n");
			
			countDayInYear(date.getYear(), date.getDayOfWeek(), date.getDayOfYear(), date.lengthOfYear());
			
			countDayInMonth(date.getYear(), date.getMonth() , date.getDayOfWeek(), date.getDayOfMonth(), date.lengthOfMonth());
			
			System.out.println("\nYear " + date.getYear() + " has " + date.lengthOfYear() + " days\n");
			
			System.out.println("\n" + date.getMonth() + " " + date.getYear() + " has " + date.lengthOfMonth() + " days\n");
			
			ip.close();
			
		} catch (DateTimeParseException e) {
			System.out.println("Loi dinh dang");
		}
		
	}
	
	private static void countDayInMonth(int year, Month month, DayOfWeek targetDay, int currentDayOfMonth, int lengthOfMonth) {
		
		int countDayExist = 0;
		int countDayInYear = 0;
		LocalDate startDay = LocalDate.of(year, month, 1);
		
		for(int i = 0; i < lengthOfMonth; i++) {
			LocalDate date = startDay.plusDays(i);
			
			if(date.getDayOfWeek() == targetDay) {
				countDayExist++;
				
				if(date.getDayOfMonth() <= currentDayOfMonth) {
					countDayInYear++;
				}
			}
			
		}
		
		System.out.println("\nIt is " + targetDay + " number " + countDayInYear + " out of " + countDayExist + " in " + month + " " + year + "\n");
		
	}

	private static void countDayInYear(int year, DayOfWeek targetDay, int currentDayOfYear, int lengthOfYear) {
		
		int countDayExist = 0;
		int countDayInYear = 0;
		LocalDate startDay = LocalDate.of(year, 1, 1);
		
		for(int i = 0; i < lengthOfYear; i++) {
			LocalDate date = startDay.plusDays(i);
			
			if(date.getDayOfWeek() == targetDay) {
				countDayExist++;
				
				if(date.getDayOfYear() <= currentDayOfYear) {
					countDayInYear++;
				}
			}
			
		}
		
		System.out.println("\nIt is " + targetDay + " number " + countDayInYear + " out of " + countDayExist + " in " + year + "\n");
		
	}
	
}
