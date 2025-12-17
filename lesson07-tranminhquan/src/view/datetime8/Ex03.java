package view.datetime8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class Ex03 {

    static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static final String[] dow = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ Nhật" };

    public static void main(String[] args) {
        timenow();
        lastDayOfMonth();
        firstAndLastDayOfWeek();
        weekOfYear();
        after20Days();
        liveDay();
    }

    static void timenow() {
        LocalDateTime nowVN = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        System.out.println("1️. Thời gian hiện tại : " + dtf.format(nowVN));
    }

    static void lastDayOfMonth() {
        LocalDate today = LocalDate.now();
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("2️. Ngày cuối tháng: " + df.format(lastDay));
    }

    static void firstAndLastDayOfWeek() {
        LocalDate today = LocalDate.now();

        LocalDate firstDay = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate lastDay = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        System.out.println("3️. Đầu tuần là: " + df.format(firstDay) + " và cuối tuần là: " + df.format(lastDay));
    }
    
    static void weekOfYear() {
        LocalDate today = LocalDate.now();
        int week = today.get(WeekFields.of(Locale.getDefault()).weekOfYear());
        System.out.println("4️. Tuần hiện tại là tuần thứ: " + week);
    }

    static void after20Days() {
        LocalDate future = LocalDate.now().plusDays(20);
        DayOfWeek dayOfWeek = future.getDayOfWeek();

        System.out.println("5️. Sau 20 ngày là: "
                + df.format(future)
                + " (" + dow[dayOfWeek.getValue() - 1] + ")");
    }

    static void liveDay() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("6️. Nhập ngày sinh (dd/MM/yyyy): ");
            LocalDate birth = LocalDate.parse(sc.nextLine(), df);

            LocalDate today = LocalDate.now();
            long days = Duration.between(birth.atStartOfDay(), today.atStartOfDay()).toDays();

            System.out.println("Đã sống được: " + days + " ngày");
        } catch (Exception e) {
            System.out.println("Ngày sinh sai");
        }
    }
}
