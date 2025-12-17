package view.datetime8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        LocalDateTime start;
        LocalDateTime end;

        while (true) {
            try {
                System.out.print("Ngày bắt đầu hẹn hò (dd/MM/yyyy HH:mm:ss): ");
                start = LocalDateTime.parse(sc.nextLine(), formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("❌ Sai định dạng, nhập lại!");
            }
        }

        System.out.print("Bạn đã chia tay chưa? (y/n): ");
        String answer = sc.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            while (true) {
                try {
                    System.out.print("Nhập thời gian chia tay (dd/MM/yyyy HH:mm:ss): ");
                    end = LocalDateTime.parse(sc.nextLine(), formatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("❌ Sai định dạng, nhập lại!");
                }
            }
        } else {
            end = LocalDateTime.now();
        }


        System.out.println("Ngày bắt đầu hẹn hò: "
                + DateUtils.format(start)
                + " (" + DateUtils.getWeekday(start) + ")");

        Period period = DateUtils.getPeriod(start.toLocalDate(), end.toLocalDate());

        Duration duration = DateUtils.getDuration(start, end);

        long totalSeconds = duration.getSeconds();
        long hours = (totalSeconds % (24 * 3600)) / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        System.out.println("\nThời gian yêu nhau:");
        System.out.println("- " + period.getYears() + " năm");
        System.out.println("- " + period.getMonths() + " tháng");
        System.out.println("- " + period.getDays() + " ngày");
        System.out.println("- " + hours + " giờ");
        System.out.println("- " + minutes + " phút");
        System.out.println("- " + seconds + " giây");

        sc.close();
    }
}

