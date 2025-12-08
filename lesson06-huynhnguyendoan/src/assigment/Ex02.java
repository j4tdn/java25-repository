package assigment;

import java.util.Scanner;


public class Ex02 extends PasswordUtils {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int maxCount = 5;
        
        while (count < maxCount) {
            try {
                System.out.print("Nhap mat khau: ");
                String password = sc.nextLine();
                
                validatePassword(password);
                System.out.println("Mat khau hop le! Tao mat khau thanh cong!");
                return;
            } 
            catch (PasswordException ex) {
                System.out.println("Loi: " + ex.getMessage());
                count++;
                System.out.println("Ban con " + (maxCount - count) + " lan thu lai.\n");
            }
        }
        
        System.out.println("Qua so lan thu, vui long thu lai sau!");
        sc.close();
    }
}
