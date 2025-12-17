package view.datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Ex02 {

    static final String[] dow = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ Nhật" };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ngày: ");
        int day = sc.nextInt();

        System.out.print("Nhập tháng: ");
        int month = sc.nextInt();

        System.out.print("Nhập năm: ");
        int year = sc.nextInt();

        try {
            LocalDate date = LocalDate.of(year, month, day);

            // thứ
            DayOfWeek dayOfWeek = date.getDayOfWeek();

            // ngày bao nhiêu trong năm
            int dayOfYear = date.getDayOfYear();

            // số ngày trong tháng
            int daysInMonth = date.lengthOfMonth();

            // năm nhuận
            boolean isLeapYear = date.isLeapYear();

            // Output
            System.out.println("Thông tin ngày đã nhập:");
            System.out.println("Thứ: " + dow[dayOfWeek.getValue() - 1]);
            System.out.println("Ngày thứ " + dayOfYear + " trong năm");
            System.out.println("Tháng " + month + " có " + daysInMonth + " ngày");
            System.out.println("Năm " + year + (isLeapYear ? " là năm nhuận" : " k phải năm nhuận"));

        } catch (Exception e) {
            System.out.println("Ngày không hợp lệ!");
        }
    }
}
