package view.datetime;

import java.util.Calendar;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập ngày: ");
		int day = sc.nextInt();
		
		System.out.println("Nhập tháng: ");
		int month = sc.nextInt();
		
		System.out.println("Nhập năm: ");
		int year = sc.nextInt();
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day); // calendar bắt đầu từ 0
		
		// Thứ
		String[] days = {"Chủ Nhật", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7"};
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		// Ngày trong năm
		int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		
		// Số ngày trong tháng
		int dayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		// Năm nhuận
		boolean isLeapYear = isLeapYear(year);
		
		System.out.println("Ngày này trúng vào thứ: " + days[dayOfWeek - 1]);
		System.out.println("Ngày này là ngày thứ " + dayOfYear + " trong năm");
		System.out.println("Tháng này có " + dayOfMonth + " ngày");
		System.out.println("Năm này " + (isLeapYear ? "là năm nhuận":"k phải năm nhuận"  ));
	}
	static boolean isLeapYear(int year) {
		if (year % 400 == 0) return true;
		if (year % 100 == 0) return false;
		return year % 4 == 0;
	}
}
