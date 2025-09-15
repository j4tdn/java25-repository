package lesson02_NguyenVanTai;

import java.util.Random;

public class Bai10 {
    public static void main(String[] args) {
        int[] array = new int[5];
        Random rd = new Random();

        for (int i = 0; i < array.length; i++) {
            int x;
            do {
              
                x =20+ rd.nextInt(30 - 20 + 1) ;
            } while (exist(array,  x)); 

            array[i] = x; 
        }

    
        System.out.printf("5 số ngẫu nhiên không trùng nhau từ 20 đến 30: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

  
    private static boolean exist(int[] arr, int x) {
        for (int value : arr) {
            if (value == x) {
                return true;
            }
        }
        return false; 
    }

}
