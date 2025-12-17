package view.datetime8;

import java.time.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter sdf =
            DateTimeFormatter.ofPattern("dd MMMM yyyy");

    public static String format(LocalDate date) {
        return date.format(sdf);
    }

    public static String getWeekday(LocalDate date) {
        return date.getDayOfWeek().toString()
                .substring(0,1)
                + date.getDayOfWeek().toString().substring(1).toLowerCase();
    }

    public static int getDayOfYear(LocalDate date) {
        return date.getDayOfYear();
    }

    public static int getDaysLeftInYear(LocalDate date) {
        return date.lengthOfYear() - date.getDayOfYear();
    }

    public static int getYearLength(LocalDate date) {
        return date.lengthOfYear();
    }

    public static int getMonthLength(LocalDate date) {
        return date.lengthOfMonth();
    }

    public static int weekdayOrderInYear(LocalDate date) {
        DayOfWeek dow = date.getDayOfWeek();
        LocalDate temp = LocalDate.of(date.getYear(), 1, 1);

        int count = 0;
        
        while (!temp.isAfter(date)) {
            if (temp.getDayOfWeek() == dow) {
                count++;
            }
            temp = temp.plusDays(1);
        }
        return count;
    }

    public static int totalWeekdayInYear(LocalDate date) {
        DayOfWeek dow = date.getDayOfWeek();
        LocalDate temp = LocalDate.of(date.getYear(), 1, 1);

        int count = 0;
        while (temp.getYear() == date.getYear()) {
            if (temp.getDayOfWeek() == dow) {
                count++;
            }
            temp = temp.plusDays(1);
        }
        return count;
    }

    public static int weekdayOrderInMonth(LocalDate date) {
        DayOfWeek dow = date.getDayOfWeek();
        LocalDate temp = date.withDayOfMonth(1);

        int count = 0;
        while (!temp.isAfter(date)) {
            if (temp.getDayOfWeek() == dow) {
                count++;
            }
            temp = temp.plusDays(1);
        }
        return count;
    }

    public static int totalWeekdayInMonth(LocalDate date) {
        DayOfWeek dow = date.getDayOfWeek();
        LocalDate temp = date.withDayOfMonth(1);

        int count = 0;
        while (temp.getMonth() == date.getMonth()) {
            if (temp.getDayOfWeek() == dow) {
                count++;
            }
            temp = temp.plusDays(1);
        }
        return count;
    }
    public static Period getPeriod(LocalDate start, LocalDate end) {
        return Period.between(start, end);
    }

    public static Duration getDuration(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end);
    }

    public static String format(LocalDateTime time) {
        return time.format(sdf);
    }
    public static String getWeekday(LocalDateTime time) {
        String name = time.getDayOfWeek().toString();
        return name.substring(0, 1) + name.substring(1).toLowerCase();
    }
    
}

