package datime8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;


public class Ex01 {
	public static void main(String[] args) {
		DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        System.out.println("Ngay hien tai: " + today.format(dateFmt));

        // Cau 2: Thang va nam hien tai co bao nhieu ngay 
        int daysInMonth = YearMonth.from(today).lengthOfMonth();
        int daysInYear = today.lengthOfYear();
        System.out.println("Thang hien tai co " + daysInMonth + " ngay");
        System.out.println("Nam hien tai co " + daysInYear + " ngay");

        // Cau 3: Kiem tra nam nhuan 
        System.out.println(today.isLeapYear()
                ? "Nam hien tai la nam nhuan"
                : "Nam hien tai khong phai nam nhuan");

        //  Cau 4: Ngay hien tai la thu may
        String[] thuVN = {
                "Thu hai", "Thu ba", "Thu tu",
                "Thu nam", "Thu sau", "Thu bay", "Chu nhat"
        };
        DayOfWeek dow = today.getDayOfWeek();
        System.out.println("Hom nay la: " + thuVN[dow.getValue() - 1]);

        //  Cau 5: In cac ngay trong tuan hien tai 
        System.out.println("\nCac ngay trong tuan hien tai:");
        LocalDate startWeek = today.with(
                TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        startWeek.datesUntil(startWeek.plusDays(7))
                .forEach(d ->
                        System.out.println(
                                d.format(dateFmt) + " " +
                                thuVN[d.getDayOfWeek().getValue() - 1]
                        )
                );

        // Cau 6: Dem so ngay Chu nhat trong thang
        YearMonth ym = YearMonth.now();
        long sundayCount = ym.atDay(1)
                .datesUntil(ym.atEndOfMonth().plusDays(1))
                .filter(d -> d.getDayOfWeek() == DayOfWeek.SUNDAY)
                .count();

        System.out.println("So ngay Chu nhat trong thang: " + sundayCount);

        //  Cau cuoi: Tinh thoi gian quen nhau
        LocalDateTime start = LocalDateTime.of(2020, 4, 20, 10, 20, 30);
        LocalDateTime now = LocalDateTime.now();

        long years = ChronoUnit.YEARS.between(start, now);
        start = start.plusYears(years);

        long months = ChronoUnit.MONTHS.between(start, now);
        start = start.plusMonths(months);

        long days = ChronoUnit.DAYS.between(start, now);
        start = start.plusDays(days);

        Duration d = Duration.between(start, now);

        long hours = d.toHours();
        long minutes = d.toMinutes() % 60;
        long seconds = d.getSeconds() % 60;

        System.out.println("\nThoi gian quen nhau:");
        System.out.println(
                years + " nam, " +
                months + " thang, " +
                days + " ngay, " +
                hours + " gio, " +
                minutes + " phut, " +
                seconds + " giay"
        );
    }
}
