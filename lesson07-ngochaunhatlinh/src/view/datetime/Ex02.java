package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Nhap ngay (dd/MM/yyyy): ");
            Date date = sdf.parse(sc.nextLine());

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            String[] days = {
                "Chu nhat", "Thu hai", "Thu ba", "Thu tu",
                "Thu nam", "Thu sau", "Thu bay"
            };

            System.out.println("========== KET QUA ==========");
            System.out.println("Thu: " + days[cal.get(Calendar.DAY_OF_WEEK) - 1]);
            System.out.println("Ngay thu: " + cal.get(Calendar.DAY_OF_YEAR));
            System.out.println("Thang co: " + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + " ngay");
            System.out.println("Nam co: " + cal.getActualMaximum(Calendar.DAY_OF_YEAR) + " ngay");

        } catch (Exception e) {
            System.out.println("Loi: Ngay nhap khong hop le. Vui long nhap dung dinh dang dd/MM/yyyy.");
        }

        sc.close();
    }
}
