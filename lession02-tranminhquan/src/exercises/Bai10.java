package exercises;

import java.util.ArrayList;
import java.util.Random;

public class Bai10 {
    public static void main(String[] args) {
        Random rd = new Random();
        ArrayList<Integer> n = new ArrayList<>();

        while (n.size() < 5) {
            int num = rd.nextInt(20,30);
            
            if (!n.contains(num)) {
                n.add(num);
            }
        }

        System.out.println("5 số ngẫu nhiên (không trùng nhau) từ 20 đến 30 là:");
        for (int number : n) {
            System.out.print(number + " ");
        }
    }
}
