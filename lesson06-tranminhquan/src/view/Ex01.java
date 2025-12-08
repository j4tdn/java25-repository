package view;

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = 0, b = 0;

        do {
            try {
                System.out.print("Nhập a = ");
                a = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập b = ");
                b = Double.parseDouble(sc.nextLine());

                if (a == 0 || b == 0) {
                    throw new ArithmeticException("a và b phải khác 0");
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            } catch (ArithmeticException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }

        } while (true);

        double x = -b / a;
        System.out.println("x = " + x);
    }
}
