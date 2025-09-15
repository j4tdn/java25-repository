package view;
import java.util.Scanner;
public class Ex02Power {
	public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int a = 5; 
        int N = 0;
        boolean i = false;

        
        while (a > 0) {
            System.out.print("Nhập số nguyên dương N: ");
            try {
                N = Integer.parseInt(ip.nextLine());

                if (N <= 0) {
                    throw new NumberFormatException(); 
                }

                
                if (N > 0 && (N&(N-1)) == 0) {
                    i = true;
                    System.out.println("true");
                    break; 
                } else {
                    System.out.println("false");
                }

            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại");
            }

            a--; 
        }

        if (!i && a == 0) {
            System.out.println("Bạn đã nhập sai quá nhiều lần!");
        }

        ip.close();
    }
}
