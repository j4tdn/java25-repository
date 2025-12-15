package view.datetime8;

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
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);

            LocalDateTime end;
            System.out.print("Ban da chia tay Chua(y/n): ");
            String chon = sc.nextLine();

            if (chon.equalsIgnoreCase("y")) {
                System.out.print("Nhap ngay ctay (dd/mm/yyyy HH:mm:ss): ");
                end = LocalDateTime.parse(sc.nextLine(), dtf);
            } else {
                end = LocalDateTime.now(); 
            }

            
            Period period = Period.between(start.toLocalDate(), end.toLocalDate());
            
            Duration duration = Duration.between(start, end);

            long totalSeconds = duration.getSeconds();
            long giay = totalSeconds % 60;
            long phut = (totalSeconds / 60) % 60;
            long gio = (totalSeconds / 3600) % 24;

            System.out.printf(
                "Tổng thời gian yêu: %d năm %d tháng %d ngày %d giờ %d phút %d giây\n",
                period.getYears(), period.getMonths(), period.getDays(), gio, phut, giay
            );

        } catch (Exception e) {
            System.out.println("Ghi sai dinh dang muoi h, vui long nhap lai dd/MM/yyyy HH:mm:ss");
        }

        sc.close();
    }
}
