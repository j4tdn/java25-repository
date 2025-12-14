package ex03;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {
       s1();
       s2();
       s3();
       s4();
       s5();
       s6();
    }
    static DateTimeFormatter fDT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    static DateTimeFormatter fD  = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static void s1() {
        ZoneId zone = ZoneId.of("Asia/Tokyo");
        System.out.println(ZonedDateTime.now(zone).format(fDT));
    }

    static void s2() {
        LocalDate d = LocalDate.now();
        System.out.println(d.withDayOfMonth(d.lengthOfMonth()).format(fD));
    }

    static void s3() {
        LocalDate now = LocalDate.now();
        WeekFields wf = WeekFields.of(Locale.getDefault());
        System.out.println("Đầu tuần: " + now.with(wf.dayOfWeek(), 1).format(fD));
        System.out.println("Cuối tuần: " + now.with(wf.dayOfWeek(), 7).format(fD));
    }


    static void s4() {
        int w = LocalDate.now().get(WeekFields.ISO.weekOfYear());
        System.out.println("Tuần thứ: " + w);
    }

    static void s5() {
        LocalDate d = LocalDate.now().plusDays(20);
        System.out.println(d.format(fD) + " - " + d.getDayOfWeek());
    }

    static void s6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        LocalDate birth = LocalDate.parse(sc.nextLine(), fD);
        long days = Duration.between(birth.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
        System.out.println("Bạn đã sống: " + days + " ngày");
    }
}
