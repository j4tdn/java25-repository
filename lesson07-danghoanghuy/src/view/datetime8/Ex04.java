package view.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class Ex04 {

	public static void main(String[] args) {
		
		LocalDate startDay = LocalDate.of(2022, 6, 7);
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern(("dd/MM/yyyy"));
		
		int workDay = 110;
		
		MonthDay[] holidays = {
				MonthDay.of(Month.JANUARY, 1),
	            MonthDay.of(Month.APRIL, 30),
	            MonthDay.of(Month.MAY, 1),
	            MonthDay.of(Month.SEPTEMBER, 2)
		};
		
		int count = 0;
		LocalDate current = startDay; 
		
		while(count < workDay) {
			
			current = current.plusDays(1);
			
			if(isWorkingDay(current, holidays)) {
				
				count++;
				
			}
			
		}
		
		System.out.println("Ngay ban giao: " + current.format(df));
	}
	
	private static boolean isWorkingDay(LocalDate current, MonthDay[] holidays) {
		
		DayOfWeek dayOfCurrent = current.getDayOfWeek();
		
		if(dayOfCurrent == DayOfWeek.SATURDAY || dayOfCurrent == DayOfWeek.SUNDAY) {
			return false;
		}
		
		 MonthDay currentMonthDay = MonthDay.from(current);
		
		for(MonthDay holiday: holidays) {
			if(currentMonthDay.equals(holiday)) {
				return false;
			}
		}
		
		return true;
	}
	
}
