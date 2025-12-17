
package datetime8;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ex01 {
	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("=== The Ultimate Relationship Calculator ===");
		System.out.println("Format thời gian: dd/MM/yyyy HH:mm:ss (VD: 14/12/2025 09:00:00)");
		System.out.println();

		LocalDateTime start = readDateTime(sc, "Nhập thời gian bắt đầu hẹn hò: ");

		boolean brokeUp = readYesNo(sc, "Đã chia tay chưa? (y/n): ");

		LocalDateTime end;
		if (brokeUp) {
			while (true) {
				end = readDateTime(sc, "Nhập thời gian chia tay (dd/MM/yyyy HH:mm:ss): ");
				if (!end.isBefore(start))
					break;
				System.out.println("�? Thời gian chia tay không được trước thời gian bắt đầu. Nhập lại!");
			}
		} else {
			end = LocalDateTime.now();
		}

		System.out.println();
		System.out.print("Nhấn Enter đ�? thực hiện tính toán...");
		sc.nextLine();

		System.out.println();
		System.out.println("----- KẾT QUẢ / RESULT -----");

		DayOfWeek dow = start.getDayOfWeek();
		System.out.println("Ng�?y bắt đầu (VN): " + toVietnameseDayOfWeek(dow));
		System.out.println("Start day (EN): " + dow);

		Period p = Period.between(start.toLocalDate(), end.toLocalDate());
		System.out.println("Mối tình đã bắt đầu được: " + p.getYears() + " năm, " + p.getMonths() + " tháng, "
				+ p.getDays() + " ng�?y");

		long hours = ChronoUnit.HOURS.between(start, end);
		long minutes = ChronoUnit.MINUTES.between(start, end);
		long seconds = ChronoUnit.SECONDS.between(start, end);

		System.out.println("Gi�? (total hours): " + hours);
		System.out.println("Phút (total minutes): " + minutes);
		System.out.println("Giây (total seconds): " + seconds);

		System.out.println("----------------------------");

		sc.close();
	}

	private static LocalDateTime readDateTime(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = sc.nextLine().trim();
			try {
				return LocalDateTime.parse(input, DTF);
			} catch (DateTimeParseException e) {
				System.out.println("�? Sai format. Hãy nhập theo dd/MM/yyyy HH:mm:ss (VD: 14/12/2025 09:00:00)");
			}
		}
	}

	private static boolean readYesNo(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String ans = sc.nextLine().trim();
			if (ans.equalsIgnoreCase("y"))
				return true;
			if (ans.equalsIgnoreCase("n"))
				return false;
			System.out.println("�? Ch�? nhập 'y' hoặc 'n'.");
		}
	}

	private static String toVietnameseDayOfWeek(DayOfWeek dow) {
		return switch (dow) {
		case MONDAY -> "Thứ Hai";
		case TUESDAY -> "Thứ Ba";
		case WEDNESDAY -> "Thứ Tư";
		case THURSDAY -> "Thứ Năm";
		case FRIDAY -> "Thứ Sáu";
		case SATURDAY -> "Thứ Bảy";
		case SUNDAY -> "Chủ Nhật";
		};
	}
}
