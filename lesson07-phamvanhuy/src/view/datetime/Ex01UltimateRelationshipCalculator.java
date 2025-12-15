package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex01UltimateRelationshipCalculator {
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Nhập thời gian bắt đầu hẹn hò(dd/MM/yyyy HH:mm:ss): ");
			String start = sc.nextLine();
			Date startDate = sdf.parse(start);

			System.out.println("Hai bạn đã chia tay chưa (y/n): ");
			String choice = sc.nextLine();
			
			Date edate;
			if(choice.equalsIgnoreCase("y")) {
				System.out.println("Nhập thời gian chia tay(dd/MM/yyyy HH:mm:ss): ");
				String end = sc.nextLine();
				edate = sdf.parse(end);
			}else {
				edate = new Date();
			}
			
			SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
			System.out.println("Ngày bắt đầu hẹn hò là: " + dayFormat.format(startDate));

			 long diff = edate.getTime() - startDate.getTime();

	            long seconds = diff / 1000 % 60;
	            long minutes = diff / (1000 * 60) % 60;
	            long hours = diff / (1000 * 60 * 60) % 24;
	            long days = diff / (1000 * 60 * 60 * 24);

	            long months = days / 30;   
	            long years = months / 12;

	            months = months % 12;
	            days = days % 30;
	            
	            System.out.println("Hai bạn đã yêu được:");
	            System.out.println(years + " năm, " +
	                               months + " tháng, " +
	                               days + " ngày, " +
	                               hours + " giờ, " +
	                               minutes + " phút, " +
	                               seconds + " giây.");
		} catch (Exception e) {
			System.out.println("Sai định dạng ngày giờ nhập đúng dd/MM/yyyy HH:mm:ss");	
		}

	}
}
