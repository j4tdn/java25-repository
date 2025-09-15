package view;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Ex06MinMax {
	public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int a = 0, b = 0, c = 0;

        a = scanner(ip, "Nhập số nguyên nhỏ hơn 20 a = ");
        b = scanner(ip, "Nhập số nguyên nhỏ hơn 20 b = ");
        c = scanner(ip, "Nhập số nguyên nhỏ hơn 20 c = ");

        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);

        System.out.println("Số lớn nhất là " + max);
        System.out.println("Số nhỏ nhất là " + min);

        ip.close();
    }

    public static int scanner(Scanner ip, String message) {
        int n = 0;
        boolean hopLe = false;

        while (!hopLe) {
            System.out.print(message);
            try {
                n = ip.nextInt();
                if (n >= 0 && n < 20) {
                    hopLe = true;
                } else {
                    System.out.println("Giá trị phải trong khoảng [0, 20). Vui lòng nhập lại!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập số nguyên!");
                ip.next(); 
            }
        }
        return n;
    }
}
