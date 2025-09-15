package hoten.lesson02;
import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tự nhiên N: ");
        int N = scanner.nextInt();

        if (N < 0) {
            System.out.println("N phải là số không âm.");
        } else {
            String binary = Integer.toBinaryString(N);
            System.out.println("Số nhị phân của " + N + " là: " + binary);
        }

        scanner.close();
    }
}