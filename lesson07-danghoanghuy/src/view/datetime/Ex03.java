package view.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {
    	
        Locale.setDefault(new Locale("vi", "VN"));
        Calendar c = Calendar.getInstance();
        
        System.out.println("Thoi gian hien tai: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(c.getTime()));
        System.out.println("\n==================\n");

        printLastDayOfMonth(c);

        System.out.println("\n==================\n");

        printFirstAndLastDayOfWeek(c);

        System.out.println("\n==================\n");

        System.out.println("Tuan hien tai: " + c.get(Calendar.WEEK_OF_YEAR));

        System.out.println("\n==================\n");

        printDateAfter20Days(c);

        System.out.println("\n==================\n");

        calculateDaysLived();
    }

    private static void printLastDayOfMonth(Calendar original) {
    	
        int maxDay = original.getActualMaximum(Calendar.DAY_OF_MONTH);
        Calendar lastDayCal = cloneAndSet(original, Calendar.DAY_OF_MONTH, maxDay);
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ngay cuoi cua thang: " + df.format(lastDayCal.getTime()));
    }

    private static void printFirstAndLastDayOfWeek(Calendar original) {
    	
        Calendar startDayOfWeek = clone(original);
        int offset = startDayOfWeek.getFirstDayOfWeek() - startDayOfWeek.get(Calendar.DAY_OF_WEEK);
        startDayOfWeek.add(Calendar.DAY_OF_MONTH, offset);
        
        Calendar endDayOfWeek = clone(startDayOfWeek);
        endDayOfWeek.add(Calendar.DAY_OF_MONTH, 6);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Ngay dau tuan: " + df.format(startDayOfWeek.getTime()) + " (" + getDayOfWeeksInVnmese(startDayOfWeek.get(Calendar.DAY_OF_WEEK)) + ")");
        
        System.out.println("Ngay cuoi tuan: " + df.format(endDayOfWeek.getTime()) + " (" + getDayOfWeeksInVnmese(endDayOfWeek.get(Calendar.DAY_OF_WEEK)) + ")");
    }

    private static void printDateAfter20Days(Calendar original) {
        Calendar futureCal = clone(original);
        futureCal.add(Calendar.DAY_OF_MONTH, 20);
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dayName = getDayOfWeeksInVnmese(futureCal.get(Calendar.DAY_OF_WEEK));
        
        System.out.println("Sau 20 ngay nua la: " + df.format(futureCal.getTime()) + " - " + dayName);
    }

    private static void calculateDaysLived() {
        Scanner ip = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        
        System.out.print("Nhap ngay sinh(dd/MM/yyyy): ");
        try {
            String dobStr = ip.nextLine();
            Date dob = df.parse(dobStr);
            Date now = new Date();
            
            long diff = now.getTime() - dob.getTime();
            long days = diff / (24 * 60 * 60 * 1000);
            
            System.out.println("Da song dc: " + days + " ngay");
        } catch (ParseException e) {
            System.out.println("Loi dinh dang");
        }
        
        ip.close();
    }

    private static String getDayOfWeeksInVnmese(int dayOfWeek) {
        String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
        return dayOfWeeks[dayOfWeek - 1];
    }

    private static Calendar cloneAndSet(Calendar source, int field, int value) {
        Calendar target = clone(source);
        target.set(field, value);
        return target;
    }

    private static Calendar clone(Calendar source) {
        Calendar target = Calendar.getInstance();
        target.setTimeInMillis(source.getTimeInMillis());
        return target;
    }
}
