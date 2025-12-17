package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Ex01{

    private static final Locale VI = new Locale("vi", "VN");
    private static final SimpleDateFormat DTF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", VI);

    public static void main(String[] args) {
        Locale.setDefault(VI);
        DTF.setLenient(false);

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("=== The Ultimate Relationship Calculator (Legacy) ===");
            System.out.println("Format: dd/MM/yyyy HH:mm:ss (VD: 14/12/2025 09:00:00)");
            System.out.println();

            Calendar start = readDateTime(sc, "Nhập thời gian bắt đầu hẹn hò: ");

            boolean brokeUp = readYesNo(sc, "Đã chia tay chưa? (y/n): ");

            Calendar end;
            if (brokeUp) {
                while (true) {
                    end = readDateTime(sc, "Nhập thời gian chia tay: ");
                    if (!end.before(start)) break;
                    System.out.println("❌ Thời gian chia tay không được trước thời gian bắt đầu. Nhập lại!");
                }
            } else {
                end = Calendar.getInstance();
            }

            System.out.println();
            System.out.println("----- KẾT QUẢ / RESULT -----");

            int dow = start.get(Calendar.DAY_OF_WEEK);
            System.out.println("Ngày bắt đầu (VN): " + toVietnameseDayOfWeek(dow));
            System.out.println("Start day (EN): " + toEnglishDayOfWeek(dow));

            Calendar startDateOnly = cloneCal(start);
            Calendar endDateOnly = cloneCal(end);
            zeroTime(startDateOnly);
            zeroTime(endDateOnly);

            int years = 0, months = 0, days = 0;
            Calendar cursor = cloneCal(startDateOnly);

            while (true) {
                Calendar next = cloneCal(cursor);
                next.add(Calendar.YEAR, 1);
                if (next.compareTo(endDateOnly) <= 0) {
                    cursor = next;
                    years++;
                } else break;
            }

            while (true) {
                Calendar next = cloneCal(cursor);
                next.add(Calendar.MONTH, 1);
                if (next.compareTo(endDateOnly) <= 0) {
                    cursor = next;
                    months++;
                } else break;
            }

            while (true) {
                Calendar next = cloneCal(cursor);
                next.add(Calendar.DAY_OF_MONTH, 1);
                if (next.compareTo(endDateOnly) <= 0) {
                    cursor = next;
                    days++;
                } else break;
            }

            System.out.println("Mối tình đã bắt đầu được: " + years + " năm, " + months + " tháng, " + days + " ngày");

            long diffMillis = end.getTimeInMillis() - start.getTimeInMillis();
            long totalSeconds = diffMillis / 1000;
            long totalMinutes = diffMillis / (60 * 1000);
            long totalHours = diffMillis / (60 * 60 * 1000);

            System.out.println("Giờ (total hours): " + totalHours);
            System.out.println("Phút (total minutes): " + totalMinutes);
            System.out.println("Giây (total seconds): " + totalSeconds);

            System.out.println("----------------------------");

        } finally {
            sc.close();
        }
    }

    private static Calendar readDateTime(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                Calendar cal = Calendar.getInstance();
                cal.setTime(DTF.parse(input));
                return cal;
            } catch (ParseException e) {
                System.out.println("❌ Sai format. VD đúng: 14/12/2025 09:00:00");
            }
        }
    }

    private static boolean readYesNo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String ans = sc.nextLine().trim();
            if ("y".equalsIgnoreCase(ans)) return true;
            if ("n".equalsIgnoreCase(ans)) return false;
            System.out.println("❌ Chỉ nhập 'y' hoặc 'n'.");
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

    private static String toVietnameseDayOfWeek(int dayOfWeek) {
        String[] vn = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
        return vn[dayOfWeek - 1];
    }

    private static String toEnglishDayOfWeek(int dayOfWeek) {
        String[] en = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        return en[dayOfWeek - 1];
    }
}
