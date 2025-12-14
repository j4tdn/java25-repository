package viewdatatime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex03 {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
		//Calendar c = Calendar.getInstance(new Locale("vi","VN"));
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		System.out.println("1. Xem thời gian hiện tại(dd/MM/yyy HH:mm:ss) ở khu vực bất kỳ.: " + df1.format(date));
		System.out.println("\n=======================================");
		
		
		int lastDayOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		Calendar lastDay = clone(c);
		lastDay.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);
		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("2. In ngày cuối cùng của tháng hiện tại (dd/MM/yyyy): " + df2.format(lastDay.getTime()));
		System.out.println("\n=======================================");

		
		c.setFirstDayOfWeek(Calendar.MONDAY);

		Calendar startDayOfWeek = clone(c);
		int diff = startDayOfWeek.get(Calendar.DAY_OF_WEEK) - startDayOfWeek.getFirstDayOfWeek();
		if (diff < 0) diff = diff + 7;
		startDayOfWeek.add(Calendar.DAY_OF_MONTH, -diff);

		Calendar endOfWeek = clone(startDayOfWeek);
		endOfWeek.add(Calendar.DAY_OF_MONTH, 6);

		System.out.println("3. Xem ngày đầu tiên của tuần hiện tại: " + df2.format(startDayOfWeek.getTime()));
		System.out.println("3. Xem ngày cuối cùng của tuần hiện tại: " + df2.format(endOfWeek.getTime()));
		System.out.println("\n=======================================");

		System.out.println("4. Xem ngày hiện tại đang ở tuần thứ mấy trong năm: " + c.get(Calendar.WEEK_OF_YEAR));

		System.out.println("\n=======================================");

		Calendar after20day = clone(c);
		after20day.add(Calendar.DAY_OF_MONTH, 20);

		SimpleDateFormat df3 = new SimpleDateFormat("dd/MM/yyyy EEEE");

		System.out.println("5. Kiểm tra sau 20 ngày nữa là ngày nào, thứ mấy: " + df3.format(after20day.getTime()));

		System.out.println("\n=======================================");

		System.out.println("6. Nhập vào ngày tháng năm sinh. Kiểm tra xem bạn đã sống được bao nhiêu ngày: ");
		getBirthOfDay(ip);

	}

	
	private static void getBirthOfDay(Scanner ip) throws ParseException {

		System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String s = ip.nextLine();
		

		try {
			Date birth = df.parse(s);

			Calendar inputday = Calendar.getInstance();
			Calendar daynow = clone(inputday);

			long birthDay = birth.getTime();
			long now = daynow.getTimeInMillis();

			long result = now - birthDay;

			long days = result / (1000L * 60 * 60 * 24);

			System.out.println("Bạn đã sống được khoảng: " + days + " ngày.");

		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Calendar clone(Calendar source) {
	    Calendar c = Calendar.getInstance();
	    c.setFirstDayOfWeek(source.getFirstDayOfWeek());
	    c.setTimeInMillis(source.getTimeInMillis());
	    return c;
	}

}