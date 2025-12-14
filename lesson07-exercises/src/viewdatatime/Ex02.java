package viewdatatime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex02 {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner ip = new Scanner(System.in);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		
			
			System.out.print("Nhập ngày tháng năm (dd/MM/yyyy): ");
			String day = ip.nextLine();
			Date date = df.parse(day);
			
			Calendar c = Calendar.getInstance();
			
			c.setTime(date);
			
			System.out.println(day + " là " + getDayOfWeeksInVnmese(c.get(Calendar.DAY_OF_WEEK)));
			
			int finalday = c.getActualMaximum(Calendar.DAY_OF_YEAR)-c.get(Calendar.DAY_OF_YEAR);
			
			System.out.println("Là ngày số  " + c.get(Calendar.DAY_OF_YEAR) + ", " + finalday + " ngày nửa hết năm.");
			
			System.out.println("Năm " + c.get(Calendar.YEAR) + " có " + c.getActualMaximum(Calendar.DAY_OF_YEAR) + " ngày.");
			
			System.out.println("Tháng " + (c.get(Calendar.MONTH) + 1) + " năm " + c.get(Calendar.YEAR) + " có " + c.getActualMaximum(Calendar.DAY_OF_MONTH) + " ngày.");
			
		
		
		
		ip.close();
		
	}
	
	private static String getDayOfWeeksInVnmese(int dayOfWeek) {
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
		return  dayOfWeeks[dayOfWeek-1];
	}
	
}