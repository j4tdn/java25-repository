package datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date startDate = null;
        Date endDate = null;

        while (true) {
            System.out.print("Nhap ngay bat dau hen ho (dd/MM/yyyy HH:mm:ss): ");
            try {
                startDate = sdf.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sai dinh dang ngay. Hay nhap lai!");
            }
        }

        String answer;
        while (true) {
            System.out.print("Da chia tay chua? (y/n): ");
            answer = sc.nextLine();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("Chi duoc nhap y hoac n!");
        }

        if (answer.equalsIgnoreCase("y")) {
            while (true) {
                System.out.print("Nhap ngay chia tay (dd/MM/yyyy HH:mm:ss): ");
                try {
                    endDate = sdf.parse(sc.nextLine());
                    if (endDate.before(startDate)) {
                        System.out.println("Ngay chia tay phai sau ngay bat dau!");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Sai dinh dang ngay chia tay. Hay nhap lai!");
                }
            }
        } else {
            endDate = new Date(); 
        }

        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        String[] weekdays = {
                "Chu nhat", "Thu 2", "Thu 3",
                "Thu 4", "Thu 5", "Thu 6", "Thu 7"
        };

        int dayOfWeek = startCal.get(Calendar.DAY_OF_WEEK);
        System.out.println("Ngay bat dau hen ho la: " + weekdays[dayOfWeek - 1]);

        long diffMillis = endDate.getTime() - startDate.getTime();

        long seconds = diffMillis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        long years = days / 365;
        days = days % 365;

        long months = days / 30;
        days = days % 30;

        hours = hours % 24;
        minutes = minutes % 60;
        seconds = seconds % 60;

        System.out.println("Thoi gian yeu nhau:");
        System.out.println(
                years + " nam, " +
                months + " thang, " +
                days + " ngay, " +
                hours + " gio, " +
                minutes + " phut, " +
                seconds + " giay"
        );
	}
}
