package datetime8;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Ex02 {
	public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2020, 4, 20, 10, 20, 30);
        LocalDateTime now = LocalDateTime.now();

        // Tính năm - tháng - ngày
        Period period = Period.between(start.toLocalDate(), now.toLocalDate());

        // Tính giờ - phút - giây còn lại
        LocalDateTime temp = start
                .plusYears(period.getYears())
                .plusMonths(period.getMonths())
                .plusDays(period.getDays());

        Duration duration = Duration.between(temp, now);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.println("A và B đã quen nhau được:");
        System.out.println(period.getYears() + " năm - "
                + period.getMonths() + " tháng - "
                + period.getDays() + " ngày - "
                + hours + " giờ - "
                + minutes + " phút - "
                + seconds + " giây");
    }
}
