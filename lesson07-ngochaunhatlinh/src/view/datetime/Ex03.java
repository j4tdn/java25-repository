package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex03 {

    static SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        hienTai();
        ngayCuoiThang();
        dauCuoiTuan();
        tuanTrongNam();
        sau20Ngay();
        songBaoNhieuNgay(1995, 9, 25);
    }

 
    public static void hienTai() {
        Date now = new Date();
        System.out.println("Hien tai: " + sdfDateTime.format(now));
    }

    public static void ngayCuoiThang() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("Cuoi thang: " + sdfDate.format(cal.getTime()));
    }

    public static void dauCuoiTuan() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("Dau tuan: " + sdfDate.format(cal.getTime()));
        cal.add(Calendar.DATE, 6);
        System.out.println("Cuoi tuan: " + sdfDate.format(cal.getTime()));
    }

    public static void tuanTrongNam() {
        Calendar cal = Calendar.getInstance();
        System.out.println("Tuan thu: " + cal.get(Calendar.WEEK_OF_YEAR));
    }

    public static void sau20Ngay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 20);
        System.out.println("Sau 20 ngay: " + sdfDate.format(cal.getTime()));
    }

    public static void songBaoNhieuNgay(int y, int m, int d) {
        Calendar birth = Calendar.getInstance();
        birth.set(y, m - 1, d);
        long days = (System.currentTimeMillis() - birth.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        System.out.println("Da song: " + days + " ngay");
    }

}
