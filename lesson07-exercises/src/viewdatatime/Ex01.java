package viewdatatime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.print("Ngày bắt đầu hẹn hò (dd/MM/yyyy HH:mm:ss): ");
        String startLove = sc.nextLine();
        Date startDate = df.parse(startLove);

        System.out.print("Đã chia tay chưa?(y/n): ");
        String input = sc.nextLine();

        Date endDay;
        if (input.toLowerCase().startsWith("y")) {
            System.out.print("Nhập ngày chia tay (dd/MM/yyyy HH:mm:ss): ");
            String endStr = sc.nextLine();
            endDay = df.parse(endStr);
        } else {
            endDay = new Date();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        String[] days = {"Chủ nhật","Thứ hai","Thứ ba","Thứ tư","Thứ năm","Thứ sáu","Thứ bảy"};
        String dayOfWeek = days[c.get(Calendar.DAY_OF_WEEK) - 1];

        System.out.println(" Ngày bắt đầu là: " + dayOfWeek);

        long diff = endDay.getTime() - startDate.getTime();

        long second = diff / 1000;
        long minute = second / 60;
        long hour   = minute / 60;
        long dayDiff = hour / 24;

        long year = dayDiff / 365;
        long month = (dayDiff % 365) / 30;
        long day = (dayDiff % 365) % 30;

        System.out.println("Mối tình đã bắt đầu được: "+ year +" năm "+ month +" tháng "+day +" ngày "+hour +" giờ "+minute +" phút "+second +" giây ");
         
      
    }
}