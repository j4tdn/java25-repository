package view.datetime8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex01 {

    static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    static final String[] dow = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ Nhật" };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ngày bắt đầu hẹn hò (dd/MM/yyyy HH:mm:ss): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), formatter);

        System.out.print("Đã chia tay chưa? (yes/no): ");
        String answer = sc.nextLine();
        LocalDateTime end;

        if (answer.equalsIgnoreCase("yes")) {
            System.out.print("Nhập ngày chia tay (dd/MM/yyyy HH:mm:ss): ");
            end = LocalDateTime.parse(sc.nextLine(), formatter);
        } else {
            end = LocalDateTime.now();
        }

        DayOfWeek dayOfWeek = start.getDayOfWeek();
        System.out.println("Ngày bắt đầu hẹn hò là: " + dow[dayOfWeek.getValue() - 1]);

        // ngày tháng năm
        Period period = Period.between(start.toLocalDate(), end.toLocalDate());

        // h,m,s
        Duration duration = Duration.between(start, end);

        long totalSeconds = duration.getSeconds();
        long hours = totalSeconds / 3600 % 24;
        long minutes = totalSeconds / 60 % 60;
        long seconds = totalSeconds % 60;

        System.out.println("\nThời gian yêu nhau:");
        System.out.println(period.getYears() + " năm");
        System.out.println(period.getMonths() + " tháng");
        System.out.println(period.getDays() + " ngày");
        System.out.println(hours + " giờ");
        System.out.println(minutes + " phút");
        System.out.println(seconds + " giây");
    }
}
