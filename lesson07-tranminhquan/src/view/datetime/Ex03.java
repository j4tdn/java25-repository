package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * Bài 3: Viết chương trình, mỗi chức năng một phương thức
1. Xem thời gian hiện tại(dd/MM/yyy HH:mm:ss) ở khu vực bất kỳ.
2. In ngày cuối cùng của tháng hiện tại (dd/MM/yyyy).
3. Xem ngày đầu tiên và cuối cùng của tuần hiện tại.
4. Xem ngày hiện tại đang ở tuần thứ mấy trong năm.
5. Kiểm tra sau 20 ngày nữa là ngày nào, thứ mấy.
6. Nhập vào ngày tháng năm sinh. Kiểm tra xem bạn đã sống được bao nhiêu ngày.
 */
public class Ex03 {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy" );
	
	public static void main(String[] args) {
		timeNow();
		lastDayOfMonth();
		firstAndLastDayOfWeek();
		weekOfYear();
		after20Days();
		liveDay();
	}
	static void timeNow() {
		Date now = new Date();
		System.out.println("1. Thời gian hiện tại : " + sdf.format(now));
	}
	static void lastDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("2. Ngày cuối tháng : " + sdfDate.format(cal.getTime()));
	}
	static void firstAndLastDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		Date firsDay = cal.getTime();

		cal.add(Calendar.DAY_OF_WEEK, 6);
		Date lastDay = cal.getTime();
		
		System.out.println("3. Đầu tuần là : " + sdfDate.format(firsDay) + " và cuối tuần là : " + sdfDate.format(lastDay));
	}
	static void weekOfYear() {
		Calendar cal = Calendar.getInstance();
		
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		
		System.out.println("4. Tuần thứ : " + week);
	}
	static void after20Days() {
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DAY_OF_MONTH, 20);
		String[] days = {"Chủ Nhật", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7"};
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("5. 20 ngày sau là : " + sdfDate.format(cal.getTime()) + " " + days[dayOfWeek - 1]);
	}
	static void liveDay() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("6. Nhập ngày sinh(đ/MM/yyyy): ");
			Date birthDay = sdfDate.parse(sc.nextLine());
			
			Date now = new Date();
			long instance = now.getTime() - birthDay.getTime(); // miliS
			long days = instance / (1000*60*60*24);
			System.out.println("Đã sống đc " + days + " ngày");
		} catch (Exception e) {
			System.out.println("Ngày sinh sai");
		}
	}
}
