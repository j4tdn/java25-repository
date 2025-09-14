package exhomework;

import java.util.Random;

public class Ex10 {
    public static void main(String[] args) {
        Random ip = new Random();
        int[] array = new int[5];   
        int count = 0;

        while (count < 5) {
            int number = ip.nextInt(11) + 20;
            boolean check = false;

            // check trùng lặp
            for (int i = 0; i < count; i++) {
                if (array[i] == number) {
                    check = true;
                    break; 
                }
            }

            
            if (!check) {
                array[count] = number;
                count++;
                System.out.println("a["+ count+ "] = " + number);
            }
        }
    }
}