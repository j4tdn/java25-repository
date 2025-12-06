package view;

import java.util.Scanner;

import static util.ValidateUtils.*;

public class Ex04ReadNumber {
	
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			String text = readNumber("Nhập vào 1 số có 3 chữ số: ");
			System.out.println("Dạng chữ ==> " + text);
		} catch (NumberFormatException ex) {
			
		} finally {
			ip.close();
		}
	}
	
	public static String readNumber(String message) {
		String text = null;
		int number = 0;
		do {
			System.out.print(message);
			text = ip.nextLine();
			StringBuilder result = new StringBuilder();
			if(text.length() <= 3 && isValidNumber(text)) {
				try {
					number = Integer.parseInt(text);
					if (number == 0) {
						return "Không";
					}
					
					int hundred = number / 100;
			        int ten = (number / 10) % 10;
			        int unit = number % 10;      
			        if (hundred > 0) {
			        	result.append(readDigit(hundred)).append(" trăm");
			            if (ten == 0 && unit > 0) {
			            	result.append(" linh ");
			            } else {
			            	result.append(" ");
			            }
			        }		        
			        if (ten > 0) {
			            if (ten == 1) {
			            	result.append("mười");
			            } else {
			            	result.append(readDigit(ten)).append(" mươi");
			            }
			            if (unit != 0) {
			            	result.append(" ");
			            }
			        }
			        if (unit > 0) {
			            if (ten >= 1) {
			                if (unit == 1 && ten >= 2) {
			                	result.append("mốt");
			                } else if (unit == 5) {
			                	result.append("lăm");
			                } else {
			                	result.append(readDigit(unit));
			                }
			            } else {
			            	result.append(readDigit(unit));
			            }
			        }
			        
			        return result.toString().trim();
				} catch(NumberFormatException ex) {
					throw ex;
				}			
			} else {
				throw new NumberFormatException("Định dạng số không hợp lệ");
			}
		} while(true);
		
	}
	
	 private static String readDigit(int digit) {
		 switch(digit) {
			 case 0: return "Không";
	         case 1: return "Một";
	         case 2: return "Hai";
	         case 3: return "Ba";
	         case 4: return "Bốn";
	         case 5: return "Năm";
	         case 6: return "Sáu";
	         case 7: return "Bảy";
	         case 8: return "Tám";
	         case 9: return "Chín";
	         default: throw new NumberFormatException("Định dạng số không hợp lệ");
		 }
	 }
	
}
