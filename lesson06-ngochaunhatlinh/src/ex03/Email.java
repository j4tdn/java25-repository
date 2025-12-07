package ex03;

import java.util.Scanner;


public class Email {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = "";

        while (true) {
            System.out.print("Nhập địa chỉ email: ");
            email = sc.nextLine();

            if (isValidEmail(email)) {
                System.out.println(" Email hợp lệ: " + email);
                break;
            } else {
                System.out.println("Email không hợp lệ. Vui lòng nhập lại.\n");
            }
        }

        sc.close();
    }

    public static boolean isValidEmail(String email) {
        
       String s = "^[a-zA-Z0-9]+([._-][a-zA-Z0-9]+)*@"
               + "[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$";
        return email.matches(s);
    }

}
