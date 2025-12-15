package view.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Bai1 {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static void timelove(Date start) {
		Date now = new Date();
		long diff = now.getTime() - start.getTime();
		
		long seconds = diff / 1000 % 60;
		long minutes = diff / (1000 * 60) % 60;
		long hours = diff / (1000 * 60 * 60) % 24;
		long days = diff / (1000 * 60 * 60 * 24) ;
		long months = days  / 30;
		long years = months / 12;
		
		System.out.println("Hai bạn đã yêu được: " + years + " năm, " + (months % 12) + " Tháng, " + (days % 30) + " Ngày, " + hours +" giờ, " + minutes + " phút, " + seconds + " giây.");
	}
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập thời gian bắt đầu quen: ");
		Date start = sdf.parse(sc.nextLine());
		timelove(start);
		
		
	}

}
