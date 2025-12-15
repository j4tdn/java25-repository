package localdatetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import static utils.DateTimeUtils.*;

public class Ex03LocalDateTime {
    public static void main(String[] args) {
        LocalDateTime datetime1 = LocalDateTime.of(2020, 4, 20, 10, 20, 30);
        LocalDateTime datetime2 = LocalDateTime.now();

        System.out.println("datetime1: " + datetime1);
        System.out.println("datetime2: " + datetime2);
        
      //Yêu cầu :Tìm hiệu giữ 2 mốc tgian trên 
        //? ngày ? Tháng ? năm ? giờ ? Phút ? giây 
        //LocalDate : period 
        //LocalTime : Duration 
        //LocalDateTome: x

        System.out.println("\n================ DateTime Query =================\n");

        // --- Phần ngày, tháng, năm ---
        LocalDate date1 = datetime1.toLocalDate();
        LocalDate date2 = datetime2.toLocalDate();
        Period period = Period.between(date1, date2);

        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());

        System.out.println("\n================ DateTime Deviation =================\n");

        if (datetime1.isAfter(datetime2)) {
            throw new IllegalArgumentException("datetime1 must be less than datetime2...");
        }

        // Tính period (năm, tháng, ngày)
        Period diffPeriod = Period.between(datetime1.toLocalDate(), datetime2.toLocalDate());

        // Tính duration (giờ, phút, giây)
        Duration diffDuration = Duration.between(datetime1.toLocalTime(), datetime2.toLocalTime());

        if (diffDuration.isNegative()) {
            diffDuration = diffDuration.plusDays(1);
            diffPeriod = diffPeriod.minusDays(1);
        }

        System.out.println(diffPeriod + " " + diffDuration);

        System.out.println("deviation: "
                + getUnitValue(diffPeriod.getYears(), "year")
                + getUnitValue(diffPeriod.getMonths(), "month")
                + getUnitValue(diffPeriod.getDays(), "day")
                + getUnitValue(diffDuration.toHoursPart(), "hour")
                + getUnitValue(diffDuration.toMinutesPart(), "minute")
                + getUnitValue(diffDuration.toSecondsPart(), "second")
        );
    }
}
