package hoten.lesson02;
import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int N = -1;

        while (true) {
            System.out.print("Nhập số nguyên dương có ít nhất 2 chữ số: ");
            input = scanner.nextLine();

            if (input.matches("\\d{2,}")) {
                N = Integer.parseInt(input);
                break;
            } else {
                System.out.println(" Giá trị không hợp lệ. Vui lòng nhập lại.");
            }
        }

        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equals(reversed)) {
            System.out.println(N + " là số đối xứng ");
        } else {
            System.out.println(N + " không phải là số đối xứng ");
        }

        scanner.close();
    }
}