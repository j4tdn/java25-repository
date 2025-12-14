package ex02;

import java.time.*;
import java.time.temporal.WeekFields;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập ngày: ");
            int d = sc.nextInt();
            System.out.print("Nhập tháng: ");
            int m = sc.nextInt();
            System.out.print("Nhập năm: ");
            int y = sc.nextInt();

            LocalDate date = LocalDate.of(y, m, d);

            DayOfWeek dow = date.getDayOfWeek();
            int dayOfYear = date.getDayOfYear();
            int daysInYear = date.lengthOfYear();
            int daysLeft = daysInYear - dayOfYear;
            int weekOfYear = date.get(WeekFields.ISO.weekOfYear());
            int weekOfMonth = date.get(WeekFields.ISO.weekOfMonth());
            int daysInMonth = date.lengthOfMonth();

            System.out.println("\n==== KẾT QUẢ ====");
            System.out.println(date + " là " + dow);
            System.out.println("• Ngày thứ " + dayOfYear + " của năm, còn " + daysLeft + "ngày nữa hết năm");
            System.out.println("• Tuần thứ " + weekOfYear + " của năm " + y);
            System.out.println("• Tuần thứ " + weekOfMonth + " của tháng " + m);
            System.out.println("• Năm " + y + " có " + daysInYear + " ngày");
            System.out.println("• Tháng " + m + " có " + daysInMonth + " ngày");

        } catch (Exception e) {
            System.out.println("Ngày tháng năm không hợp lệ!");
        }
    }
}

