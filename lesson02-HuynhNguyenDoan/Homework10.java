package homework;

import java.util.Random;

public class Homework10 {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] arr = new int[5];
        int count = 0;

        while (count < 5) {
            int num = rd.nextInt(20, 30);
            boolean sameNumber = false;

            for (int i = 0; i < count; i++) {
                if (arr[i] == num) {
                    sameNumber = true;
                    break;
                }
            }

            if (!sameNumber) {
                arr[count] = num;
                count++;
            }
        }

        System.out.print("So ngau nhien khac nhau la: ");
        for (int number : arr) {
            System.out.print(number + " ");
        }
    }
}