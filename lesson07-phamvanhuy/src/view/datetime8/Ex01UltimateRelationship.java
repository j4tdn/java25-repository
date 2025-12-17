package view.datetime8;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex01UltimateRelationship {

	public static void main(String[] args) {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Nhập thời gian bắt đầu hẹn hò (dd/MM/yyyy HH:mm:ss): ");
			String startInput = sc.nextLine();
			LocalDateTime startDate = LocalDateTime.parse(startInput, format);

			System.out.print("Hai bạn đã chia tay chưa (y/n): ");
			String answer = sc.nextLine();

			LocalDateTime endDate;
			if (answer.equalsIgnoreCase("y")) {
				System.out.print("Nhập thời gian chia tay (dd/MM/yyyy HH:mm:ss): ");
				String endInput = sc.nextLine();
				endDate = LocalDateTime.parse(endInput, format);
			} else {
				endDate = LocalDateTime.now();
			}

			System.out.println("Ngày bắt đầu hẹn hò là: " + startDate.getDayOfWeek());

			Duration duration = Duration.between(startDate, endDate);

			long totalSeconds = duration.getSeconds();

			long seconds = totalSeconds % 60;
			long minutes = (totalSeconds / 60) % 60;
			long hours = (totalSeconds / 3600) % 24;
			long days = totalSeconds / (24 * 3600);

			long months = days / 30;
			long years = months / 12;

			months = months % 12;
			days = days % 30;

			System.out.println("Hai bạn đã yêu được:");
			System.out.println(years + " năm, " + months + " tháng, " + days + " ngày, " + hours + " giờ, " + minutes
					+ " phút, " + seconds + " giây.");

		} catch (Exception e) {
			System.out.println("Sai định dạng! Nhập đúng: dd/MM/yyyy HH:mm:ss");
		}
	}
}
