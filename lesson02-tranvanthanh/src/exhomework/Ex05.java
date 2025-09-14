package exhomework;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		int a = Input();
		int number = a;
		long rev = 0;   
		while (number > 0) {
	        long digit = number % 10;
	        rev = rev * 10 + digit;               
	        number = number/ 10;
	    }
		if(rev == a) {
	  System.out.println( a +" là số đối xứng");
		}else  System.out.println( a +" không phải là số đối xứng");
		
	}
    public static int Input() {
        Scanner ip = new Scanner(System.in);
        String text;
        int wrongTimes = 0;

        while (true) {
            System.out.print("Nhập 1 số nguyên dương: ");
            text = ip.nextLine();

            if (check(text)) {
                int number = Integer.parseInt(text);
                if (number >=10) {
                    return number;
                }
            }

            wrongTimes++;
            if (wrongTimes == 5) {
                System.out.println("Số lần nhập sai vượt quá 5 lần. Thoát.");
                ip.close();
                return wrongTimes;
            }
            System.out.printf("Chưa phải là số nguyên dương hợp lệ (lần %d)%n%n", wrongTimes);
        }
    }

    private static boolean check(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}