package datetime8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ex01 {
	public static void main(String[] args) {
		/*
		 * In thông tin ngày tháng năm với DateFormatter
         ▪ Tháng, năm hiện tại có bao nhiêu ngày
         ▪ Kiểm tra năm hiện tại có phải là năm nhuận không
         ▪ Ngày hiện tại là ngày thứ mấy, in ra ngày theo tiếng việt
         ▪ In thông tin các ngày trong tháng, tuần hiện tại dd/MM/yyyy week_day
         ▪ Đếm xem trong tháng có bao nhiêu ngày chủ nhật và in ra
		 */
		LocalDate today = LocalDate.now();

        // 1.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("1.Hôm nay: " + today.format(formatter));

        // 2.
        int daysInMonth = today.lengthOfMonth();
        System.out.println("2.Số ngày trong tháng: " + daysInMonth);

        // 3.
        boolean isLeap = today.isLeapYear();
        System.out.println("3.Năm nhuận: " + isLeap);

        // 4. 
        String[] thuVN = {
                "Thứ Hai", "Thứ Ba", "Thứ Tư",
                "Thứ Năm", "Thứ Sáu", "Thứ Bảy", "Chủ Nhật"
        };
        System.out.println("4.Hôm nay là: " + thuVN[today.getDayOfWeek().getValue() - 1]);

        // 5. 
        System.out.println("\n5.Các ngày trong tuần hiện tại:");
        LocalDate startWeek = today.with(DayOfWeek.MONDAY);
        for (int i = 0; i < 7; i++) {
            LocalDate d = startWeek.plusDays(i);
            System.out.println(d.format(formatter) + " " +
                    thuVN[d.getDayOfWeek().getValue() - 1]);
        }

        // 6. 
        System.out.println("\n6.Các ngày trong tháng hiện tại:");
        LocalDate firstDay = today.withDayOfMonth(1);
        for (int i = 0; i < daysInMonth; i++) {
            LocalDate d = firstDay.plusDays(i);
            System.out.println(d.format(formatter) + " " +
                    thuVN[d.getDayOfWeek().getValue() - 1]);
        }

        // 7.
        int sundayCount = 0;
        for (int i = 0; i < daysInMonth; i++) {
            LocalDate d = firstDay.plusDays(i);
            if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
                sundayCount++;
            }
        }
        System.out.println("\n7.Số ngày Chủ Nhật trong tháng: " + sundayCount);
		
	}
}
