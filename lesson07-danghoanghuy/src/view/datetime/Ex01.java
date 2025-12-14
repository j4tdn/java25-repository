package view.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex01 {
	
	/*
		 Xây dựng ứng dụng The Ultimate Relationship Calculator
	▪ Nhập thời gian bắt đầu hẹn hò của 2 người.
	▪ Nếu đã chia tay, nhập ngày chia tay ngược lại lấy thời gian hiện tại
	▪ Nhấn Enter để thực hiện tính toán → Hỏi
	▪ Ngày bắt đầu hẹn họ là ngày thứ mấy.
	▪ Mối tình đã bắt đầu được bao nhiêu năm, tháng, ngày, giờ, phút, giây
	 */

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		try {
			System.out.println("Nhap ngay hen ho(dd/MM/yyyy HH:mm:ss): ");
			String startDayStr = ip.nextLine();
			Date startDay = df.parse(startDayStr);
			
			System.out.println("Chia tay chua???? y/n");
			String isBrokenup = ip.nextLine();
			
			System.out.println("Ngay bat dau hen ho: " + df.format(startDay));
			
			if(isBrokenup.equalsIgnoreCase("y")) {
				System.out.println("Nhap ngay chia tay(dd/MM/yyyy HH:mm:ss): ");
				String endDayStr = ip.nextLine();
				Date endDay = df.parse(endDayStr);
				
				Calendar calStart = Calendar.getInstance();
				calStart.setTime(startDay);
				
				Calendar calEnd = Calendar.getInstance();
				calEnd.setTime(endDay);
				
				long time = calEnd.getTimeInMillis() - calStart.getTimeInMillis();
				long hour = time / (1000 * 60 * 60) % 24;
				long minute = time / (1000 * 60) % 60;
				long second = time / 1000 % 60;
				
				int year = 0;
				int month = 0;
				int day = 0;
				
				while(true) {
					calStart.add(Calendar.YEAR, 1);
					if(calStart.getTimeInMillis() > calEnd.getTimeInMillis()) {
						calStart.add(Calendar.YEAR, -1);
						break;
					}
					year++;
				}
				
				while(true) {
					calStart.add(Calendar.MONTH, 1);
					if(calStart.getTimeInMillis() > calEnd.getTimeInMillis()) {
						calStart.add(Calendar.MONTH, -1);
						break;
					}
					month++;
				}
				
				while(true) {
					calStart.add(Calendar.DAY_OF_MONTH, 1);
					if(calStart.getTimeInMillis() > calEnd.getTimeInMillis()) {
						calStart.add(Calendar.DAY_OF_MONTH, -1);
						break;
					}
					day++;
				}
				
				System.out.printf("Moi tinh bat dau dc: %s nam, %s thang, %s ngay, %s gio, %s phut, %s giay ", year, month, day, hour, minute, second);
			}
			
			else System.out.println("Ngay hien tai: " + df.format(date));
			
		} catch (ParseException e) {
			System.out.println("Sai dinh dang");
		}
		
		ip.close();
	}
	
	
}
