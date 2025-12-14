package localdatetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex01Localdate {

	// Date, Calendar
	// SimpleDateFormat
	// new Date             --> initial with normal way
	// Calendar.getInstance --> factory pattern
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.of(2025, 11, 18);
		LocalDate date3 = LocalDate.ofYearDay(2025, 120);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date4 = LocalDate.parse("13/12/2025", dtf ); // chỉ hỗ trợ dd/MM//yyyy, còn lại bị lỗi
		
		System.out.printf("date1: %s\n\n", date1);
		System.out.printf("date2: %s\n\n", dtf.format(date2));
		System.out.printf("date3: %s\n\n", date3);
		System.out.printf("date4: %s\n\n", date4);
	}
}
