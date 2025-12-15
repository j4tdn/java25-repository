package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Ex03DateTimeFunctions {

    static SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void showCurrentTime(String country, String city) {
        Calendar cal = Calendar.getInstance(
                new Locale(country, city));
        Date now = cal.getTime();
        System.out.println("Thời gian hiện tại: " + sdf.format(now));
    }

    public static void showLastDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);

        SimpleDateFormat sdfDate =
                new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ngày cuối cùng của tháng: "
                + sdfDate.format(cal.getTime()));
    }

    public static void showFirstAndLastDayOfWeek() {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date firstDay = cal.getTime();

        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date lastDay = cal.getTime();

        SimpleDateFormat sdfDate =
                new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Ngày đầu tuần: "
                + sdfDate.format(firstDay));
        System.out.println("Ngày cuối tuần: "
                + sdfDate.format(lastDay));
    }

    public static void showWeekOfYear() {
        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        System.out.println("Tuần hiện tại là tuần thứ: " + week);
    }

    public static void showDateAfter20Days() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 20);

        SimpleDateFormat sdfDay =
                new SimpleDateFormat("EEEE", new Locale("vi", "VN"));
        SimpleDateFormat sdfDate =
                new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Sau 20 ngày nữa là: "
                + sdfDate.format(cal.getTime())
                + " (" + sdfDay.format(cal.getTime()) + ")");
    }

    public static void calculateDaysLived() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            String birthStr = sc.nextLine();

            SimpleDateFormat sdfDate =
                    new SimpleDateFormat("dd/MM/yyyy");

            Date birthDate = sdfDate.parse(birthStr);
            Date now = new Date();

            long diff = now.getTime() - birthDate.getTime();
            long days = diff / (1000 * 60 * 60 * 24);

            System.out.println("Bạn đã sống được: " + days + " ngày.");

        } catch (Exception e) {
            System.out.println("Ngày sinh không hợp lệ");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== BÀI 3 - DATE TIME ===");
        showCurrentTime("vi", "VN");
        showLastDayOfMonth();
        showFirstAndLastDayOfWeek();
        showWeekOfYear();
        showDateAfter20Days();
        calculateDaysLived();
    }
}
