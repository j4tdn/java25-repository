package datetime;

import java.util.Calendar;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int day, month, year;

        while (true) {
            try {
                System.out.print("Nhap ngay: ");
                day = Integer.parseInt(sc.nextLine());

                System.out.print("Nhap thang: ");
                month = Integer.parseInt(sc.nextLine());

                System.out.print("Nhap nam: ");
                year = Integer.parseInt(sc.nextLine());

                Calendar cal = Calendar.getInstance();
                cal.setLenient(false); 
                cal.set(year, month - 1, day);
                cal.getTime(); 

                break; 

            } catch (Exception e) {
                System.out.println("Ngay thang nam khong hop le. Hay nhap lai!\n");
            }
        }

        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        String[] weekdays = {
                "Chu nhat", "Thu 2", "Thu 3",
                "Thu 4", "Thu 5", "Thu 6", "Thu 7"
        };

        System.out.println("\n===== KET QUA =====");

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("Ngay nay la: " + weekdays[dayOfWeek - 1]);

        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
        System.out.println("Day la ngay thu " + dayOfYear + " trong nam");

        int maxDayOfYear = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        System.out.println("Con " + (maxDayOfYear - dayOfYear) + " ngay nua la het nam");

        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("Thang nay co " + daysInMonth + " ngay");

        System.out.println("Nam nay co " + maxDayOfYear + " ngay");
    }

}
