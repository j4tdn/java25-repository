package utils;

import java.util.ArrayList;
import java.util.List;

import exception.InValidInputException;

public class ScannerUtils {

	public static boolean isValidInputEx02(String day, String month, String year) {
		List<String> errors = new ArrayList<String>();
		
		if(day.isEmpty() || day == null) {
			errors.add("Ngày sinh không được để trống");
		}
		
		if(month.isEmpty() || month == null) {
			errors.add("Tháng sinh không được để trống");
		}
		
		if(year.isEmpty() || year == null) {
			errors.add("Năm sinh không được để trống");
		}
		
		if(isAlpha(day)) {
			errors.add("Ngày sinh không được nhập kí tự");
		}
		
		if(isAlpha(month)) {
			errors.add("Tháng sinh không được nhập kí tự");
		}
		
		if(isAlpha(year)) {
			errors.add("Năm sinh không được nhập kí tự");
		}
		
		if(!errors.isEmpty()) {
			throw new InValidInputException(errors);
		}else {
			return true;
		}

	}
	
	private static boolean isAlpha(String time) {
		for(int i = 0;i<time.length();++i) {
			Character c = time.charAt(i);
			if(Character.isAlphabetic(c)) {
				return true;
			}
		}
		return false;
	}

}
