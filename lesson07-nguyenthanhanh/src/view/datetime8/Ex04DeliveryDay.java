package view.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ex04DeliveryDay {
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	private static String[] holidays = {"2025/09/02", "2025/25/12"};

	public static void main(String[] args) {
		Locale.setDefault(new Locale("vi", "VN"));
		int totalWorkDays = 110;
		LocalDate start = LocalDate.of(2022, 6, 7);
		LocalDate deliveryDay = addDay(start, totalWorkDays);
		System.out.println("Ngày giao sản phẩm là --> " + dtf.format(deliveryDay));
	}
	
	public static LocalDate addDay(LocalDate start, int totalWorkDays) {
		LocalDate date = start;
		int addedDays = 0;
		while(true) {
			if(isWorkingDay(start)) {
				addedDays++;
				if(addedDays == totalWorkDays) {
					return date;
				}
			}
			date = date.plusDays(1);
		}
	}
	
	private static boolean isWorkingDay(LocalDate date) {
		DayOfWeek dow = date.getDayOfWeek();
		if(dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY) {
			return false;
		}
		String strDate = dtf.format(date);
		for(String holiday : holidays) {
			if(holiday.equals(strDate)) {
				return false;
			}
		}
		return true;
	}
	
}
