package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * Bài 1: Xây dựng ứng dụng The Ultimate Relationship Calculator
▪ Nhập thời gian bắt đầu hẹn hò của 2 người.
▪ Nếu đã chia tay, nhập ngày chia tay ngược lại lấy thời gian hiện tại
▪ Nhấn Enter để thực hiện tính toán → Hỏi
▪ Ngày bắt đầu hẹn họ là ngày thứ mấy.
▪ Mối tình đã bắt đầu được bao nhiêu năm, tháng, ngày, giờ, phút, giây
 */
public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		try {
            System.out.println("Nhập ngày bắt đầu hẹn hò (dd/MM/yyyy HH:mm:ss): ");
            Date startDate = sdf.parse(sc.nextLine());

            System.out.println("Đã chia tay chưa? (yes/no): ");
            String answer = sc.nextLine();

            Date endDate;
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Nhập ngày chia tay (dd/MM/yyyy HH:mm:ss): ");
                endDate = sdf.parse(sc.nextLine());
            } else {
                endDate = new Date();
            }

            // Thứ
            Calendar startCal = Calendar.getInstance();
            startCal.setTime(startDate);

            String[] days = {"Chủ Nhật", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7"};

            int dayOfWeek = startCal.get(Calendar.DAY_OF_WEEK);
            System.out.println("Ngày bắt đầu là: " + days[dayOfWeek - 1]);

            // Chênh lệch tgian
            long diff = endDate.getTime() - startDate.getTime();

            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long daysDiff = hours / 24;

            long years = daysDiff / 365;
            long months = (daysDiff % 365) / 30;
            long daysRemain = (daysDiff % 365) % 30;

            long hoursRemain = hours % 24;
            long minutesRemain = minutes % 60;
            long secondsRemain = seconds % 60;

            System.out.println("Thời gian yêu nhau:");
            System.out.println(years + " năm");
            System.out.println(months + " tháng");
            System.out.println(daysRemain + " ngày");
            System.out.println(hoursRemain + " giờ");
            System.out.println(minutesRemain + " phút");
            System.out.println(secondsRemain + " giây");

        } catch (Exception e) {
            System.out.println("Nhập ngày sai!");
        }
	}
}
