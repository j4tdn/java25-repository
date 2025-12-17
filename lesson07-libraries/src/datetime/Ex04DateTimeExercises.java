package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ex04DateTimeExercises {
/*
 * 1. In thông tin ngày tháng năm với DateFormatter
2. Tháng, năm hiên tai có bao nhiêu ngày
3. Kiếm tra năm hiên tai có phải là năm nhuân không( sử dụng hàm isLeaf())
4. Ngày hiên tai là ngày thứ mấy, in ra ngày theo tiếng viêt
5. In thông tin các ngày trong tháng, tuần hiên tai dd/MM/wwwy week_day
6. Đếm xem trong tháng có bao nhiêu ngày chủ nhật và in ra
 */
	public static void main(String[] args) {
		ex01();
		ex02();
		ex03();
	}
	public static void ex01() {
		LocalDate today =LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(today.format(dtf));
	}
	public static void ex02() {
		int year = Year.now().getValue();
		if(Year.isLeap(year)) {
			System.out.println(year + " Là năm nhuan ");
		}else {
			System.out.println(year + " Khong phai nam nhuan ");
		}		
	}
	
	public static void ex03() {
		LocalDate today = LocalDate.now();
		DayOfWeek dow = today.getDayOfWeek();
		String thuVn = " ";
		switch (dow) {
		case MONDAY: {			
			thuVn = "Thu hai";
		}case TUESDAY: {
			
			thuVn = "Thu ba";
		}case WEDNESDAY: {
			
			thuVn = "Thu tu";
		}case THURSDAY: {
			
			thuVn = "Thu nam";
		}case FRIDAY: {
			
			thuVn = "Thu sau";
		}case SATURDAY: {
			
			thuVn = "Thu bay";
		}case SUNDAY: {
			
			thuVn = "Chu nhat";
		};
		System.out.println(thuVn);
		
	}
}}
