package view.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static utils.DateTimeUtils.*;

public class Ex02WeekdayCalculator {

    private static final Scanner ip = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(new Locale("vi", "VN"));
        try {
            int day = readTime("Nhập ngày (1-31): ");
            if (day < 1 || day > 31) {
                throw new IllegalArgumentException("Ngày phải từ 1 đến 31");
            }

            int month = readTime("Nhập tháng (1-12): ");
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Tháng phải từ 1 đến 12");
            }

            int year = readTime("Nhập năm (>0): ");
            if (year <= 0) {
                throw new IllegalArgumentException("Năm phải > 0");
            }

            LocalDate date = LocalDate.of(year, month, day);
            DayOfWeek dow = date.getDayOfWeek();
            int intDow = convertDayOfWeekToInt(dow);
            String weekdayName = getDayOfWeeksInVietnamese(intDow);
            System.out.println(day + "/" + month + "/" + year + " là " + weekdayName);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ip.close();
        }
    }

    private static int readTime(String message) {
        System.out.print(message);
        String text = ip.nextLine();
        if (isNumber(text)) {
            return Integer.parseInt(text);
        } else {
            throw new IllegalArgumentException("Dữ liệu nhập vào phải là số");
        }
    }

    private static boolean isNumber(String text) {
        if (text == null || text.length() == 0) return false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }
	
}