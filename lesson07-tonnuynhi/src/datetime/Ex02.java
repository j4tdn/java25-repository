package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ex02 {

    private static final Locale VI = new Locale("vi", "VN");
    private static final SimpleDateFormat DTF_DATE_TIME = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", VI);
    private static final SimpleDateFormat DTF_DATE = new SimpleDateFormat("dd/MM/yyyy", VI);

    public static void main(String[] args) {
        Locale.setDefault(VI);
        DTF_DATE_TIME.setLenient(false);
        DTF_DATE.setLenient(false);

        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                printMenu();
                System.out.print("Chọn chức năng (0-6): ");
                String choice = sc.nextLine().trim();

                if ("0".equals(choice)) {
                    System.out.println("Bye!");
                    return;
                }

                if ("1".equals(choice)) showCurrentTimeByZone(sc);
                else if ("2".equals(choice)) printLastDayOfCurrentMonth();
                else if ("3".equals(choice)) printFirstAndLastDayOfCurrentWeek();
                else if ("4".equals(choice)) printWeekNumberInYear();
                else if ("5".equals(choice)) printDateAfter20Days();
                else if ("6".equals(choice)) calcDaysLived(sc);
                else System.out.println("❌ Lựa chọn không hợp lệ.");

                System.out.println();
            }
        } finally {
            sc.close();
        }
    }

    private static void printMenu() {
        System.out.println("=== BÀI 3 - DATE TIME MENU (Legacy) ===");
        System.out.println("1. Xem thời gian hiện tại (dd/MM/yyyy HH:mm:ss) ở khu vực bất kỳ");
        System.out.println("2. In ngày cuối cùng của tháng hiện tại (dd/MM/yyyy)");
        System.out.println("3. Xem ngày đầu tiên và cuối cùng của tuần hiện tại");
        System.out.println("4. Xem hôm nay đang ở tuần thứ mấy trong năm");
        System.out.println("5. Kiểm tra sau 20 ngày nữa là ngày nào, thứ mấy");
        System.out.println("6. Nhập ngày sinh, kiểm tra đã sống được bao nhiêu ngày");
        System.out.println("0. Thoát");
    }

    private static void showCurrentTimeByZone(Scanner sc) {
        System.out.println("Ví dụ ZoneId: Asia/Tokyo, Asia/Ho_Chi_Minh, Europe/London, America/New_York");
        System.out.print("Nhập ZoneId: ");
        String zoneInput = sc.nextLine().trim();

        if (!isValidTimeZoneId(zoneInput)) {
            System.out.println("❌ ZoneId không hợp lệ. VD: Asia/Tokyo");
            return;
        }

        TimeZone tz = TimeZone.getTimeZone(zoneInput);
        Calendar now = Calendar.getInstance(tz);

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", VI);
        fmt.setTimeZone(tz);

        System.out.println("Thời gian hiện tại tại " + zoneInput + ": " + fmt.format(now.getTime()));
    }

    private static boolean isValidTimeZoneId(String id) {
        String[] ids = TimeZone.getAvailableIDs();
        for (int i = 0; i < ids.length; i++) {
            if (ids[i].equals(id)) return true;
        }
        return false;
    }

    private static void printLastDayOfCurrentMonth() {
        Calendar today = Calendar.getInstance();
        Calendar last = cloneCal(today);
        int maxDay = last.getActualMaximum(Calendar.DAY_OF_MONTH);
        last.set(Calendar.DAY_OF_MONTH, maxDay);

        System.out.println("Ngày cuối cùng của tháng hiện tại: " + DTF_DATE.format(last.getTime()));
    }

    private static void printFirstAndLastDayOfCurrentWeek() {
        Calendar today = Calendar.getInstance(VI);
        Calendar start = cloneCal(today);

        int firstDow = start.getFirstDayOfWeek(); // phụ thuộc locale
        while (start.get(Calendar.DAY_OF_WEEK) != firstDow) {
            start.add(Calendar.DAY_OF_MONTH, -1);
        }

        Calendar end = cloneCal(start);
        end.add(Calendar.DAY_OF_MONTH, 6);

        System.out.println("Tuần hiện tại:");
        System.out.println("  Ngày đầu tuần: " + DTF_DATE.format(start.getTime()) + " (" + dayNameEn(start) + ")");
        System.out.println("  Ngày cuối tuần: " + DTF_DATE.format(end.getTime()) + " (" + dayNameEn(end) + ")");
    }

    private static void printWeekNumberInYear() {
        GregorianCalendar cal = new GregorianCalendar(VI);
        int weekNo = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.getWeekYear(); // week-based-year (Java 7+)
        System.out.println("Hôm nay thuộc tuần thứ " + weekNo + " của năm " + year + ".");
    }

    private static void printDateAfter20Days() {
        Calendar today = Calendar.getInstance();
        Calendar future = cloneCal(today);
        future.add(Calendar.DAY_OF_MONTH, 20);
        System.out.println("Sau 20 ngày nữa là: " + DTF_DATE.format(future.getTime()) + " (" + dayNameEn(future) + ")");
    }

    private static void calcDaysLived(Scanner sc) {
        Calendar birth = readDate(sc, "Nhập ngày sinh (dd/MM/yyyy): ");

        Calendar today = Calendar.getInstance();
        zeroTime(today);
        zeroTime(birth);

        if (birth.after(today)) {
            System.out.println("❌ Ngày sinh không được ở tương lai.");
            return;
        }

        long diffMillis = today.getTimeInMillis() - birth.getTimeInMillis();
        long days = diffMillis / (24L * 60 * 60 * 1000);
        System.out.println("Bạn đã sống được khoảng: " + days + " ngày.");
    }

    private static Calendar readDate(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                Calendar cal = Calendar.getInstance();
                cal.setTime(DTF_DATE.parse(input));
                return cal;
            } catch (ParseException e) {
                System.out.println("❌ Sai format. VD đúng: 14/12/2000");
            }
        }
    }

    private static void zeroTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }

    private static Calendar cloneCal(Calendar src) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(src.getTimeInMillis());
        return c;
    }

    private static String dayNameEn(Calendar cal) {
        String[] en = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        return en[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
