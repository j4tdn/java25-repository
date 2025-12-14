package view.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.print("Ngày bắt đầu hẹn hò (dd/MM/yyyy HH:mm:ss): ");
        String startStr = sc.nextLine();
        Date startDate = sdf.parse(startStr);

        System.out.print("Đã chia tay chưa?(y/n): ");
        String ans = sc.nextLine();

        Date endDate;
        if (ans.toLowerCase().startsWith("y")) {
            System.out.print("Nhập ngày chia tay (dd/MM/yyyy HH:mm:ss): ");
            String endStr = sc.nextLine();
            endDate = sdf.parse(endStr);
        } else {
            endDate = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        String[] days = {"Chủ nhật","Thứ hai","Thứ ba","Thứ tư","Thứ năm","Thứ sáu","Thứ bảy"};
        String dayOfWeek = days[cal.get(Calendar.DAY_OF_WEEK) - 1];

        System.out.println("\n Ngày bắt đầu là: " + dayOfWeek);

        long diff = endDate.getTime() - startDate.getTime();

        long second = diff / 1000;
        long minute = second / 60;
        long hour   = minute / 60;
        long dayDiff = hour / 24;

        long year = dayDiff / 365;
        long month = (dayDiff % 365) / 30;
        long day = (dayDiff % 365) % 30;

        System.out.println("Đã yêu:");
        System.out.println(year + " năm");
        System.out.println(month + " tháng");
        System.out.println(day + " ngày");
        System.out.println(hour + " giờ");
        System.out.println(minute + " phút");
        System.out.println(second + " giây");
        
        sc.close();
    }
}
