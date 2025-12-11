package datetime;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Ex01UltimateRelationshipCalculator {
	
	private static Scanner ip = new Scanner(System.in);
	
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		try {
			Locale.setDefault(new Locale("vi", "VN"));
			
	        System.out.println("=== The Ultimate Relationship Calculator ===");
	        Calendar start = readCalendar("Nhập thời gian bắt đầu hẹn hò(yyyy-MM-dd HH:mm:ss): ");

	        Calendar end = readCalendar("Nếu đã chia tay, nhập ngày chia tay(yyyy-MM-dd HH:mm:ss): ");

	        if (end.before(start)) {
	        	throw new IOException("Ngày kết thúc phải sau ngày bắt đầu.");
	        }

	        String startWeekday = getDayOfWeeksInVnmese(start.get(Calendar.DAY_OF_WEEK));

	        Calendar cur = clone(start);
	        Calendar target = clone(end);

	        int years = 0, months = 0, days = 0, hours = 0, minutes = 0, seconds = 0;

	        while (true) {
	            Calendar next = clone(cur);
	            next.add(Calendar.YEAR, 1);
	            if (next.compareTo(target) <= 0) { 
	            	cur = next; years++; 
	            } else { 
	            	break; 
	            }
	        }

	        while (true) {
	            Calendar next = clone(cur);
	            next.add(Calendar.MONTH, 1);
	            if (next.compareTo(target) <= 0) { 
	            	cur = next; months++; 
	            } else { 
	            	break; 
	            }
	        }

	        while (true) {
	            Calendar next = clone(cur);
	            next.add(Calendar.DAY_OF_MONTH, 1);
	            if (next.compareTo(target) <= 0) { 
	            	cur = next; days++; 
	            } else { 
	            	break; 
	            }
	        }

	        while (true) {
	            Calendar next = clone(cur);
	            next.add(Calendar.HOUR_OF_DAY, 1);
	            if (next.compareTo(target) <= 0) { 
	            	cur = next; hours++; 
	            } else { 
	            	break; 
	            }
	        }

	        while (true) {
	        	Calendar next = clone(cur);
	            next.add(Calendar.MINUTE, 1);
	            if (next.compareTo(target) <= 0) { 
	            	cur = next; minutes++; 
	            } else { 
	            	break; 
	            }
	        }

	        while (true) {
	        	Calendar next = clone(cur);
	            next.add(Calendar.SECOND, 1);
	            if (next.compareTo(target) <= 0) { 
	            	cur = next; seconds++; 
	            } else { 
	            	break; 
	            }
	        }

	        System.out.println("\nKết quả:");
	        System.out.println("- Ngày bắt đầu hẹn hò: " + df.format(start.getTime()) + " (" + startWeekday + ")");
	        System.out.println("- Nếu đã chia tay/ngày kết thúc: " + df.format(end.getTime()));
	        System.out.println("- Thời gian mối tình: "
	                + years + " năm, "
	                + months + " tháng, "
	                + days + " ngày, "
	                + hours + " giờ, "
	                + minutes + " phút, "
	                + seconds + " giây");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ip.close();
		}
		
	}
	
	private static Calendar readCalendar(String message) throws ParseException {
        System.out.print(message);
        String text = ip.nextLine();
        Calendar cal = Calendar.getInstance();
        try {
			cal.setTime(df.parse(text));
		} catch (ParseException e) {
			throw e;
		}
        return cal;
    }
	
	private static Calendar clone(Calendar source) {
		Calendar target = Calendar.getInstance(); 
		target.setTimeInMillis(source.getTimeInMillis());
		return target;
	}
	
	private static String getDayOfWeeksInVnmese(int dayOfWeek) {
		String[] dayOfWeeks = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
		return  dayOfWeeks[dayOfWeek-1];
		
	}
	
	
}
