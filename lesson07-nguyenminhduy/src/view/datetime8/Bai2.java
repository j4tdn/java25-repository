package view.datetime8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class Bai2 {
	
	public static void showInfor() {
		 Scanner sc = new Scanner(System.in);
	     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	     
	     System.out.println("Nhập ngày: ");
	     LocalDate date = LocalDate.parse(sc.nextLine().trim(), dtf);
	     
	     System.out.println("Thứ: " + date.getDayOfWeek()
	     				+ "\nNgày thứ " + date.getDayOfYear() + " trong năm"
	     				+ "\nTuần thứ " + date.get(WeekFields.of(Locale.getDefault()).weekOfYear())
	     				+ "\nTháng có " + date.lengthOfMonth() + " ngày");
	}
	public static void main(String[] args) {
		showInfor();
	}

}
