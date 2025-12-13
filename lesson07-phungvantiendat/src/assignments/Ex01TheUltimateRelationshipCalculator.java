package assignments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import bean.DurationParts;
import exception.InValidTimeException;
import utils.DateTimeUtils;

public class Ex01TheUltimateRelationshipCalculator {

	private static final String PATTERN = "dd/MM/yyyy HH:mm:ss";
	private static final SimpleDateFormat SDF = new SimpleDateFormat(PATTERN);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== The Ultimate Relationship Calculator ===");

		System.out.println();

		Date startDate = readDateTimeRequired(sc, "Nhập thời gian bắt đầu hẹn hò (" + PATTERN + "): ");

		boolean isBrokenUp = readYesNoRequired(sc, "Đã chia tay chưa? (Y/N): ");

		Date endDate;
		if (isBrokenUp) {
			endDate = readDateTimeRequired(sc, "Nhập ngày chia tay (" + PATTERN + "): ");
		} else {
			endDate = new Date();
		}

		Calendar start = DateTimeUtils.clone(startDate);

		Calendar end = DateTimeUtils.clone(endDate);

		if (start.after(end)) {
			System.out.println();
			System.out.println(" Ngày bắt đầu hẹn hò phải <= ngày kết thúc.");
			sc.close();
			return;
		}

		System.out.println();
		System.out.println("Ngày bắt đầu hẹn hò là: " + DateTimeUtils.getVietnameseDayOfWeek(start));
		System.out.println("Bắt đầu: " + SDF.format(start.getTime()));
		System.out.println("Kết thúc: " + SDF.format(end.getTime()));
		System.out.println();

		DurationParts d = DateTimeUtils.diffCalendarParts(start, end);

		System.out.println("Mối tình đã bắt đầu được:");
		System.out.println("- " + d.getYears() + " năm, " + d.getMonths() + " tháng, " + d.getDays() + " ngày");
		System.out.println("- " + d.getHours() + " giờ, " + d.getMinutes() + " phút, " + d.getSeconds() + " giây");

		sc.close();

	}

	private static boolean readYesNoRequired(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String line = sc.nextLine().trim().toUpperCase();

			if ("Y".equals(line) || "YES".equals(line)) {
				return true;
			}
			if ("N".equals(line) || "NO".equals(line)) {
				return false;
			}

			System.out.println("️Chỉ nhập Y hoặc N.");
		}
	}

	private static Date readDateTimeRequired(Scanner sc, String prompt) {
		do {
			System.out.print(prompt);
			String line = sc.nextLine().trim();

			try {
				return SDF.parse(line);
			} catch (ParseException | NullPointerException ex) {
				if (ex instanceof NullPointerException) {
					System.out.println("Giá trị không được để trống");
				} else {
					System.out.println("Sai định dạng. Ví dụ đúng: 05/12/2025 21:30:00");
				}
			}

		} while (true);
	}
}
