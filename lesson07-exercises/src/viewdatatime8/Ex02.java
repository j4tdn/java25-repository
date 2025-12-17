package viewdatatime8;

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

            String[] days = {"Chủ nhật","Thứ hai","Thứ ba","Thứ tư","Thứ năm","Thứ sáu","Thứ bảy"};


            int finalday = date.lengthOfYear() - date.getDayOfYear();

           
            System.out.println(date + " là " + days[date.getDayOfWeek().getValue() % 7]);
            System.out.println("Là ngày số " + date.getDayOfYear() + ", " + finalday + " ngày nữa hết năm.");
            System.out.println("Năm " + date.getYear() + " có " + date.lengthOfYear() + " ngày.");
            System.out.println("Tháng " + date.getMonthValue() + " năm " + date.getYear() + " có " + YearMonth.of(date.getYear(), date.getMonth()).lengthOfMonth() + " ngày.");
               
            
        } catch (Exception e) {
            System.out.println("Sai định dạng. Vui lòng nhập lại: dd/MM/yyyy.");
        }
        sc.close();
    }
}