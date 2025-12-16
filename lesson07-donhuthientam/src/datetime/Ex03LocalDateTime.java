package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex03 {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {

		Calendar c = Calendar.getInstance();
		Date date = c.getTime();

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

		System.out.println("1. gian hiện tại(dd/MM/yyy HH:mm:ss): " + df.format(date));

		System.out.println("\n======================\n");

		int lastDayOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		Calendar lastDay = clone(c);
		lastDay.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);

		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("2. In ngày cuối cùng của tháng hiện tại (dd/MM/yyyy): " + df1.format(lastDay.getTime()));

		System.out.println("\n======================\n");

		Calendar startOfWeek = clone(c);
		int firstDayOfWeek = startOfWeek.getFirstDayOfWeek();
		startOfWeek.add(Calendar.DAY_OF_MONTH, firstDayOfWeek - startOfWeek.get(Calendar.DAY_OF_WEEK));

		Calendar endOfWeek = clone(c);
		endOfWeek.add(Calendar.DAY_OF_MONTH, 7);

		System.out.println("3. Xem ngày đầu tiên và cuối cùng của tuần hiện tại: " + df1.format(startOfWeek.getTime()));
		System.out.println("3. Xem ngày đầu tiên và cuối cùng của tuần hiện tại: " + df1.format(endOfWeek.getTime()));

		System.out.println("\n======================\n");

		System.out.println("4. Xem ngày hiện tại đang ở tuần thứ mấy trong năm: " + c.get(Calendar.WEEK_OF_YEAR));

		System.out.println("\n======================\n");

		Calendar after = clone(c);
		after.add(Calendar.DAY_OF_MONTH, 20);

		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy EEEE");

		System.out.println("5. Kiểm tra sau 20 ngày nữa là ngày nào, thứ mấy: " + df2.format(after.getTime()));

		System.out.println("\n======================\n");

		System.out.println("6. Nhập vào ngày tháng năm sinh. Kiểm tra xem bạn đã sống được bao nhiêu ngày: ");
		getBirthOfDay(ip);

	}

	private static void getBirthOfDay(Scanner ip) throws ParseException {

		System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
		String s = ip.nextLine();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date birth = df.parse(s);

			Calendar now = Calendar.getInstance();
			Calendar nowClone = clone(now);

			long birthMillis = birth.getTime();
			long nowMillis = nowClone.getTimeInMillis();

			long result = nowMillis - birthMillis;

			long days = result / (1000L * 60 * 60 * 24);

			System.out.println("Bạn đã sống được khoảng: " + days + " ngày.");

		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Calendar clone(Calendar source) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(source.getTimeInMillis());
		return c;
	}

}
