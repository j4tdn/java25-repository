package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Bai2 {
	
	public static void showInfo(String input) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date =  sdf.parse(input);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			System.out.println("Hôm nay là thứ : " + new SimpleDateFormat("EEEE").format(date));
			System.out.println("Ngày thứ: " + cal.get(Calendar.DAY_OF_YEAR) + " của năm");
			System.out.println("Tuần thứ: " + cal.get(Calendar.WEEK_OF_YEAR));
			System.out.println("Tháng có " + cal.getActualMaximum(Calendar.DAY_OF_MONTH) + " ngày");
		}catch(Exception e) {
			System.out.println("Ngày không hợp lệ");
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập ngày: ");
		showInfo(sc.nextLine());
	}

}
