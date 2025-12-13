package view.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import exception.InValidInputException;
import utils.DateTimeUtils;

import static utils.DateTimeUtils.*;
import static utils.ScannerUtils.*;

public class Ex03 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		do {
			getMenu();
			int choice = inputChoice(sc);
			switch (choice) {
			case 1:
				System.out.println("Nhập khu vực muốn xem: ");
				String area = sc.nextLine();
				System.out.println(getCurrentTimeInArea(area));
				break;
			case 2:
				System.out.println(getLastDayOfMonth(c));
				break;
			case 3:
				System.out.println(getFirstDayAndLastDayOfCurrentWeek(c));
				break;
			case 4:
				System.out.println(getCurrentWeekOfYear(c));
				break;
			case 5:
				System.out.println(getTime20DaysAfter(c));
				break;
			case 6:
				Calendar calendar = input6thRequest(sc, c);
				System.out.println(getDaysLived(c,calendar));
				break;
			case 0:
				System.out.println("Bye bye");
				return;
			default:
				System.out.println("Yêu cầu không hợp lệ");
				break;
			}
		} while (true);
	}

	private static void getMenu() {
		System.out.println("================ MENU =================");
		System.out.println("1. Xem thời gian hiện tại(dd/MM/yyyy HH:mm:ss) ở khu vực bất kỳ");
		System.out.println("2. In ngày cuối cùng của tháng hiện tại");
		System.out.println("3. Xem ngày đầu tiên và cuối cùng của tuần hiện tại");
		System.out.println("4. Xem ngày hiện tại đang ở tuần thứ mấy trong năm");
		System.out.println("5. Kiểm tra 20 ngày nữa là ngày nào, thứ mấy");
		System.out.println("6. Nhập vào ngày tháng năm sinh. Kiểm tra xem bạn đã sống được bao nhiêu ngày");
		System.out.println("0. Thoát chương trình");
		System.out.println("========================================");
	}

	private static int inputChoice(Scanner sc) {
		do {
			System.out.println("Xin mời nhập lựa chọn phù hợp");
			try {
				int choice = Integer.parseInt(sc.nextLine());
				return choice;
			} catch (NumberFormatException ex) {
				System.out.println("Vui lòng nhập đúng định dạng lựa chọn là số");
			}
		} while (true);
	}

	private static Calendar input6thRequest(Scanner sc, Calendar cal) {
		int day = 0, year = 0, month = 0;
		Calendar c = (Calendar) cal.clone();
		try {
			System.out.println("Xin mời nhập ngày sinh: ");
			String dayString = sc.nextLine();

			System.out.println("Xin mời nhập tháng sinh: ");
			String monthString = sc.nextLine();

			System.out.println("Xin mời năm sinh: ");
			String yearString = sc.nextLine();

			if (isValidInputEx02(dayString, monthString, yearString)) {
				day = Integer.parseInt(dayString);
				month = Integer.parseInt(monthString);
				year = Integer.parseInt(yearString);
			}
			c.set(year, month - 1, day);
		} catch (InValidInputException ex) {
			System.out.println(ex.getMessages());
		}
		return c;
	}
}
