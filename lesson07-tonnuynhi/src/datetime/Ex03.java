package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class Ex03 {

    private static final DateTimeFormatter DTF_DATE_TIME = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter DTF_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final WeekFields WEEK_FIELDS = WeekFields.of(Locale.getDefault());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Chọn chức năng (0-6): ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> showCurrentTimeByZone(sc);
                case "2" -> printLastDayOfCurrentMonth();
                case "3" -> printFirstAndLastDayOfCurrentWeek();
                case "4" -> printWeekNumberInYear();
                case "5" -> printDateAfter20Days();
                case "6" -> calcDaysLived(sc);
                case "0" -> {
                    System.out.println("Bye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("❌ Lựa chọn không hợp lệ.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("=== BÀI 3 - DATE TIME MENU ===");
        System.out.println("1. Xem thời gian hiện tại (dd/MM/yyyy HH:mm:ss) ở khu vực bất kỳ");
        System.out.println("2. In ngày cuối cùng của tháng hiện tại (dd/MM/yyyy)");
        System.out.println("3. Xem ngày đầu tiên và cuối cùng của tuần hiện tại");
        System.out.println("4. Xem ngày hiện tại đang ở tuần thứ mấy trong năm");
        System.out.println("5. Kiểm tra sau 20 ngày nữa là ngày nào, thứ mấy");
        System.out.println("6. Nhập ngày sinh, kiểm tra đã sống được bao nhiêu ngày");
        System.out.println("0. Thoát");
    }

    private static void showCurrentTimeByZone(Scanner sc) {
        System.out.println("Ví dụ Zone: Asia/Tokyo, Asia/Ho_Chi_Minh, Europe/London, America/New_York");
        System.out.print("Nhập ZoneId: ");
        String zoneInput = sc.nextLine().trim();

        try {
            ZoneId zone = ZoneId.of(zoneInput);
            ZonedDateTime now = ZonedDateTime.now(zone);
            System.out.println("Thời gian hiện tại tại " + zone + ": " + now.format(DTF_DATE_TIME));
        } catch (DateTimeException e) {
            System.out.println("❌ ZoneId không hợp lệ. Hãy thử lại (VD: Asia/Tokyo).");
        }
    }

    private static void printLastDayOfCurrentMonth() {
        LocalDate today = LocalDate.now();
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Ngày cuối cùng của tháng hiện tại: " + lastDay.format(DTF_DATE));
    }

    private static void printFirstAndLastDayOfCurrentWeek() {
        LocalDate today = LocalDate.now();
        DayOfWeek firstDow = WEEK_FIELDS.getFirstDayOfWeek();
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(firstDow));
        LocalDate endOfWeek = startOfWeek.plusDays(6);

        System.out.println("Tuần hiện tại:");
        System.out.println("  Ngày đầu tuần: " + startOfWeek.format(DTF_DATE) + " (" + startOfWeek.getDayOfWeek() + ")");
        System.out.println("  Ngày cuối tuần: " + endOfWeek.format(DTF_DATE) + " (" + endOfWeek.getDayOfWeek() + ")");
    }

    private static void printWeekNumberInYear() {
        LocalDate today = LocalDate.now();
        int weekNo = today.get(WEEK_FIELDS.weekOfWeekBasedYear());
        int year = today.get(WEEK_FIELDS.weekBasedYear());
        System.out.println("Hôm nay thuộc tuần thứ " + weekNo + " của năm " + year + ".");
    }

    private static void printDateAfter20Days() {
        LocalDate today = LocalDate.now();
        LocalDate future = today.plusDays(20);
        System.out.println("Sau 20 ngày nữa là: " + future.format(DTF_DATE) + " (" + future.getDayOfWeek() + ")");
    }

    private static void calcDaysLived(Scanner sc) {
        LocalDate birth = readDate(sc, "Nhập ngày sinh (dd/MM/yyyy): ");
        LocalDate today = LocalDate.now();

        if (birth.isAfter(today)) {
            System.out.println("❌ Ngày sinh không được ở tương lai.");
            return;
        }

        long days = Duration.between(birth.atStartOfDay(), today.atStartOfDay()).toDays();
        System.out.println("Bạn đã sống được khoảng: " + days + " ngày.");
    }

    private static LocalDate readDate(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return LocalDate.parse(input, DTF_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Sai format. VD đúng: 14/12/2000");
            }
        }
    }
}
