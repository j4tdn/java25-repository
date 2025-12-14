package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Ex04 {

	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		LocalDate startDate = LocalDate.of(2022, 6, 7);
		int requiredWorkDays = 110;

		Set<LocalDate> holidays = new HashSet<>();
		holidays.add(LocalDate.of(2022, 9, 1));
		holidays.add(LocalDate.of(2022, 9, 2));

		boolean includeStartDayAsDay1 = true; //

		LocalDate deadline = calculateDeadline(startDate, requiredWorkDays, holidays, includeStartDayAsDay1);

		System.out.println("Start date: " + startDate.format(DTF) + " (" + startDate.getDayOfWeek() + ")");
		System.out.println("Workdays required: " + requiredWorkDays);
		System.out.println("Deadline: " + deadline.format(DTF) + " (" + deadline.getDayOfWeek() + ")");
	}

	public static LocalDate calculateDeadline(LocalDate start, int workDays, Set<LocalDate> holidays,
			boolean includeStartAsDay1) {
		LocalDate d = start;
		int count = 0;

		if (!includeStartAsDay1) {
			d = d.plusDays(1);
		}

		while (true) {
			if (isWorkingDay(d, holidays)) {
				count++;
				if (count == workDays) {
					return d;
				}
			}
			d = d.plusDays(1);
		}
	}

	public static boolean isWorkingDay(LocalDate date, Set<LocalDate> holidays) {
		DayOfWeek dow = date.getDayOfWeek();
		boolean isWeekend = (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY);
		return !isWeekend && !holidays.contains(date);
	}
}
