package view;

import java.util.Scanner;

public class Ex06IoValidation {
	 public static void main(String[] args) {
	        Scanner ip = new Scanner(System.in);
	        String text;
	        int wrongTimes = 0;
	        do {
	            System.out.print("Nhập vào một số nguyên: ");
	            text = ip.nextLine();
	            if (isValidText(text)) {
	                break;
	            }
	            if (++wrongTimes == 4) {
	                System.out.println("Số lần nhập sai vượt quá 3 lần, thoát");
	                ip.close();
	                return;
	            }
	            System.out.printf("Chưa phải là số hợp lệ(lần %s)\n\n", wrongTimes);

	        } while(true);

	        int number = Integer.parseInt(text);

	        System.out.println("Giá trị hợp lệ: " + number);

	        ip.close();

	        // Về nhà: toán tử && || làm các bài ++ -- trong slide
	        //      : xem video mảng, enum
	    }

	    private static boolean isValidText(String text) {
	        for (int i = 0; i < text.length(); i++) {
	            if (!Character.isDigit(text.charAt(i))) {
	                return false;
	            }
	        }
	        return true;
	    }
}
