package viewdatatime8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.Period;
import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhap ngay bat dau yeu (dd/mm/yyyy HH:mm:ss): ");
            LocalDateTime startLove = LocalDateTime.parse(sc.nextLine(), dtf);

            LocalDateTime end;
            System.out.print("Đã chia tay chưa?(y/n): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("y")) {
                System.out.print("Nhập ngày chia tay (dd/MM/yyyy HH:mm:ss): ");
                end = LocalDateTime.parse(sc.nextLine(), dtf);
            } else {
                end = LocalDateTime.now(); 
            }

            
            Period period = Period.between(startLove.toLocalDate(), end.toLocalDate());
            
            Duration duration = Duration.between(startLove, end);

            long totalSeconds = duration.getSeconds();
            long second = totalSeconds % 60;
            long minute = (totalSeconds / 60) % 60;
            long hour = (totalSeconds / 3600) % 24;

            System.out.printf(
            		"Mối tình đã bắt đầu được: "+ period.getYears() +" năm "+ period.getMonths() +" tháng "+period.getDays() +" ngày "+hour +" giờ "+minute +" phút "+second +" giây "
            );

        } catch (Exception e) {
            System.out.println("Sai định dạng. Vui lòng nhập lại: dd/MM/yyyy HH:mm:ss");
        }

    }
}