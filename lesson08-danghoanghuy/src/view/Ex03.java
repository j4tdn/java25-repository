package view;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		System.out.print("Nhap chuoi: ");
		String ip = sc.nextLine();
		
		String resulft = removeAccent(ip);
		System.out.println(resulft);
			
			sc.close();
	}
	
	private static String removeAccent(String result) {
		
		result = result.replaceAll("[àáạảãâầấậẩẫăằắặẳẵ]", "a");
	    result = result.replaceAll("[ÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴ]", "A");
	    result = result.replaceAll("[èéẹẻẽêềếệểễ]", "e");
	    result = result.replaceAll("[ÈÉẸẺẼÊỀẾỆỂỄ]", "E");
	    result = result.replaceAll("[òóọỏõôồốộổỗơờớợởỡ]", "o");
	    result = result.replaceAll("[ÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠ]", "O");
	    result = result.replaceAll("[ùúụủũưừứựửữ]", "u");
	    result = result.replaceAll("[ìíịỉĩ]", "i");
	    result = result.replaceAll("[ỳýỵỷỹ]", "y");
	    result = result.replaceAll("[đ]", "d");
	    result = result.replaceAll("[Đ]", "D");
	    
	    return result;
		
	}
	
}
