package datetime_homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.Period;
import java.util.Scanner;

public class Bai1 {
public static void main(String[] args) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the date starting the love relationship (dd/mm/yyyy HH:mm:ss): ");
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);

            LocalDateTime end;
            System.out.print("Did you break up(y/n): ");
            String choose = sc.nextLine();

            if (choose.equalsIgnoreCase("y")) {
                System.out.print("Enter the date ending the love relationship  (dd/mm/yyyy HH:mm:ss): ");
                end = LocalDateTime.parse(sc.nextLine(), dtf);
            } else {
                end = LocalDateTime.now(); 
            }

            
            Period period = Period.between(start.toLocalDate(), end.toLocalDate());
            
            Duration duration = Duration.between(start, end);

            long totalSeconds = duration.getSeconds();
            long second = totalSeconds % 60;
            long minute = (totalSeconds / 60) % 60;
            long hour = (totalSeconds / 3600) % 24;

            System.out.printf(
                "Total time in love: %d năm %d tháng %d ngày %d giờ %d phút %d giây\n",
                period.getYears(), period.getMonths(), period.getDays(), hour, minute, second
            );

        } catch (Exception e) {
            System.out.println("Wrong format, enter again dd/MM/yyyy HH:mm:ss");
        }

        sc.close();
    }
}
