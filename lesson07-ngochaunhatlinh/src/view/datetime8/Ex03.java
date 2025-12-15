package view.datetime8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Ex03 {

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        hienTai();
        ngayCuoiThang();
        dauCuoiTuan();
        tuanTrongNam();
        sau20Ngay();
        songBaoNhieuNgay(2005, 10, 7);
    }

    public static void hienTai() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Hien tai: " + now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    public static void ngayCuoiThang() {
        LocalDate today = LocalDate.now();
        YearMonth ym = YearMonth.from(today);
        LocalDate lastDay = ym.atEndOfMonth();
        System.out.println("Cuoi thang: " + lastDay.format(dtf));
    }

    public static void dauCuoiTuan() {
        LocalDate today = LocalDate.now();
        
        LocalDate monday = today.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);
        LocalDate sunday = monday.plusDays(6);
        System.out.println("Dau tuan: " + monday.format(dtf));
        System.out.println("Cuoi tuan: " + sunday.format(dtf));
    }

    public static void tuanTrongNam() {
        LocalDate today = LocalDate.now();
        int weekOfYear = today.get(WeekFields.of(Locale.getDefault()).weekOfYear());
        System.out.println("Tuan thu: " + weekOfYear);
    }

    public static void sau20Ngay() {
        LocalDate today = LocalDate.now();
        LocalDate after20 = today.plusDays(20);
        System.out.println("Sau 20 ngay: " + after20.format(dtf));
    }

    public static void songBaoNhieuNgay(int y, int m, int d) {
        LocalDate birth = LocalDate.of(y, m, d);
        LocalDate today = LocalDate.now();
        long days = ChronoUnit.DAYS.between(birth, today);
        System.out.println("Da song: " + days + " ngay");
    }
}
