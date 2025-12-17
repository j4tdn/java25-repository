package view.datetime8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Bai1 {
	
	public static void daylove() {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
		
		System.out.println("Nhập thời gian bắt đầu yêu: ");
		 String input = sc.nextLine().trim();
		 
		LocalDate bd = LocalDate.parse(input, dtf);
		LocalDate now = LocalDate.now();
		
		long day = ChronoUnit.DAYS.between(bd, now);
		System.out.println("Đã yêu được " + day + " ngày");
		
	}
	
	public static void main(String[] args) {
		daylove();
		
	}	

}
