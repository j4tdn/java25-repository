package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex01 {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
		getDate(ip);
	}

	private static void getDate(Scanner ip) throws ParseException {

		try {
			System.out.print("Ngày bắt đầu hẹn họ là ngày thứ mấy (dd/MM/yyyy hh:mm:ss): ");
			String s = ip.nextLine();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date firstDate = df.parse(s);

			Calendar start = Calendar.getInstance();
			start.setTime(firstDate);
			start = clone(start);

			System.out.print("Đã chia tay chưa? (y/n): ");
			String choice = ip.nextLine();

			Calendar end;
			if (choice.equalsIgnoreCase("y")) {
				System.out.println("Nhập ngày chia tay: ");
				String endDate = ip.nextLine();
				Date date = df.parse(endDate);

				end = Calendar.getInstance();
				end.setTime(date);
				end = clone(end);
			} else {
				end = Calendar.getInstance();
			}

			Calendar temp = clone(start);

			int years = countTime(temp, end, Calendar.YEAR);
			int months = countTime(temp, end, Calendar.MONTH);
			int days = countTime(temp, end, Calendar.DAY_OF_MONTH);
			int hours = countTime(temp, end, Calendar.HOUR_OF_DAY);
			int minutes = countTime(temp, end, Calendar.MINUTE);
			int seconds = countTime(temp, end, Calendar.SECOND);

			System.out.println("Mối tình đã bắt đầu được" + years + " năm, " + months + " tháng, " + days + " ngày, " + hours + " giờ, " + minutes
					+ " phút, " + seconds + " giây.");

		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}

	private static int countTime(Calendar temp, Calendar end, int field) {
		int count = 0;
		while (true) {
			Calendar c = clone(temp);
			c.add(field, 1);
			if (c.after(end)) {
				break;
			}
			temp.add(field, 1);
			count++;
		}
		return count;
	}

	private static Calendar clone(Calendar source) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(source.getTimeInMillis());
		return c;
	}

}
