package view.datetime8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.YearMonth;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            System.out.print("Nhap ngay (dd/MM/yyyy): ");
            LocalDate date = LocalDate.parse(sc.nextLine(), dtf);

            String[] days = {
                "Chu nhat", "Thu hai", "Thu ba", "Thu tu",
                "Thu nam", "Thu sau", "Thu bay"
            };

            System.out.println("========== KET QUA ==========");
            System.out.println("Thu: " + days[date.getDayOfWeek().getValue() % 7]);
            System.out.println("Ngay trong nam: " + date.getDayOfYear());
            System.out.println("Thang co: " + YearMonth.from(date).lengthOfMonth() + " ngay");
            System.out.println("Nam co: " + date.lengthOfYear() + " ngay");

        } catch (Exception e) {
            System.out.println("Loi: Ngay nhap khong hop le. Vui long nhap dung dinh dang dd/MM/yyyy.");
        }
        sc.close();
    }
}
