package datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Ex03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Xem thoi gian hien tai o khu vuc bat ky");
			System.out.println("2. In ngay cuoi cung cua thang hien tai");
			System.out.println("3. Xem ngay dau tien va cuoi cung cua tuan hien tai");
			System.out.println("4. Xem ngay hien tai dang o tuan thu may trong nam");
			System.out.println("5. Kiem tra sau 20 ngay nua la ngay nao, thu may");
			System.out.println("6. Nhap ngay sinh, kiem tra da song duoc bao nhieu ngay");
			System.out.println("0. Thoat");
			System.out.print("Chon chuc nang: ");

			choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
				showCurrentTimeByZone(sc);
				break;
			case 2:
				printLastDayOfMonth();
				break;
			case 3:
				printFirstAndLastDayOfWeek();
				break;
			case 4:
				printWeekOfYear();
				break;
			case 5:
				checkAfter20Days();
				break;
			case 6:
				calculateDaysLived(sc);
				break;
			case 0:
				System.out.println("Ket thuc chuong trinh.");
				break;
			default:
				System.out.println("Lua chon khong hop le!");
			}

		} while (choice != 0);
	}

	// case 1
	public static void showCurrentTimeByZone(Scanner sc) {
		System.out.print("Nhap TimeZone (vd: Asia/Tokyo, Europe/London): ");
		String zone = sc.nextLine();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone(zone));

		System.out.println("Thoi gian hien tai: " + sdf.format(new Date()));
	}

	// case 2
	public static void printLastDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, lastDay);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Ngay cuoi cung cua thang: " + sdf.format(cal.getTime()));
	}

	// case 3
	public static void printFirstAndLastDayOfWeek() {
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Date firstDay = cal.getTime();

		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		Date lastDay = cal.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Ngay dau tuan: " + sdf.format(firstDay));
		System.out.println("Ngay cuoi tuan: " + sdf.format(lastDay));
	}

	// case 4
	public static void printWeekOfYear() {
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		System.out.println("Tuan hien tai la tuan thu: " + week);
	}

	// case 5
	public static void checkAfter20Days() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 20);

		String[] weekdays = { "Chu nhat", "Thu 2", "Thu 3", "Thu 4", "Thu 5", "Thu 6", "Thu 7" };

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Sau 20 ngay nua la ngay: " + sdf.format(cal.getTime()));
		System.out.println("Thu: " + weekdays[cal.get(Calendar.DAY_OF_WEEK) - 1]);
	}

	// case 6
	public static void calculateDaysLived(Scanner sc) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = null;

		while (true) {
			try {
				System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
				birthDate = sdf.parse(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Sai dinh dang ngay. Hay nhap lai!");
			}
		}

		long diffMillis = new Date().getTime() - birthDate.getTime();
		long days = diffMillis / (1000 * 60 * 60 * 24);

		System.out.println("Ban da song duoc " + days + " ngay");
	}
}
