package exercises;

import java.util.Random;

public class Bai4 {

    public static void main(String[] args) {
        Bai4.run();
    }

    public static void run() {
        Random rd = new Random();

        int a = rd.nextInt(10,20);
        int b = rd.nextInt(10,20);
        int c = rd.nextInt(10,20);
        int d = rd.nextInt(10,20);
        long S = giaiThua(a) + giaiThua(b) + giaiThua(c) + giaiThua(d);

        System.out.println("Các số ngẫu nhiên: a=" + a + ", b=" + b + ", c=" + c + ", d=" + d);
        System.out.println("Tổng giai thừa: " + S);
    }

    public static long giaiThua(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
