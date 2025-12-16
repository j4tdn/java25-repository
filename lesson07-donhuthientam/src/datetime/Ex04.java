package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex04 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date startDate = sdf.parse("07/06/2022");

		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);

		int workingDays = 0;

		while (workingDays < 110) {
			cal.add(Calendar.DATE, 1);

			if (isWorkingDay(cal, sdf)) {
				workingDays++;
			}
		}

		System.out.println("Ngày bàn giao sản phẩm: " + sdf.format(cal.getTime()));
	}

	private static boolean isWorkingDay(Calendar cal, SimpleDateFormat sdf) {
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
			return false;
		}

		String currentDate = sdf.format(cal.getTime());
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
