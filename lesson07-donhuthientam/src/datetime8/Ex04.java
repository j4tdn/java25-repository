package datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex04 {
	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate startDate = LocalDate.parse("07/06/2022", dtf);

		int workingDays = 0;
        LocalDate Date = startDate;

		while (workingDays < 110) {
			Date = startDate.plusDays(1);

			if (isWorkingDay(Date)) {
				workingDays++;
			}
		}
		System.out.println("Ngày bàn giao sản phẩm là: " + Date.format(dtf));

	}

	private static boolean isWorkingDay(LocalDate date) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		DayOfWeek dayOfWeek = date.getDayOfWeek();
		if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
			return false;
		}

		String currentDate = date.format(dtf);
		for (String holiday : holidays) {
			if (holiday.equals(currentDate)) {
				return false;
			}
		}
		return true;

	}

	private static String[] holidays = { "01/01/2022", "31/01/2022", "01/02/2022", "02/02/2022", "03/02/2022",
			"04/02/2022", "10/04/2022", "30/04/2022", "01/05/2022", "02/09/2022" };

}
